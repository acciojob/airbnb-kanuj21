package com.driver.controllers;


import com.driver.model.Booking;
import com.driver.model.Hotel;
import com.driver.model.User;

import java.util.HashMap;
import java.util.UUID;
public class HotelManagementRepository {

    private HashMap<String, Hotel> hotelDB = new HashMap<>();
    private HashMap<Integer, User> userDB = new HashMap<>();
    private HashMap<String, Booking> bookingDB = new HashMap<>();
    private HashMap<Integer, Integer> noOfBookingsByUser = new HashMap<>();


    //************Getters**********************
    public HashMap<String, Hotel> getHotelDb() {
        return hotelDB;
    }
    public HashMap<Integer, User> getUserDb() {
        return userDB;
    }

    public HashMap<String, Booking> getBookingDb() {
        return bookingDB;
    }

    public HashMap<Integer, Integer> getNoOfBookingsByUser() {
        return noOfBookingsByUser;
    }

    //******************Setters**********************
    public void setHotelDb(HashMap<String, Hotel> hotelDb) {
        this.hotelDB = hotelDb;
    }

    public void setUserDb(HashMap<Integer, User> userDb) {
        this.userDB = userDb;
    }

    public void setBookingDb(HashMap<String, Booking> bookingDb) {
        this.bookingDB = bookingDb;
    }

    public void setNoOfBookingsByUser(HashMap<Integer, Integer> noOfBookingsByUser) {
        this.noOfBookingsByUser = noOfBookingsByUser;
    }


    //************ADD Hotel to hotelDB**********
    public void addHotel(Hotel hotel) {
        hotelDB.put(hotel.getHotelName(), hotel);
    }


    //*************ADD User to userDB********************
    public void addUser(User user) {
        userDB.put(user.getaadharCardNo(), user);
    }

    //**********make booking and record booking data into bookingDB**********
    public void addBooking(Booking booking) {
        String bookingId = generateBookingId();
        booking.setBookingId(bookingId);
        bookingDB.put(bookingId, booking);
    }

    //**********generate uniq booking ID***************
    private String generateBookingId(){
        return UUID.randomUUID().toString();
    }


    //*************add booking counting*****************
    public void addBookingCountByUser(Integer aadharCardNo) {
        noOfBookingsByUser.put(aadharCardNo, noOfBookingsByUser.getOrDefault(aadharCardNo, 0) + 1);
    }
}
