package com.cg.hotelreservation;

import java.util.ArrayList;

public class HotelReservation {
    private ArrayList<HotelInfo> hotelInfos=new ArrayList<>();

    public ArrayList<HotelInfo> getHotelInfos() {
        return hotelInfos;
    }

    public void setHotelInfos(ArrayList<HotelInfo> hotelInfos) {
        this.hotelInfos = hotelInfos;
    }

    public void addNewHotel(String hotelName, int rate) {
        hotelInfos.add(new HotelInfo(hotelName,rate));
    }
}
