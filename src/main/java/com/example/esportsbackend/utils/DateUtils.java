package com.example.esportsbackend.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Timestamp parseTimeStamp(String timestamp){
        try{
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        }catch(ParseException e){
            throw new IllegalArgumentException(e);
        }
    }
}
