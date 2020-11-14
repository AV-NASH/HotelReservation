package com.cg.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class HotelReservation {
    private ArrayList<HotelInfo> hotelInfos=new ArrayList<>();
    private String cheapestHotel;
    private  int hotelRate;

    public ArrayList<HotelInfo> getHotelInfos() {
        return hotelInfos;
    }

    public void setHotelInfos(ArrayList<HotelInfo> hotelInfos) {
        this.hotelInfos = hotelInfos;
    }

    public void addNewHotel(String hotelName, int rateWeekday, int rateWeekend) {
        hotelInfos.add(new HotelInfo(hotelName,rateWeekday,rateWeekend));
    }

    public void findCheapestHotel(LocalDate start, LocalDate end) {
        int[] no_of_days=new int[1];
         no_of_days[0]=0;
        for(LocalDate localDate=start;localDate.isBefore(end)||localDate.isEqual(end);localDate=localDate.plusDays(1)){
            no_of_days[0]++;
        }
        Optional<HotelInfo> cheapesthotelOptionalObj=hotelInfos.stream().reduce((hotelInfo1, hotelInfo2) ->
        calculateRent(hotelInfo1,no_of_days[0])<calculateRent(hotelInfo2,no_of_days[0])?hotelInfo1:hotelInfo2);

       HotelInfo cheapestHotelObj= cheapesthotelOptionalObj.get();
       cheapestHotel=cheapestHotelObj.getHotel_name();
       hotelRate=calculateRent(cheapestHotelObj,no_of_days[0]);
    }

    private int calculateRent(HotelInfo hotelInfo,int no_of_days) {
        return hotelInfo.getRateWeekday()*no_of_days;
    }

    public String getCheapestHotel() {
        return cheapestHotel;
    }

    public int getHotelRate() {
        return hotelRate;
    }


}
