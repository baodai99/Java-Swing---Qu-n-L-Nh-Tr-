/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Quoc Cuong
 */
public class room {
    private String room_ID;
    private String type_room;
    private int number_floor;
    private double price;
    private String status_room;
    private int number_person;

    public room() {
    }
    public room(String room_ID,String type_room)
    {
        
    }
    public room(String room_ID, String type_room, int number_floor, double price, String status_room, int number_person) {
        this.room_ID = room_ID;
        this.type_room = type_room;
        this.number_floor = number_floor;
        this.price = price;
        this.status_room = status_room;
        this.number_person = number_person;
    }

    public room(String room_ID, String type_room, int number_floor, double price, String status_room) {
        this.room_ID = room_ID;
        this.type_room = type_room;
        this.number_floor = number_floor;
        this.price = price;
        this.status_room = status_room;
    }
    

    public String getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(String room_ID) {
        this.room_ID = room_ID;
    }

    public String getType_room() {
        return type_room;
    }

    public void setType_room(String type_room) {
        this.type_room = type_room;
    }

    public int getNumber_floor() {
        return number_floor;
    }

    public void setNumber_floor(int number_floor) {
        this.number_floor = number_floor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus_room() {
        return status_room;
    }

    public void setStatus_room(String status_room) {
        this.status_room = status_room;
    }

    public int getNumber_person() {
        return number_person;
    }

    public void setNumber_person(int number_person) {
        this.number_person = number_person;
    }

    @Override
    public String toString() {
        return "room{" + "room_ID=" + room_ID + ", type_room=" + type_room + ", number_floor=" + number_floor + ", price=" + price + ", status_room=" + status_room + ", number_person=" + number_person + '}';
    }
    
}
