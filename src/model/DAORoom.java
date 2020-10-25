/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import model.DBConnection;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Quoc Cuong
 */
public class DAORoom {
    DBConnection dbcon=null;
    Connection con=null;
    public DAORoom(DBConnection dbcon){
        this.dbcon=dbcon;
        this.con=dbcon.getConn();
    }
    public void AddRoom(room r){
        String sql="insert into Room(room_ID, type_room, number_floor, price, status_room, number_person)"
                + "values(?,?,?,?,?,?)";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1,r.getRoom_ID());
            pre.setString(2, r.getType_room());
            pre.setInt(3,r.getNumber_floor());
            pre.setDouble(4, r.getPrice());
            pre.setString(5, r.getStatus_room());
            pre.setInt(6, r.getNumber_person());
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void UpdateRoom(room r){
        String sql="update Room set type_room=?,number_floor=?,price=?,status_room=?,number_person=? where room_ID=?";
        try {
            PreparedStatement pre=con.prepareStatement(sql);           
            pre.setString(1, r.getType_room());
            pre.setInt(2,r.getNumber_floor());
            pre.setDouble(3, r.getPrice());
            pre.setString(4, r.getStatus_room());
            pre.setInt(5, r.getNumber_person());
            pre.setString(6,r.getRoom_ID());
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void UpdateRoomByType(String type,String room_id){
        String sql="update room set type_room=? where room_ID=?";
        try {            
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1, type);
            pre.setString(2, room_id);
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void UpdateRoomByPrice(Double price,String id) {
        String sql = "update room set price=? where room_ID=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setDouble(1, price);
            pre.setString(2, id);
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void UpdateRoomByStatus(String status,String id) {
        String sql = "update room set status_room=? where room_ID=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,status);
            pre.setString(2,id);
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void UpdateRoomByNumberPerson(String id) {
        String sql = "update room set number_person=number_person +1 where room_ID=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,id);
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void UpdateRoomByNumberPersondelete(String id) {
        String sql =  "update room set number_person=number_person - 1 "
                + "from room inner join Booking_room on room.room_ID=Booking_room.room_ID "
                + "inner join customer on customer.customer_ID=Booking_room.customer_ID "
                + "where customer.customer_ID=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,id);
            pre.executeUpdate();
            
        } catch (SQLException e) {
        }
        
    }
    public void DisplayRoom(JTable tb){
        String sql="select * from Room";
        ResultSet rs=dbcon.getData(sql);      
        tb.setModel(DbUtils.resultSetToTableModel(rs));
    }
    public void DelRoom(String id){
        String sql="delete from Room where room_ID='"+id+"'";
        try {
            Statement sta=con.createStatement();
            sta.executeQuery(sql);
        } catch (SQLException e) {
        }
    }
    public ResultSet pushInforTextField(String IDrow)
    {
        String sql="select * from  Room where room_ID='"+IDrow+"'";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            return pre.executeQuery();
        } catch (SQLException e) {
            return null;
            //JOptionPane.showMessageDialog(null, e,"Thông Báo Lỗi",1);
        } 
    }
    public void SearchRoom(String id, JTable tb){
        String sql="select * from Room where room_ID ='"+id+"'";
        ResultSet rs=dbcon.getData(sql);
        tb.setModel(DbUtils.resultSetToTableModel(rs)); 
    }
    public void SearchByStatus(String st,JTable tb){
        String sql="select * from room where status_room ='"+st+"'";
        ResultSet rs=dbcon.getData(sql);
        tb.setModel(DbUtils.resultSetToTableModel(rs)); 
    }
    public void SearchByType(String st,JTable tb){
        String sql="select * from room where type_room ='"+st+"'";
        ResultSet rs=dbcon.getData(sql);
        tb.setModel(DbUtils.resultSetToTableModel(rs)); 
    }
    public void SearchByTypeStatus(String st,JTable tb, String ts){
        String sql="select * from room where type_room ='"+st+"' and status_room = '"+ts+"'";
        ResultSet rs=dbcon.getData(sql);
        tb.setModel(DbUtils.resultSetToTableModel(rs)); 
    }
}
