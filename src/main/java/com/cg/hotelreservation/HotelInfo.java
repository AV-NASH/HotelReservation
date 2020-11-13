package com.cg.hotelreservation;

public class HotelInfo {
    private String hotel_name;
    private  int rate;

    public HotelInfo(String hotel_name, int rate) {
        this.hotel_name = hotel_name;
        this.rate = rate;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public int getRate() {
        return rate;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
