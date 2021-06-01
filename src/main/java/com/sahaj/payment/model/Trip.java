package com.sahaj.payment.model;

import com.sahaj.payment.constants.DayOfWeek;
import com.sahaj.payment.constants.ZoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public abstract class Trip {
    private DayOfWeek dayOfWeek;
    private ZoneType fromZone;
    private ZoneType toZone;
}
