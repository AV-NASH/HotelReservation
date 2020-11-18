package com.cg.hotelreservation;

public class HotelInfo {
    private String hotel_name;
    private  int rateWeekday;
    private int rateWeekend;
    private int rating;


    public HotelInfo(String hotel_name, int rateWeekday, int rateWeekend) {
        this.hotel_name = hotel_name;
        this.rateWeekday = rateWeekday;
        this.rateWeekend = rateWeekend;
    }

    public HotelInfo(String hotelName, int rateWeekday) {
        this.hotel_name=hotelName;
        this.rateWeekday=rateWeekday;
    }

    public HotelInfo(String hotel_name, int rateWeekday, int rateWeekend, int rating) {
        this.hotel_name = hotel_name;
        this.rateWeekday = rateWeekday;
        this.rateWeekend = rateWeekend;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "HotelInfo{" +
                "hotel_name='" + hotel_name + '\'' +
                ", rateWeekday=" + rateWeekday +
                ", rateWeekend=" + rateWeekend +
                ", rating=" + rating +
                '}';
    }
}
