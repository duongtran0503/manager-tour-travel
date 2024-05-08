/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
import DTO.Tour;
import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class QLTourDAL {
    private final Database db;
    public QLTourDAL(){
     this.db = new Database();
    }
    public ArrayList<Tour> getAll() {
          Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    ArrayList<Tour> result = new ArrayList<>();
     try {
         conn = this.db.connectDb();
         String sql = "SELECT DISTINCT * FROM tours,images WHERE tours.image_id = images.image_id ORDER BY tours.update_at ASC";
          statement = conn.prepareStatement(sql);
           statement.execute();
          rs = statement.getResultSet();
       while(rs.next()) {
          Tour data = new Tour();
        
          data.setTour_id(rs.getString(1));
          data.setTitle(rs.getString(2));
          data.setPrice_one_person(rs.getDouble(3));
          data.setQuantity(rs.getInt(4));
          data.setImage_id(rs.getString(5));
          data.setDestination_description(rs.getString(6));
          data.setAddress(rs.getString(7));
          data.setTime_book_start(rs.getDate(8));
        
          data.setTime_book_end(rs.getDate(9));
       
          data.setCreate_by(rs.getString(10));
          data.setImgUrl(rs.getString("image_main"));
          data.setExpense(rs.getDouble("expense"));
            result.add(data);
       }   
       return result;  
          
     }
      catch(SQLException e) {
          System.out.println("error connect database DAL");
      }
     return result;
    }
    public boolean createNewTour(Tour tour) {
        Connection conn = null;
        PreparedStatement stmt = null;
     
        try {
           conn = this.db.connectDb();
           String sql = "INSERT INTO tours "
           + "(tour_id,title,price_one_person,image_id,destination_description,address,time_book_start,	time_book_end,expense,quantity)"
                   + "values(?,?,?,?,?,?,?,?,?,?)";
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, tour.getTour_id());
           stmt.setString(2, tour.getTitle());
           stmt.setDouble(3, tour.getPrice_one_person());
           stmt.setString(4, tour.getImage_id());
           stmt.setString(5, tour.getDestination_description());
           stmt.setString(6, tour.getAddress());
           stmt.setDate(7, tour.getTime_book_start());
           stmt.setDate(8, tour.getTime_book_end());
           stmt.setInt(10,tour.getQuantity());
           stmt.setDouble(9, tour.getExpense());
           stmt.execute();
           String SqlInsertImage =  "INSERT INTO images (image_id,image_main) VALUES (?,?)";
             stmt = conn.prepareStatement(SqlInsertImage);
             stmt.setString(1, tour.getImage_id());
             stmt.setString(2, tour.getImgUrl());
             stmt.execute();
            System.out.println("create new Tour success");
            return true;
        } catch (SQLException e) {
            return  false;
        }
       
    }
    public boolean  deleteTour(String tour_id) {
         Connection conn = null;
        PreparedStatement stmt = null;
     
        try {
           conn = this.db.connectDb();
           String sql = "DELETE FROM tours "
           + " WHERE tours.tour_id = ?";
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, tour_id);
           stmt.execute();
            System.out.println("delete  Tour success");
            return true;
        } catch (SQLException e) {
            return  false;
        }
    }
    public boolean updateTour(Tour tour) {
          Connection conn = null;
    PreparedStatement stmtTour = null;
    PreparedStatement stmtImage = null;
    
    try {
        conn = this.db.connectDb();
        String updateTourSql = "UPDATE tours " +
                "SET title = ?, price_one_person = ?, destination_description = ?, address = ?, time_book_start = ?, time_book_end = ?, expense = ?, quantity = ? " +
                "WHERE tour_id = ?";
        stmtTour = conn.prepareStatement(updateTourSql);
        stmtTour.setString(1, tour.getTitle());
        stmtTour.setDouble(2, tour.getPrice_one_person());
        stmtTour.setString(3, tour.getDestination_description());
        stmtTour.setString(4, tour.getAddress());
        stmtTour.setDate(5, tour.getTime_book_start());
        stmtTour.setDate(6, tour.getTime_book_end());
        stmtTour.setDouble(7, tour.getExpense());
        stmtTour.setInt(8, tour.getQuantity());
        stmtTour.setString(9, tour.getTour_id());
        stmtTour.executeUpdate();
          String updateImageSql = "UPDATE images SET image_main = ? WHERE image_id = ?";
        stmtImage = conn.prepareStatement(updateImageSql);
        stmtImage.setString(1, tour.getImgUrl());
        stmtImage.setString(2, tour.getImage_id());
        stmtImage.executeUpdate();

            System.out.println("update tour success");
            return true;
        } catch (Exception e) {
            System.out.println("error update tour!");
            return false;
        }
    } 
     public ArrayList<Tour> searchTours(String Key) {
          Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    ArrayList<Tour> result = new ArrayList<>();
     try {
         conn = this.db.connectDb();
      String sql = "SELECT DISTINCT * FROM tours, images WHERE tours.image_id = images.image_id AND tours.title LIKE CONCAT('%', ?, '%') ORDER BY tours.update_at ASC";
          statement = conn.prepareStatement(sql);
          statement.setString(1, Key);
           statement.execute();
          rs = statement.getResultSet();
       while(rs.next()) {
          Tour data = new Tour();
          data.setTour_id(rs.getString(1));
          data.setTitle(rs.getString(2));
          data.setPrice_one_person(rs.getDouble(3));
          data.setQuantity(rs.getInt(4));
          data.setImage_id(rs.getString(5));
          data.setDestination_description(rs.getString(6));
          data.setAddress(rs.getString(7));
          data.setTime_book_start(rs.getDate(8));
        
          data.setTime_book_end(rs.getDate(9));
       
          data.setCreate_by(rs.getString(10));
          data.setImgUrl(rs.getString("image_main"));
          data.setExpense(rs.getDouble("expense"));
            result.add(data);
       }   
       return result;  
          
     }
      catch(SQLException e) {
          System.out.println("error connect database DAL");
      }
     return result;
    }
             
}
