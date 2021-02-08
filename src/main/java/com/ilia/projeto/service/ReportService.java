package com.ilia.projeto.service;


import com.ilia.projeto.models.Ponto;
import com.ilia.projeto.models.Report;
import com.ilia.projeto.models.ResponseReportTimeInProject;
import com.ilia.projeto.models.enums.MonthType;
import com.ilia.projeto.models.enums.PointType;
import com.ilia.projeto.repository.PointRepository;
import com.ilia.projeto.repository.ProjectRepository;
import com.ilia.projeto.repository.UserRepository;
import com.ilia.projeto.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ReportService {
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;
    public ResponseEntity<?> reportByMonth(String mes) {
        var users = this.userRepository.findAll();
        LocalDate dateFinal = MonthType.valueOf(mes).getDate();
        LocalDate dateInital = dateFinal.withDayOfMonth(1);
        var projects= this.projectRepository.findByCreatedAtBetween(dateInital,dateFinal);
        var pontos = this.pointRepository.findByCreatedAtBetween(dateInital, dateFinal);
        List<Report> reports = new ArrayList<Report>();

       users.stream().forEach(user -> {
            reports.add(Report.builder().nomeUsuario(user.getLogin()).
                    horasExcedentes(user.getExtraHours()).horasDevidas(user.getMissingHours())
            .id(user.getId()).build());
       });
        reports.stream().forEach(report -> {
           var list = pontos.stream().filter(ponto -> Objects.nonNull(ponto.getUser()) && ponto.getUser().getId() == report.getId())
                   .collect(Collectors.toList());
           report.setHorariosRegistrados(list);
        });

        reports.stream().forEach(report -> {
           var p = projects.stream().map(project ->{
               if(Objects.nonNull(project.getUser()) &&
                   report.getNomeUsuario() == project.getUser().getLogin()){
                   return ResponseReportTimeInProject.builder().horasTrabalhadas(project.getHoursDedicated()).nameProjeto(project.getName()).build();
               }
               return null;
           }).collect(Collectors.toList());
        report.setProjetos(p);
        });
        return ResponseEntity.status(HttpStatus.OK).body(reports);
    }

}
