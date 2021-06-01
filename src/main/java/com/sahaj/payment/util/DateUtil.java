package com.sahaj.payment.util;

import com.sahaj.payment.constants.DayOfWeek;
import com.sahaj.payment.model.SingleTrip;

import java.text.SimpleDateFormat;

public class DateUtil {
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    public Boolean isPeak(SingleTrip trip) throws Exception{
        boolean isWeekend = trip.getDayOfWeek().equals(DayOfWeek.SATURDAY) || trip.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        if(isWeekend){
            boolean isPeakMorning = trip.getTravelTime().after(sdf.parse("09:00")) && trip.getTravelTime().before(sdf.parse("11:00"));
            boolean isPeakEvening = trip.getTravelTime().after(sdf.parse("18:00")) && trip.getTravelTime().before(sdf.parse("22:00"));

            return isPeakEvening || isPeakMorning;
        }

        boolean isPeakMorning = trip.getTravelTime().after(sdf.parse("07:00")) && trip.getTravelTime().before(sdf.parse("10:30"));
        boolean isPeakEvening = trip.getTravelTime().after(sdf.parse("17:00")) && trip.getTravelTime().before(sdf.parse("20:00"));

        return isPeakEvening || isPeakMorning;
    }
}
