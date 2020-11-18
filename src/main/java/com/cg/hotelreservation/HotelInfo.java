package com.cg.hotelreservation;

public class HotelInfo {
    private String hotel_name;
    private  int rateWeekday_regular;
    private int rateWeekend_regular;
    private  int rateWeekday_reward;
    private int rateWeekend_reward;
    private int rating;


    public HotelInfo(String hotel_name, int rateWeekday, int rateWeekend) {
        this.hotel_name = hotel_name;
        this.rateWeekday_regular = rateWeekday;
        this.rateWeekend_regular = rateWeekend;
    }

    public HotelInfo(String hotelName, int rateWeekday) {
        this.hotel_name=hotelName;
        this.rateWeekday_regular =rateWeekday;
    }

    public HotelInfo(String hotel_name, int rateWeekday, int rateWeekend, int rating) {
        this.hotel_name = hotel_name;
        this.rateWeekday_regular = rateWeekday;
        this.rateWeekend_regular = rateWeekend;
        this.rating = rating;
    }

    public HotelInfo(String hotel_name, int rateWeekday_regular, int rateWeekend_regular, int rateWeekday_reward, int rateWeekend_reward, int rating) {
        this.hotel_name = hotel_name;
        this.rateWeekday_regular = rateWeekday_regular;
        this.rateWeekend_regular = rateWeekend_regular;
        this.rateWeekday_reward = rateWeekday_reward;
        this.rateWeekend_reward = rateWeekend_reward;
        this.rating = rating;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public int getRateWeekday_regular() {
        return rateWeekday_regular;
    }

    public int getRateWeekend_regular() {
        return rateWeekend_regular;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public void setRateWeekday_regular(int rateWeekday_regular) {
        this.rateWeekday_regular = rateWeekday_regular;
    }

    public void setRateWeekend_regular(int rateWeekend_regular) {
        this.rateWeekend_regular = rateWeekend_regular;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "HotelInfo{" +
                "hotel_name='" + hotel_name + '\'' +
                ", rateWeekday=" + rateWeekday_regular +
                ", rateWeekend=" + rateWeekend_regular +
                ", rating=" + rating +
                '}';
    }

    public int getRateWeekday_reward() {
        return rateWeekday_reward;
    }

    public int getRateWeekend_reward() {
        return rateWeekend_reward;
    }
}
