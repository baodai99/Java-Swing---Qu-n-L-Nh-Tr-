package model;

import entity.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;  
import java.util.Calendar;  
import static javafx.util.Duration.millis;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author bao dai
 */
public class DAOBill {
    private DBConnection dbcon=null;
    private Connection con=null;

    public DAOBill(DBConnection dbcon){
        this.dbcon=dbcon;
        this.con=dbcon.getConn();
        
    }
    //Thêm hóa đơn
    public void AddBill(Bill b) throws ParseException{
        String sql="insert bill(bill_ID,room_ID,customer_ID,"
                + "months,service_money)"+ "values(?,?,?,?,?)";

        try {           
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1, b.getBill_ID());
            pre.setString(2, b.getRoom_ID());
            pre.setString(3, b.getCustomer_ID());  
            pre.setString(4, b.getMonth());
            pre.setDouble(5, b.getService_money());
            
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }//Hiển thị hóa đơn
    public void DisplayBill(JTable tb){
        String sql="select * from bill";
        ResultSet rs=dbcon.getData(sql);      
        tb.setModel(DbUtils.resultSetToTableModel(rs));   
    }    //Đẩy thông tin trên textfield bảng bookingroom
    public ResultSet pushInforTextField(String IDrow)
    {
        String sql="select * from  Booking_room where  room_ID='"+IDrow+"'";
        try {
            PreparedStatement pst=con.prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception e) {
            return null;
  
        } 
    }
        //Đẩy thông tin trên textfield bảng Bill
    public ResultSet pushInforTextField_Bill(String IDrow)
    {
        String sql="select * from  bill where  bill_ID='"+IDrow+"'";
        try {
            PreparedStatement pst=con.prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception e) {
            return null;
  
        } 
    }
    public void deleteBillByCusID(String cus_ID){
        String sql="Delete from bill where customer_ID='"+cus_ID+"'";
        try {
            Statement sta=con.createStatement();
            sta.executeUpdate(sql);
            
        } catch (SQLException e) {
        }
    }
    public void deleteBillByRoomID(String r_ID){
        String sql="Delete from bill where room_ID='"+r_ID+"'";
        try {
            Statement sta=con.createStatement();
            sta.executeUpdate(sql);
            
        } catch (SQLException e) {
        }
    }
    
    //Search by bill_id , room_id , customer_id
    public void SearchByMahd(String mahd,JTable tb){
        String sql="select * from bill where bill_ID= '"+mahd+"'";
        ResultSet rs=dbcon.getData(sql);
        tb.setModel(DbUtils.resultSetToTableModel(rs)); 
    }
    
    public void SearchByMap(String maphong,JTable tb){
        String sql="select * from bill where room_ID like  N'%"+maphong+"'";
        ResultSet rs=dbcon.getData(sql);
        tb.setModel(DbUtils.resultSetToTableModel(rs)); 
    }
  
    public void SearchByMakh(String makh,JTable tb){
        String sql="select * from bill where customer_ID like  N'%"+makh+"'";
        ResultSet rs=dbcon.getData(sql);
        tb.setModel(DbUtils.resultSetToTableModel(rs)); 
    }
}
