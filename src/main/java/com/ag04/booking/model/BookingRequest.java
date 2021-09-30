package com.ag04.booking.model;

public class BookingRequest {

    private int numberOfPersons;
    private int wifiRequred;

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public int getWifiRequred() {
        return wifiRequred;
    }

    public void setWifiRequred(int wifiRequred) {
        this.wifiRequred = wifiRequred;
    }
}
