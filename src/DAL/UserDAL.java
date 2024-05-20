package DAL;


import DTO.User;
import config.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserDAL {
    private final Database db;    
    public UserDAL(){
    this.db = new Database();
    }
    public List<User> getCustomerList(String s) {
    List<User> dataList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;

        
        try {
            conn = this.db.connectDb();
            String sql = "select * from users";
            if(s != null && !s.isEmpty()) {
                sql += " where name like ?";
            }
            statement = conn.prepareStatement(sql);
            if(s != null && !s.isEmpty()) {
                statement.setString(1, s);
            }
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                User users = new User();
          users.setUser_id(resultSet.getString(1));
          users.setName(resultSet.getString(2));
          users.setEmail(resultSet.getString(4));
          users.setAddress(resultSet.getString(5));
          users.setPhone_number(resultSet.getString(9));
                dataList.add(users);
            }
        } catch (SQLException ex) {
           System.out.println("error connect database DAL");
        }        
        return dataList;
    }
    
    public void insert(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = this.db.connectDb();
            String sql = "insert into users(User_id, Name, Email, Address, Phone_number) "
                    + "values (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, user.getUser_id());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPhone_number());
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("cant add this customer");
        } 
    }
    
    public void update(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = this.db.connectDb();
            String sql = "update users set Name = ?, Email = ?, Address = ?, Phone_number = ? where user_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getPhone_number());
            statement.setString(5, user.getUser_id());
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("cant update");;
        } 
    }
    
    public void delete(String id) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = this.db.connectDb();
            String sql = "delete from users where user_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("cant delete this customer");;
        } 
    }
}
