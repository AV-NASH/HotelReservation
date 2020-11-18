package com.cg.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HotelReservation {
    private ArrayList<HotelInfo> hotelInfos=new ArrayList<>();
    private String cheapestHotel;
    private  int hotelRate;
    private  int hotelRating;
    private boolean customerTypeBoolean;

    public ArrayList<HotelInfo> getHotelInfos() {
        return hotelInfos;
    }

    public void setHotelInfos(ArrayList<HotelInfo> hotelInfos) {
        this.hotelInfos = hotelInfos;
    }

    public void addNewHotel(String hotelName, int rateWeekday_regular, int rateWeekend_regular,int rateWeekday_reward, int rateWeekend_reward, int rating) {
        hotelInfos.add(new HotelInfo(hotelName,rateWeekday_regular,rateWeekend_regular,rateWeekday_reward,rateWeekend_reward,rating));
    }

    public void findCheapestHotel(String startDate, String endDate,String customerType) throws InvalidDateException, InvalidCustomerTypeException {
        validateDate(startDate,endDate);
        validateCustomerType(customerType);
        LocalDate start=LocalDate.parse(startDate);
        LocalDate end=LocalDate.parse(endDate);
        setCustomerType(customerType);

        if(customerTypeBoolean)
        {
        Optional<HotelInfo> cheapesthotelOptionalObj=hotelInfos.stream().reduce((hotelInfo1, hotelInfo2) ->
                ((calculateRentRegular(hotelInfo1,start,end)< calculateRentRegular(hotelInfo2,start,end))||
                        ((hotelInfo1.getRating()>hotelInfo2.getRating())&&
                                (calculateRentRegular(hotelInfo1,start,end)<= calculateRentRegular(hotelInfo2,start,end))))?hotelInfo1:hotelInfo2);


       HotelInfo cheapestHotelObj= cheapesthotelOptionalObj.get();
      ArrayList<HotelInfo> cheapestHotelList=new ArrayList<>(hotelInfos.stream().filter(p->((calculateRentRegular(p,start,end)== calculateRentRegular(cheapestHotelObj,start,end))&&(p.getRating()==cheapestHotelObj.getRating()))).collect(Collectors.toList()));
      cheapestHotel="";
      cheapestHotelList.stream().forEach(p->cheapestHotel=cheapestHotel+p.getHotel_name());
       hotelRate= calculateRentRegular(cheapestHotelObj,start,end);
       hotelRating=cheapestHotelObj.getRating();
        }
        else{
            Optional<HotelInfo> cheapesthotelOptionalObj=hotelInfos.stream().reduce((hotelInfo1, hotelInfo2) ->
                    (calculateRentReward(hotelInfo1,start,end)< calculateRentReward(hotelInfo2,start,end)||(hotelInfo1.getRating()>hotelInfo2.getRating()&& calculateRentReward(hotelInfo1,start,end)<= calculateRentReward(hotelInfo2,start,end)))?hotelInfo1:hotelInfo2);


            HotelInfo cheapestHotelObj= cheapesthotelOptionalObj.get();
            ArrayList<HotelInfo> cheapestHotelList=new ArrayList<>(hotelInfos.stream().filter(p->((calculateRentReward(p,start,end)== calculateRentReward(cheapestHotelObj,start,end))&&(p.getRating()==cheapestHotelObj.getRating()))).collect(Collectors.toList()));
            cheapestHotel="";
            cheapestHotelList.stream().forEach(p->cheapestHotel=cheapestHotel+p.getHotel_name());
            hotelRate= calculateRentReward(cheapestHotelObj,start,end);
            hotelRating=cheapestHotelObj.getRating();
        }
    }

    private void setCustomerType(String customerType) {
        if(customerType.toLowerCase().equals("regular")) customerTypeBoolean=true;
        else customerTypeBoolean=false;
    }

    private void validateCustomerType(String customerType) throws InvalidCustomerTypeException {
        if(!(customerType.toLowerCase().equals("regular")||customerType.toLowerCase().equals("reward")))
            throw new InvalidCustomerTypeException("Invalid Customer type ...please enter type as either 'reward' or 'regular'");
    }

    private void validateDate(String startDate, String endDate) throws InvalidDateException {
        String regex="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
        boolean check= (Pattern.matches(regex,startDate)&&Pattern.matches(regex,endDate));
        if(!check) throw new InvalidDateException("Invalid  date format please enter in yyyy-mm-dd format");
    }

    private int calculateRentRegular(HotelInfo hotelInfo, LocalDate start, LocalDate end) {
        int rent=0;
        for(LocalDate localDate=start;localDate.isBefore(end)||localDate.isEqual(end);localDate=localDate.plusDays(1)){
          if(localDate.getDayOfWeek().name().toLowerCase().equals("saturday")||localDate.getDayOfWeek().name().toLowerCase().equals("sunday"))
              rent=rent+hotelInfo.getRateWeekend_regular();
          else rent=rent+hotelInfo.getRateWeekday_regular();
        }
        return rent;
    }

    private int calculateRentReward(HotelInfo hotelInfo, LocalDate start, LocalDate end) {
        int rent=0;
        for(LocalDate localDate=start;localDate.isBefore(end)||localDate.isEqual(end);localDate=localDate.plusDays(1)){
            if(localDate.getDayOfWeek().name().toLowerCase().equals("saturday")||localDate.getDayOfWeek().name().toLowerCase().equals("sunday"))
                rent=rent+hotelInfo.getRateWeekend_reward();
            else rent=rent+hotelInfo.getRateWeekday_reward();
        }
        return rent;
    }


    public void findBestRatedHotel(String startDate, String endDate,String customerType) throws InvalidDateException, InvalidCustomerTypeException {
        validateDate(startDate,endDate);
        validateCustomerType(customerType);
        LocalDate start=LocalDate.parse(startDate);
        LocalDate end=LocalDate.parse(endDate);
        setCustomerType(customerType);

        Optional<HotelInfo> cheapesthotelOptionalObj=hotelInfos.stream().reduce((hotelInfo1, hotelInfo2) ->hotelInfo1.getRating()>hotelInfo2.getRating()?hotelInfo1:hotelInfo2);
        HotelInfo cheapestHotelObj= cheapesthotelOptionalObj.get();
        ArrayList<HotelInfo> cheapestHotelList=new ArrayList<HotelInfo>(hotelInfos.stream().filter(p->p.getRating()==cheapestHotelObj.getRating()).collect(Collectors.toList()));
        cheapestHotel="";
        cheapestHotelList.stream().forEach(p->cheapestHotel=cheapestHotel+p.getHotel_name());
        if(customerTypeBoolean)
        hotelRate= calculateRentRegular(cheapestHotelObj,start,end);
        else hotelRate=calculateRentReward(cheapestHotelObj,start,end);
        hotelRating=cheapestHotelObj.getRating();
    }

    public String getCheapestHotel() {
        return cheapestHotel;
    }

    public int getHotelRate() {
        return hotelRate;
    }


    public int getHotelRating() {
        return hotelRating;
    }
}
