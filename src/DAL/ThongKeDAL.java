/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author ACER
 */

import DTO.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.Database;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
public class ThongKeDAL {
    private final Database db;
    public ThongKeDAL(){
     this.db = new Database();
    }
    public ArrayList<Payment> getPaymentByDate(int month , int year){
        
           Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    
        List<Payment> result = new ArrayList<>();
     try {
        conn = this.db.connectDb();
       String sql = "SELECT * FROM payments WHERE time_payment BETWEEN ? AND ?";
        String monthSql = month < 10 ? "0" + month : String.valueOf(month);
        String startDate = year + "-" + monthSql + "-01";
        String endDate = year + "-" +monthSql + "-31";
        statement = conn.prepareStatement(sql);
        statement.setDate(1, Date.valueOf(startDate));
        statement.setDate(2,Date.valueOf(endDate));
        
        rs = statement.executeQuery();
        while(rs.next()){
            Payment data = new Payment();
            data.setPaymentid(rs.getString(1));
            data.setOrderid(rs.getString(3));
            data.setUserid(rs.getString(2));
            data.setNumber(rs.getInt(4));
            data.setPrice(rs.getDouble(6));
            data.setTime_payment(rs.getDate(5));
            result.add(data);
        }
        this.db.closeConnection(conn);
         return  (ArrayList<Payment>) result;
     }
      catch(Exception e){
            System.out.println("loi connect db DAL");
      
      }
     return null;
    }
    
    
}
