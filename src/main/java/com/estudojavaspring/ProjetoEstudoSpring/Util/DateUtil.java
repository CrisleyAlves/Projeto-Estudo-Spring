package com.estudojavaspring.ProjetoEstudoSpring.Util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Crisley on 23/09/2017.
 */

@Component
public class DateUtil {

    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-yy HH:mm:ss").format(localDateTime);
    }

}
