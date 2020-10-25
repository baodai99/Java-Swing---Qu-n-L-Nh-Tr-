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
public class Bill {
    private String bill_ID;
    private String room_ID;
    private String customer_ID;
    private String month;
    private double service_money;

    public Bill() {
    }

    public Bill(String bill_ID, String room_ID, String customer_ID, String month, double service_money) {
        this.bill_ID = bill_ID;
        this.room_ID = room_ID;
        this.customer_ID = customer_ID;
        this.month = month;
        this.service_money = service_money;
    }

    public String getBill_ID() {
        return bill_ID;
    }

    public void setBill_ID(String bill_ID) {
        this.bill_ID = bill_ID;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getService_money() {
        return service_money;
    }

    public void setService_money(double service_money) {
        this.service_money = service_money;
    }

    @Override
    public String toString() {
        return "Bill{" + "bill_ID=" + bill_ID + ", room_ID=" + room_ID + ", customer_ID=" + customer_ID + ", month=" + month + ", service_money=" + service_money + '}';
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
