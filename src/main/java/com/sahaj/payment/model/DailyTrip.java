package com.sahaj.payment.model;

import com.sahaj.payment.constants.DayOfWeek;
import com.sahaj.payment.constants.ZoneType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class DailyTrip extends Trip{
    private Integer dailyFare;

    @Builder
    public DailyTrip(DayOfWeek dayOfWeek,ZoneType fromZone,ZoneType toZone,Integer dailyFare){
        super(dayOfWeek,fromZone, toZone);
        this.dailyFare=dailyFare;
    }
}
