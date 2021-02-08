package com.ilia.projeto.models.enums;

import com.ilia.projeto.models.Ponto;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public enum MonthType {
    JANEIRO{
        @Override
      public LocalDate getDate(){
            return LocalDate.now().withMonth(1).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    FEVEREIRO{
        @Override
        public LocalDate getDate(){
            return LocalDate.now().withMonth(2).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    MARCO{
        @Override
        public LocalDate getDate(){
            return LocalDate.now().withMonth(3).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    ABRIL{
        @Override
        public LocalDate getDate(){
            return LocalDate.now().withMonth(4).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    MAIO{
        @Override
        public LocalDate getDate(){
            return LocalDate.now().withMonth(5).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    JUNHO{
        @Override
        public LocalDate getDate(){

            return LocalDate.now().withMonth(6).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    JULHO{
        @Override
        public LocalDate getDate(){
            return LocalDate.now().withMonth(7).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    AGOSTO{
        @Override
        public LocalDate getDate(){
            return LocalDate.now().withMonth(8).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    SETEMBRO{
        @Override
        public LocalDate getDate(){
            return LocalDate.now().withMonth(9).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    OUTUBRO{
        @Override
        public LocalDate getDate(){
            return LocalDate.now().withMonth(10).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    NOVEMBRO{
        @Override
        public LocalDate getDate(){
            return LocalDate.now().withMonth(11).with(TemporalAdjusters.lastDayOfMonth());
        }

    },
    DEZEMBRO{
        @Override
        public LocalDate getDate(){
            return LocalDate.now().withMonth(12).with(TemporalAdjusters.lastDayOfMonth());
        }
    };

    public abstract LocalDate getDate();
}
