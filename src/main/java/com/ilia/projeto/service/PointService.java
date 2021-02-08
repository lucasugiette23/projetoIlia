package com.ilia.projeto.service;


import com.ilia.projeto.models.Ponto;
import com.ilia.projeto.models.User;
import com.ilia.projeto.models.enums.PointType;
import com.ilia.projeto.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ilia.projeto.repository.PointRepository;
import com.ilia.projeto.repository.UserRepository;
;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Service
public class PointService {
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> baterPonto(Long id, String hourPoint) {
        var user = this.userRepository.findById(id).orElseThrow();
        var ponto = this.pointRepository.findByCreatedAtAndUserId(LocalDate.now(), user.getId()).orElse(Ponto.builder().user(user).build());
        var retorno = PointType.valueOf(hourPoint).objeTipoPonto(ponto);
        if(hourPoint.equals(PointType.LASTOUTYPE.toString())){
            retorno = DateUtil.calcHoursMissingOrExtra(retorno);
        }
        if(hourPoint.equals(PointType.LASTINTYPE.toString())){
            long hours = ChronoUnit.HOURS.between(retorno.getFirstOutDate(), LocalDateTime.now());
            if(hours <= 1L){
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Deve haver no mínimo 1 hora de almoço");
            }
        }
        return DateUtil.validaFimSemana() ? ResponseEntity.status(HttpStatus.CREATED).body(this.pointRepository.save(retorno)) :
                ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Sábado e domingo não são permitidos como dia de trabalho");
    }

}
