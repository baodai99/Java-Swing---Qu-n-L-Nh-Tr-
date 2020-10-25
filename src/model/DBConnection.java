package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entity.Booking_room;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import jdk.nashorn.api.tree.TryTree;


/**
 *
 * @author NTD Developer
 */
public class DBConnection {
    //quan ly ket noi den sql Server va database
    private Connection conn=null;
    public DBConnection(String URL,String userName,String pass)
    {
        try {
            // load driver: multi driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // call connect
            conn=DriverManager.getConnection(URL,userName, pass);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public DBConnection()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=QLNhaTro;username=sa;password=sa";
            
                conn=DriverManager.getConnection(url);
        }
           catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public Connection getConn()
    {
        return conn;
    }
    public ResultSet getData(String sql){
        ResultSet rs=null;
        //ResultSet.TYPE_FORWARD_ONLY: default, con tro khong quay nguoc
        //TYPE_SCROLL_INSENSITIVE : no thread safe
        //TYPE_SCROLL_SENSITIVE: thread safe
        // ResultSet.CONCUR_READ_ONLY: default - no edit
         //ResultSet.CONCUR_UPDATABLE: edited
        try {
            Statement state=conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs=state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
}
