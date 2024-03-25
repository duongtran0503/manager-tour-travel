/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {
     public  Connection  connectDb(){
           Connection result = null;
         try {
             DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver());
              //Cac thong so
            String url = "jdbc:mySQL://127.0.0.1:3306/travel_tuor?useUnicode=true&characterEncoding=UTF8";
            String userName = "root";
            String password = "";
            //Tao ket noi 
             result = DriverManager.getConnection(url, userName, password);
         }
          catch(SQLException e){
              System.out.println("loi connect db!");
          }
         return result;
     }
        public  void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            // TODO: handle exception
             System.out.println("close connect db config");
        }
    }
}
