package com.cg.hotelreservation;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class HotelReservationTest {
    @Test
    public void whenHotelAddedShouldMatchCount() {
        HotelReservation hotelReservation=new HotelReservation();
        hotelReservation.addNewHotel("Lakewood",110,90,3);
        hotelReservation.addNewHotel("Bridgewood",160,50,4);
        hotelReservation.addNewHotel("Ridgewood",220,150,5);
        ArrayList<HotelInfo> hotelInfos=hotelReservation.getHotelInfos();
        Assert.assertEquals(3,hotelInfos.size());
    }

    @Test
    public void givenDateRangeShouldReturnCheapestHotel() {
        HotelReservation hotelReservation=new HotelReservation();
        hotelReservation.addNewHotel("Lakewood",110,90,3);
        hotelReservation.addNewHotel("Bridgewood",150,50,4);
        hotelReservation.addNewHotel("Ridgewood",220,150,5);
        hotelReservation.findCheapestHotel(LocalDate.of(2020,11,13),
                                              LocalDate.of(2020,11,14));


       Assert.assertEquals("Bridgewood",hotelReservation.getCheapestHotel());
       Assert.assertEquals(200,hotelReservation.getHotelRate());
       Assert.assertEquals(4,hotelReservation.getHotelRating());

    }
}