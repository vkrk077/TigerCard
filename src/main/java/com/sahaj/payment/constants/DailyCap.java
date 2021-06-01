package com.sahaj.payment.constants;

public enum DailyCap {
    ZONE_ONE(100),ZONE_TWO(80),OTHERS(120);

    DailyCap(int capAmount){
        this.capAmount=capAmount;
    }

    private int capAmount;

    public int getCapAmount(){
        return this.capAmount;
    }
}
