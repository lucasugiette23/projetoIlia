package com.ilia.projeto.utils;

import com.ilia.projeto.models.Ponto;
import com.ilia.projeto.models.User;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    public static boolean validaFimSemana(){
        DayOfWeek d = LocalDateTime.now().getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY ? false : true;
    }

    public static Ponto calcHoursMissingOrExtra(Ponto pont){
        long hours = ChronoUnit.HOURS.between(pont.getFirstEntryDate(), pont.getLastOutDate());
        if (hours <= 8) {
            pont.getUser().setMissingHours(hours - 8D);
        } else {
            pont.getUser().setExtraHours(hours - 8D);
        }
        return pont;
    }


}
