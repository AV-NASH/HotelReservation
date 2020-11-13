package com.cg.hotelreservation;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HotelReservationTest {
    @Test
    public void whenHotelAddedShouldMatchCount() {
        HotelReservation hotelReservation=new HotelReservation();
        hotelReservation.addNewHotel("Lakewood",110);
        hotelReservation.addNewHotel("Bridgewood",160);
        hotelReservation.addNewHotel("Ridgewood",220);
        ArrayList<HotelInfo> hotelInfos=hotelReservation.getHotelInfos();
        Assert.assertEquals(3,hotelInfos.size());
    }
}