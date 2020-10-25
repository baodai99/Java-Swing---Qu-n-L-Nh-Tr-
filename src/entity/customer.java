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
public class customer {
    private String customer_ID;
    private String customer_name;
    private int customer_age;
    private String customer_address;
    private String customer_gender;
    private String customer_phone;

    public customer() {
    }

    public customer(String customer_ID) {
        this.customer_ID = customer_ID;
    }
    

    public customer(String customer_ID, String customer_name, int customer_age, String customer_address, String customer_gender, String customer_phone) {
        this.customer_ID = customer_ID;
        this.customer_name = customer_name;
        this.customer_age = customer_age;
        this.customer_address = customer_address;
        this.customer_gender = customer_gender;
        this.customer_phone = customer_phone;
    }

    public String getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getCustomer_age() {
        return customer_age;
    }

    public void setCustomer_age(int customer_age) {
        this.customer_age = customer_age;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    @Override
    public String toString() {
        return "customer_ID=" + customer_ID + ", customer_name=" + customer_name + ", customer_age=" + customer_age + ", customer_address=" + customer_address + ", customer_gender=" + customer_gender + ", customer_phone=" + customer_phone;
    }
}
