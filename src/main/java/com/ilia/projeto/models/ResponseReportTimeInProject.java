package com.ilia.projeto.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseReportTimeInProject {

    private String nameProjeto;

    private Long horasTrabalhadas;

}
