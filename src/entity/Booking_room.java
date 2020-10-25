/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Quoc Cuong
 */
public class Booking_room {
    private String room_ID;
    private String customer_ID;
    private String date_hire;

    public Booking_room() {
    }

    public Booking_room(String room_ID, String customer_ID,String  date_hire) {
        this.room_ID = room_ID;
        this.customer_ID = customer_ID;
        this.date_hire = date_hire;
    }

    public String getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(String room_ID) {
        this.room_ID = room_ID;
    }

    public String getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getDate_hire() {
        return date_hire;
    }

    public void setDate_hire(String date_hire) {
        this.date_hire = date_hire;
    }

    @Override
    public String toString() {
        return "Booking_room{" + "room_ID=" + room_ID + ", customer_ID=" + customer_ID + ", date_hire=" + date_hire + '}';
    }
    
}
