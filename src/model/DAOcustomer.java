package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entity.customer;
import java.sql.*;
import java.util.ArrayList;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.*;
import view.Customer;

/**
 *
 * @author Quoc Cuong
 */
public class DAOcustomer {
    private DBConnection dbcon=null;
    private Connection con=null;
    //private final String header[]={"Mã Khách Hàng","Tên Khách Hàng","Tuổi","Địa Chỉ","Giới Tính","Số Điện Thoại"};
    //private final DefaultTableModel tblModel = new DefaultTableModel(header, 0);
    public DAOcustomer(DBConnection dbcon){
        this.dbcon=dbcon;
        this.con=dbcon.getConn();
    }
    public void AddCustomer(customer cus){
        String sql="insert customer(customer_ID,customer_name,customer_age,"
                + "customer_address,customer_gender,customer_phone)"+ "values(?,?,?,?,?,?)";
        try {           
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1, cus.getCustomer_ID());
            pre.setString(2, cus.getCustomer_name());
            pre.setInt(3, cus.getCustomer_age());
            pre.setString(4, cus.getCustomer_address());
            pre.setString(5, cus.getCustomer_gender());
            pre.setString(6, cus.getCustomer_phone());
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void UpdateCustomer(customer cus){
        String sql="update customer set customer_name=?,customer_age=?,customer_address=?,customer_gender=?,customer_phone=? where customer_ID=?";
        try {            
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1, cus.getCustomer_name());
            pre.setInt(2, cus.getCustomer_age());
            pre.setString(3, cus.getCustomer_address());
            pre.setString(4, cus.getCustomer_gender());
            pre.setString(5, cus.getCustomer_phone());
            pre.setString(6, cus.getCustomer_ID());
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void DelCustomerByID(String id){
        String sql="Delete from customer where customer_ID='"+id+"'";
        try {
            Statement sta=con.createStatement();
            sta.executeUpdate(sql);
            
        } catch (SQLException e) {
        }
        
    }
    public void DelCustomerByName(String name){
        String sql="Delete from customer where customer_name='"+name+"'";
        try {
            Statement sta=con.createStatement();
            sta.executeUpdate(sql);
        } catch (SQLException e) {
        }
    }
    public void DisplayCustomer(JTable tb){
        String sql="select * from customer";
        ResultSet rs=dbcon.getData(sql);      
        tb.setModel(DbUtils.resultSetToTableModel(rs));   
    }
    public ResultSet pushInforTextField(String IDrow)
    {
        String sql="select * from  customer where customer_ID='"+IDrow+"'";
        try {
            PreparedStatement pst=con.prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception e) {
            return null;
            //JOptionPane.showMessageDialog(null, e,"Thông Báo Lỗi",1);
        } 
    }
    public void SearchByName(String name,JTable tb){
        String sql="select * from customer where customer_name like  N'%"+name+"'";
        ResultSet rs=dbcon.getData(sql);
        tb.setModel(DbUtils.resultSetToTableModel(rs)); 
    }
    public void SearchByID(String id,JTable tb){
        String sql="select * from customer where customer_ID ='"+id+"'";
        ResultSet rs=dbcon.getData(sql);
        tb.setModel(DbUtils.resultSetToTableModel(rs)); 
    }
    
}
