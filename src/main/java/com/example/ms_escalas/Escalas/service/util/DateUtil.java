package com.example.ms_escalas.Escalas.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String datenow(){
        Date time = new Date(System.currentTimeMillis());
        String formatted = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ").format(time);
        return formatted;

    }
}