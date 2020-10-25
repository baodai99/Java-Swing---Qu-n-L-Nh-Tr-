/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import java.util.*;
/**
 *
 * @author NTD Developer
 */
public class DAOLogin {
    Connection conn;

    public DAOLogin(DBConnection db) {
        this.conn = db.getConn();
    }
    public boolean login(String userName, String pass){
         String sql="select * from login where username=? and password=?";
         try {
             PreparedStatement pre=conn.prepareStatement(sql);
             pre.setString(1,userName);
             pre.setString(2,pass);
             ResultSet rs=pre.executeQuery();
             if(rs.next()){
                 return true;
             }
             
         } catch (SQLException ex) {
           ex.printStackTrace();
         }
         return false;
      }
}
