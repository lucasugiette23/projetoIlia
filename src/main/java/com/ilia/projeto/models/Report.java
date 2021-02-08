package com.ilia.projeto.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    private Long id;

    private LocalDate createdAt;

    private Double horasTrabalhadas;

    private Double horasExcedentes;

    private Double horasDevidas;

    private Double horasTotais;

    private List<Ponto> horariosRegistrados;

    private List<ResponseReportTimeInProject> projetos;

    private Double totalHours;

    private String nomeUsuario;

}
