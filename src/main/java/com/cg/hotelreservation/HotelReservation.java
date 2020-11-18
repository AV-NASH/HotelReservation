package com.cg.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void addNewHotel(String hotelName, int rateWeekday, int rateWeekend, int rating) {
        hotelInfos.add(new HotelInfo(hotelName,rateWeekday,rateWeekend));
    }

    public void findCheapestHotel(LocalDate start, LocalDate end) {

        Optional<HotelInfo> cheapesthotelOptionalObj=hotelInfos.stream().reduce((hotelInfo1, hotelInfo2) ->
        calculateRent(hotelInfo1,start,end)<calculateRent(hotelInfo2,start,end)?hotelInfo1:hotelInfo2);


       HotelInfo cheapestHotelObj= cheapesthotelOptionalObj.get();
       cheapestHotel="";
      ArrayList<HotelInfo> cheapestHotelList=new ArrayList<>(hotelInfos.stream().filter(p->calculateRent(p,start,end)==calculateRent(cheapestHotelObj,start,end)).collect(Collectors.toList()));
      cheapestHotelList.stream().forEach(p->cheapestHotel=cheapestHotel+p.getHotel_name()+" ");
       hotelRate=calculateRent(cheapestHotelObj,start,end);
    }

    private int calculateRent(HotelInfo hotelInfo,LocalDate start,LocalDate end) {
        int rent=0;
        for(LocalDate localDate=start;localDate.isBefore(end)||localDate.isEqual(end);localDate=localDate.plusDays(1)){
          if(localDate.getDayOfWeek().name().toLowerCase().equals("saturday")||localDate.getDayOfWeek().name().toLowerCase().equals("sunday"))
              rent=rent+hotelInfo.getRateWeekend();
          else rent=rent+hotelInfo.getRateWeekday();
        }
        return rent;
    }

    public String getCheapestHotel() {
        return cheapestHotel;
    }

    public int getHotelRate() {
        return hotelRate;
    }


}
