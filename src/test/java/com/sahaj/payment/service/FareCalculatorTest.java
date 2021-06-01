package com.sahaj.payment.service;

import com.sahaj.payment.constants.DayOfWeek;
import com.sahaj.payment.constants.ZoneType;
import com.sahaj.payment.model.DailyTrip;
import com.sahaj.payment.model.SingleTrip;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FareCalculatorTest {
    @Test
    public void validateIfDailyCapReached() throws Exception {
        List<SingleTrip> trips =new ArrayList<>();

        trips.add(SingleTrip.builder()
                .dayOfWeek(DayOfWeek.MONDAY)
                .travelTime("10:20")
                .fromZone(ZoneType.TWO)
                .toZone(ZoneType.ONE)
                .build());

        trips.add(SingleTrip.builder()
                .dayOfWeek(DayOfWeek.MONDAY)
                .travelTime("10:45")
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.ONE)
                .build());

        trips.add(SingleTrip.builder()
                .dayOfWeek(DayOfWeek.MONDAY)
                .travelTime("16:15")
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.ONE)
                .build());

        trips.add(SingleTrip.builder()
                .dayOfWeek(DayOfWeek.MONDAY)
                .travelTime("18:15")
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.ONE)
                .build());

        trips.add(SingleTrip.builder()
                .dayOfWeek(DayOfWeek.MONDAY)
                .travelTime("19:00")
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.TWO)
                .build());

        DailyFareCalculator fareCalculator = new DailyFareCalculator();
        assertEquals(120,fareCalculator.calculateDailyFare(trips));

    }

    @Test
    public void validateIfWeeklyCapReached(){
        List<DailyTrip> trips = new ArrayList<>();

        trips.add(DailyTrip.builder()
                .dayOfWeek(DayOfWeek.MONDAY)
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.TWO)
                .dailyFare(120)
                .build());

        trips.add(DailyTrip.builder()
                .dayOfWeek(DayOfWeek.TUESDAY)
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.TWO)
                .dailyFare(120)
                .build());

        trips.add(DailyTrip.builder()
                .dayOfWeek(DayOfWeek.WEDNESDAY)
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.TWO)
                .dailyFare(120)
                .build());

        trips.add(DailyTrip.builder()
                .dayOfWeek(DayOfWeek.THURSDAY)
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.TWO)
                .dailyFare(120)
                .build());

        trips.add(DailyTrip.builder()
                .dayOfWeek(DayOfWeek.FRIDAY)
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.ONE)
                .dailyFare(80)
                .build());

        trips.add(DailyTrip.builder()
                .dayOfWeek(DayOfWeek.SATURDAY)
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.TWO)
                .dailyFare(40)
                .build());

        trips.add(DailyTrip.builder()
                .dayOfWeek(DayOfWeek.MONDAY)
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.ONE)
                .dailyFare(0)
                .build());

        trips.add(DailyTrip.builder()
                .dayOfWeek(DayOfWeek.MONDAY)
                .fromZone(ZoneType.ONE)
                .toZone(ZoneType.ONE)
                .dailyFare(100)
                .build());

        WeeklyFareCalculator fareCalculator = new WeeklyFareCalculator();
        assertEquals(700, fareCalculator.calculateWeeklyFare(trips));

    }
}
