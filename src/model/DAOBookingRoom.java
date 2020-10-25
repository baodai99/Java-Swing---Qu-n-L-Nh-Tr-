/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
import entity.Booking_room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author NTD Developer
 */
public class DAOBookingRoom {
    DBConnection dbcon=null;
    Connection con=null;
    public DAOBookingRoom(DBConnection dbcon){
        this.dbcon=dbcon;
        this.con=dbcon.getConn();
    }
    public void AddBooking(Booking_room b){
        String sql="insert into Booking_room(room_ID,customer_ID,date_hire)"
                + "values(?,?,?)";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1,b.getRoom_ID());
            pre.setString(2,b.getCustomer_ID());
            pre.setString(3, b.getDate_hire());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public void DeleteBookingByC_ID(String C_ID){
        String sql="Delete from Booking_room where customer_ID='"+C_ID+"'";
        try {
            Statement sta=con.createStatement();
            sta.executeUpdate(sql);
        } catch (SQLException e) {
        }
    }
    public void DeleteBookingByR_ID(String R_ID){
        String sql="Delete from Booking_room where room_ID='"+R_ID+"'";
        try {
            Statement sta=con.createStatement();
            sta.executeUpdate(sql);
        } catch (SQLException e) {
        }
    }
    public void DisplayBookingRoom(JTable tb){
        String sql="select * from Booking_room";
        ResultSet rs=dbcon.getData(sql);      
        tb.setModel(DbUtils.resultSetToTableModel(rs));   
    }
}
