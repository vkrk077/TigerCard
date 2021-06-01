package com.sahaj.payment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sahaj.payment.constants.DayOfWeek;
import com.sahaj.payment.constants.ZoneType;
import lombok.Builder;
import lombok.Getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class SingleTrip extends Trip{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date travelTime;


    @Builder
    public SingleTrip(DayOfWeek dayOfWeek,ZoneType fromZone,ZoneType toZone,String travelTime) throws ParseException {
        super(dayOfWeek,fromZone, toZone);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        this.travelTime=sdf.parse(travelTime);
    }
}
