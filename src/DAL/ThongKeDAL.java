/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author ACER
 */

import DTO.Orders;
import DTO.Payment;
import DTO.Revenue;
import DTO.Tour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.Database;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.time.YearMonth;
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
   // ===========get doanh thu
   public double getRevenue(int month,int year) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    double revenue = 0.0;

    try {
      
        conn = this.db.connectDb();

      String monthSql = month < 10 ? "0" + month : String.valueOf(month);
String startDate = year + "-" + monthSql + "-01";

int lastDayOfMonth = YearMonth.of(year, month).lengthOfMonth();
String endDate = year + "-" + monthSql + "-" + lastDayOfMonth;
String sql = "SELECT SUM(orders.totalPrice) as totalPrice, " +
             "SUM(tours.expense * payments.quantity) as totalExpense " +
             "FROM orders " +
             "JOIN tours ON orders.tourId = tours.tour_id " +
             "JOIN payments ON payments.orderId = orders.orderId " +
             "WHERE orders.time_book BETWEEN '" + startDate + "' AND '" + endDate + "'";

      
        stmt = conn.prepareStatement(sql);

       
        rs = stmt.executeQuery();

   
        if (rs.next()) {
            double totalPrice = rs.getDouble("totalPrice");
            double totalExpense = rs.getDouble("totalExpense");
            revenue = totalPrice - totalExpense;
        }
    } catch (Exception
            e) {
        e.printStackTrace();
        
    } 

    return revenue;
}
  //=========get total  customer
   public  int getTotalCusTomer(int month ,int year) {
      Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    int total = 0;

    try {
        conn = this.db.connectDb();

       
        String monthSql = month < 10 ? "0" + month : String.valueOf(month);
        String startDate = year + "-" + monthSql + "-01";

        int lastDayOfMonth = YearMonth.of(year, month).lengthOfMonth();
        String endDate = year + "-" + monthSql + "-" + lastDayOfMonth;

      
        String sql = "SELECT SUM(payments.quantity) AS totalCustomer "
                   + "FROM payments "
                   + "WHERE payments.time_payment BETWEEN ? AND ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, startDate);
        stmt.setString(2, endDate);

        // Execute query
        rs = stmt.executeQuery();
        if (rs.next()) {
            total = rs.getInt("totalCustomer");
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
       
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    return total;
    }
   public int getTotalOrder(int month, int year) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    int total = 0;

    try {
        conn = this.db.connectDb();

      
        String monthSql = month < 10 ? "0" + month : String.valueOf(month);
        String startDate = year + "-" + monthSql + "-01";

        int lastDayOfMonth = YearMonth.of(year, month).lengthOfMonth();
        String endDate = year + "-" + monthSql + "-" + lastDayOfMonth;

      
        String sql = "SELECT COUNT(*) AS totalOrder FROM orders WHERE orders.time_book BETWEEN ? AND ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, startDate);
        stmt.setString(2, endDate);

        rs = stmt.executeQuery();
        if (rs.next()) {
            total = rs.getInt("totalOrder");
        }

    } catch (Exception e) {
        e.printStackTrace(); 
    } finally {
       
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    return total;
}
   public ArrayList<Payment> getPayment(int month, int year) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    ArrayList<Payment> result = new ArrayList<>();

    try {
        conn = this.db.connectDb();

      
        String monthSql = month < 10 ? "0" + month : String.valueOf(month);
        String startDate = year + "-" + monthSql + "-01";
        int lastDayOfMonth = YearMonth.of(year, month).lengthOfMonth();
        String endDate = year + "-" + monthSql + "-" + lastDayOfMonth;

    
        String sql = "SELECT time_payment, payments.quantity AS customer "
                   + "FROM payments "
                   + "WHERE payments.time_payment BETWEEN ? AND ? "
                   + "GROUP BY payments.quantity";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, startDate);
        stmt.setString(2, endDate);

        rs = stmt.executeQuery();
        while (rs.next()) {
            int quantity = rs.getInt("customer");
            java.sql.Date date = rs.getDate("time_payment");
            Payment pay = new Payment();
            pay.setTime_payment(date);
            pay.setNumber(quantity);
            result.add(pay);
        }

    } catch (SQLException e) {
       
    } 

    return result;
}
     public ArrayList<Orders> getOrders(int month, int year) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    ArrayList<Orders> result = new ArrayList<>();

    try {
        conn = this.db.connectDb();

      
        String monthSql = month < 10 ? "0" + month : String.valueOf(month);
        String startDate = year + "-" + monthSql + "-01";
        int lastDayOfMonth = YearMonth.of(year, month).lengthOfMonth();
        String endDate = year + "-" + monthSql + "-" + lastDayOfMonth;

    
        String sql = "SELECT time_book, COUNT(*) AS totalOrder "
                   + "FROM orders "
                   + "WHERE  orders.time_book BETWEEN ? AND ? "
                   + "GROUP BY orders.time_book";

        stmt = conn.prepareStatement(sql);
        stmt.setString(1, startDate);
        stmt.setString(2, endDate);

        rs = stmt.executeQuery();
        while (rs.next()) {
            int quantity = rs.getInt("totalOrder");
            java.sql.Date date = rs.getDate("time_book");
           Orders order = new Orders();
           order.setQuantity(quantity);
           order.setTime_book(date);
           result.add(order);
        }

    } catch (SQLException e) {
       
    } 

    return result;
}
       public ArrayList<Revenue> getRevenuesOFDay(int month,int year) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    ArrayList <Revenue> result = new ArrayList<>();

    try {
      
        conn = this.db.connectDb();

      String monthSql = month < 10 ? "0" + month : String.valueOf(month);
String startDate = year + "-" + monthSql + "-01";

int lastDayOfMonth = YearMonth.of(year, month).lengthOfMonth();
String endDate = year + "-" + monthSql + "-" + lastDayOfMonth;
String sql = "SELECT payments.time_payment, SUM(orders.totalPrice) as totalPrice, " +
             "SUM(tours.expense * payments.quantity) as totalExpense " +
             "FROM orders " +
             "JOIN tours ON orders.tourId = tours.tour_id " +
             "JOIN payments ON payments.orderId = orders.orderId " +
             "WHERE orders.time_book BETWEEN '" + startDate + "' AND '" + endDate + "'"
        + "GROUP BY payments.time_payment";

      
        stmt = conn.prepareStatement(sql);

       
        rs = stmt.executeQuery();

   
         while(rs.next()) {
           java.sql.Date date = rs.getDate("time_payment");
           double price = rs.getDouble("totalPrice")- rs.getDouble("totalExpense");
           Revenue re = new Revenue();
           re.setPrice(price);
           re.setTime(date);
            result.add(re);
         }
    } catch (SQLException
            e) {
        
        
    } 

    return result;
}
  public ArrayList<DTO.Tour> getTOpTour(int month ,int year){
     Connection conn = null;
     PreparedStatement stmt = null;
     ArrayList<Tour> result = new ArrayList<>();
     ResultSet rs = null;
      try {
          conn = this.db.connectDb();
             String monthSql = month < 10 ? "0" + month : String.valueOf(month);
String startDate = year + "-" + monthSql + "-01";

int lastDayOfMonth = YearMonth.of(year, month).lengthOfMonth();
String endDate = year + "-" + monthSql + "-" + lastDayOfMonth;
          String sql ="SELECT SUM(payments.quantity) as total_quantity, tours.tour_id, tours.title, tours.price_one_person, tours.image_id, tours.destination_description, tours.address,tours.time_book_start, tours.time_book_end,tours.create_by, tours.expense, images.image_main "
                  + "FROM orders"
                  + " JOIN tours ON orders.tourId = tours.tour_id"
                  + " JOIN payments ON payments.orderId = orders.orderId JOIN images ON tours.image_id = images.image_id"
                  + " WHERE orders.time_book BETWEEN ? AND ?"
                  + " GROUP BY tours.tour_id, tours.title, tours.price_one_person, tours.time_book_start, "
                  + "tours.time_book_end, tours.image_id, tours.destination_description, tours.address, tours.create_by, tours.expense, images.image_main "
                  + "ORDER BY total_quantity DESC;";


         stmt = conn.prepareStatement(sql);
        stmt.setString(1, startDate);
        stmt.setString(2, endDate);
         rs =  stmt.executeQuery();
          while(rs.next()) {
          Tour data = new Tour();
        
          data.setTour_id(rs.getString("tour_id"));
          data.setTitle(rs.getString("title"));
          data.setPrice_one_person(rs.getDouble("price_one_person"));
          data.setQuantity(rs.getInt("total_quantity"));
          data.setImage_id(rs.getString("image_id"));
          data.setDestination_description(rs.getString("destination_description"));
          data.setAddress(rs.getString("address"));
          data.setTime_book_start(rs.getDate("time_book_start"));
        
          data.setTime_book_end(rs.getDate("time_book_end"));
       
          data.setCreate_by(rs.getString("create_by"));
          data.setImgUrl(rs.getString("image_main"));
          data.setExpense(rs.getDouble("expense"));
            result.add(data);
       } 
          return result;
      } catch (Exception e) {
      }
      return result;
  }     
}
