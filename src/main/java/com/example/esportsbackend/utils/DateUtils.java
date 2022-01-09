package com.example.esportsbackend.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String joinedDateToString(Date joinedAtTime){
        try{
            return joinedAtTime.toString();
        }catch(Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    public static Date joinedAtToDate(String joinedAtTime) throws ParseException {
        return new SimpleDateFormat("dd/mm/yyyy").parse(joinedAtTime);
    }
}
