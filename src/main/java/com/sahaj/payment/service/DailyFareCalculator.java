package com.sahaj.payment.service;

import com.sahaj.payment.constants.DailyCap;
import com.sahaj.payment.constants.ZoneType;
import com.sahaj.payment.model.SingleTrip;
import com.sahaj.payment.util.DateUtil;

import java.util.List;

public class DailyFareCalculator {
    DateUtil dateUtil = new DateUtil();

    public int calculateDailyFare(List<SingleTrip> singleTrips) throws Exception{
        int totalFare=0;

        for(SingleTrip trip:singleTrips){
            if(isDailyCapReached(trip,totalFare)){
                totalFare += calculateCapAmount(trip,totalFare);
            }
            else {
                totalFare += calculateSingleFare(trip);
            }
        }

        return totalFare;
    }

    private int calculateCapAmount(SingleTrip trip, int prevFare) {
        if(trip.getFromZone().equals(ZoneType.ONE) && trip.getToZone().equals(ZoneType.ONE)){
            return (DailyCap.ZONE_ONE.getCapAmount()-prevFare);
        }
        else if(trip.getFromZone().equals(ZoneType.TWO) && trip.getToZone().equals(ZoneType.TWO)){
            return (DailyCap.ZONE_TWO.getCapAmount()-prevFare);
        }
        else{
            return (DailyCap.OTHERS.getCapAmount()-prevFare);
        }
    }

    private boolean isDailyCapReached(SingleTrip trip, int prevFare) throws Exception{
        if(trip.getFromZone().equals(ZoneType.ONE) && trip.getToZone().equals(ZoneType.ONE)){
            return (DailyCap.ZONE_ONE.getCapAmount()-prevFare)<(dateUtil.isPeak(trip)?30:25);
        }
        else if(trip.getFromZone().equals(ZoneType.TWO) && trip.getToZone().equals(ZoneType.TWO)){
            return (DailyCap.ZONE_TWO.getCapAmount()-prevFare)<(dateUtil.isPeak(trip)?25:20);
        }
        else{
            return (DailyCap.OTHERS.getCapAmount()-prevFare)<(dateUtil.isPeak(trip)?35:30);
        }
    }

    private int calculateSingleFare(SingleTrip trip) throws Exception{
        Boolean isPeak = dateUtil.isPeak(trip);

        if(trip.getFromZone().equals(ZoneType.ONE) && trip.getFromZone().equals(ZoneType.ONE)){
            if(isPeak){
                return 30;
            }
            return 25;
        }
        else if(trip.getFromZone().equals(ZoneType.TWO) && trip.getFromZone().equals(ZoneType.TWO)){
            if(isPeak){
                return 25;
            }
            return 20;
        }
        else{
            if(isPeak){
                return 35;
            }
            return 30;
        }
    }
}
