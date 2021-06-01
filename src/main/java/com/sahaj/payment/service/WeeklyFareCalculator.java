package com.sahaj.payment.service;

import com.sahaj.payment.constants.DayOfWeek;
import com.sahaj.payment.constants.WeeklyCap;
import com.sahaj.payment.constants.ZoneType;
import com.sahaj.payment.model.DailyTrip;

import java.util.List;

public class WeeklyFareCalculator {
    public int calculateWeeklyFare(List<DailyTrip> dailyTrips){
        int totalFare = 0;
        int dailyFare = 0;
        int weeklyFare = 0;

        for(DailyTrip trip:dailyTrips){
            if(trip.getDayOfWeek().equals(DayOfWeek.MONDAY)){
                weeklyFare = 0;
            }

            if(isWeeklyCapReached(trip,weeklyFare)){
                dailyFare = calculateWeeklyCapAmount(trip,weeklyFare);
            }
            else {
                dailyFare = trip.getDailyFare();
            }
            weeklyFare += dailyFare;
            totalFare += dailyFare;
        }
        return totalFare;
    }

    private int calculateWeeklyCapAmount(DailyTrip trip, int prevFare) {
        if(trip.getFromZone().equals(ZoneType.ONE) && trip.getToZone().equals(ZoneType.ONE)){
            return (WeeklyCap.ZONE_ONE.getCapAmount()-prevFare);
        }
        else if(trip.getFromZone().equals(ZoneType.TWO) && trip.getToZone().equals(ZoneType.TWO)){
            return (WeeklyCap.ZONE_TWO.getCapAmount()-prevFare);
        }
        else{
            return (WeeklyCap.OTHERS.getCapAmount()-prevFare);
        }
    }

    private boolean isWeeklyCapReached(DailyTrip trip, int prevFare) {
        if(trip.getFromZone().equals(ZoneType.ONE) && trip.getToZone().equals(ZoneType.ONE)){
            return (WeeklyCap.ZONE_ONE.getCapAmount()<=prevFare);
        }
        else if(trip.getFromZone().equals(ZoneType.TWO) && trip.getToZone().equals(ZoneType.TWO)){
            return (WeeklyCap.ZONE_TWO.getCapAmount()<=prevFare);
        }
        else{
            return (WeeklyCap.OTHERS.getCapAmount()<=prevFare);
        }
    }
}
