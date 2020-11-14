package com.cg.hotelreservation;

public class HotelInfo {
    private String hotel_name;
    private  int rateWeekday;
    private int rateWeekend;


    public HotelInfo(String hotel_name, int rateWeekday, int rateWeekend) {
        this.hotel_name = hotel_name;
        this.rateWeekday = rateWeekday;
        this.rateWeekend = rateWeekend;
    }

    public HotelInfo(String hotelName, int rateWeekday) {
        this.hotel_name=hotelName;
        this.rateWeekday=rateWeekday;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public int getRateWeekday() {
        return rateWeekday;
    }

    public int getRateWeekend() {
        return rateWeekend;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public void setRateWeekday(int rateWeekday) {
        this.rateWeekday = rateWeekday;
    }

    public void setRateWeekend(int rateWeekend) {
        this.rateWeekend = rateWeekend;
    }
}
