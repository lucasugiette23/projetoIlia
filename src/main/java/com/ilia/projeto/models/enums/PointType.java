package com.ilia.projeto.models.enums;


import lombok.Getter;
import com.ilia.projeto.models.Ponto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
public enum PointType {
    FIRSTINTYPE{
        @Override
        public Ponto objeTipoPonto (Ponto point){
             point.setCreatedAt(LocalDate.now());
             point.setFirstEntryDate(LocalDateTime.now());
             return point;
        }
    },
    FIRSTOUTYPE{
        @Override
        public Ponto objeTipoPonto (Ponto point){
            point.setFirstOutDate(LocalDateTime.now());
            return point;
        }
    },
    LASTINTYPE{
        @Override
        public Ponto objeTipoPonto (Ponto point){
            point.setLastEntryDate(LocalDateTime.now());
            return point;
        }
    },
    LASTOUTYPE{
        @Override
        public Ponto objeTipoPonto (Ponto point){
            point.setLastOutDate(LocalDateTime.now());
            point.setTotalHours(ChronoUnit.HOURS.between(point.getFirstEntryDate(), LocalDateTime.now()));
            return point;
        }
    };

    public abstract Ponto objeTipoPonto(Ponto point);

}
