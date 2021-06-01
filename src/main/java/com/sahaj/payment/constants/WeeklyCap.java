package com.sahaj.payment.constants;

public enum WeeklyCap {
    ZONE_ONE(500),ZONE_TWO(400),OTHERS(600);

    WeeklyCap(int capAmount){
        this.capAmount=capAmount;
    }

    private int capAmount;

    public int getCapAmount(){
        return this.capAmount;
    }
}
