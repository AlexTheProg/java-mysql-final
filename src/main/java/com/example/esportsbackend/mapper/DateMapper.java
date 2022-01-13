package com.example.esportsbackend.mapper;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class DateMapper {

    public String asString(Date date){
        return date != null ? new SimpleDateFormat("yyy-MM-dd")
                .format(date) : null;
    }

    public Date asDate(String date){
        try {
            return date != null ? new SimpleDateFormat("yyyy-MM-dd")
                    .parse(date) : null;
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
    }
}
