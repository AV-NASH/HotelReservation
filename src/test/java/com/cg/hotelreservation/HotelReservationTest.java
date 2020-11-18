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
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addNewHotel("Lakewood", 110, 90, 80, 80, 3);
        hotelReservation.addNewHotel("Bridgewood", 160, 50, 110, 50, 4);
        hotelReservation.addNewHotel("Ridgewood", 220, 150, 100, 40, 5);
        ArrayList<HotelInfo> hotelInfos = hotelReservation.getHotelInfos();
        Assert.assertEquals(3, hotelInfos.size());
    }

    @Test
    public void givenDateRangeShouldReturnCheapestHotelForRegular() throws InvalidCustomerTypeException, InvalidDateException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addNewHotel("Lakewood", 110, 90, 80, 80, 3);
        hotelReservation.addNewHotel("Bridgewood", 150, 50, 110, 50, 4);
        hotelReservation.addNewHotel("Ridgewood", 220, 150, 100, 40, 5);
        hotelReservation.findCheapestHotel("2020-11-13", "2020-11-14", "regular");


        Assert.assertEquals("Bridgewood", hotelReservation.getCheapestHotel());
        Assert.assertEquals(200, hotelReservation.getHotelRate());
        Assert.assertEquals(4, hotelReservation.getHotelRating());

    }

    @Test
    public void givenDateRangeShouldReturnBestRatedHotel() throws InvalidCustomerTypeException, InvalidDateException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addNewHotel("Lakewood", 110, 90, 80, 80, 3);
        hotelReservation.addNewHotel("Bridgewood", 160, 50, 110, 50, 4);
        hotelReservation.addNewHotel("Ridgewood", 220, 150, 100, 40, 5);
        hotelReservation.findBestRatedHotel("2020-11-13", "2020-11-14", "regular");


        Assert.assertEquals("Ridgewood", hotelReservation.getCheapestHotel());
        Assert.assertEquals(370, hotelReservation.getHotelRate());
        Assert.assertEquals(5, hotelReservation.getHotelRating());
    }

    @Test(expected = InvalidDateException.class)
    public void givenInvalidDateShouldThrowCustomException() throws InvalidCustomerTypeException, InvalidDateException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addNewHotel("Lakewood", 110, 90, 80, 80, 3);
        hotelReservation.addNewHotel("Bridgewood", 160, 50, 110, 50, 4);
        hotelReservation.addNewHotel("Ridgewood", 220, 150, 100, 40, 5);
        hotelReservation.findBestRatedHotel("11-11-2020", "2020-11-14", "regular");
    }

    @Test(expected = InvalidCustomerTypeException.class)
    public void givenInvalidTypeShouldThrowCustomException() throws InvalidCustomerTypeException, InvalidDateException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addNewHotel("Lakewood", 110, 90, 80, 80, 3);
        hotelReservation.addNewHotel("Bridgewood", 160, 50, 110, 50, 4);
        hotelReservation.addNewHotel("Ridgewood", 220, 150, 100, 40, 5);
        hotelReservation.findBestRatedHotel("11-11-2020", "2020-11-14", "regular");
    }

    @Test
    public void givenDateRangeShouldReturnCheapestHotelForReward() throws InvalidCustomerTypeException, InvalidDateException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addNewHotel("Lakewood", 110, 90, 80, 80, 3);
        hotelReservation.addNewHotel("Bridgewood", 150, 50, 110, 50, 4);
        hotelReservation.addNewHotel("Ridgewood", 220, 150, 100, 40, 5);
        hotelReservation.findCheapestHotel("2020-11-13", "2020-11-14", "reward");


        Assert.assertEquals("Ridgewood", hotelReservation.getCheapestHotel());
        Assert.assertEquals(140, hotelReservation.getHotelRate());
        Assert.assertEquals(5, hotelReservation.getHotelRating());

    }
}