/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author ACER
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.Database;
import DTO.TaiKhoanDTO;
import java.sql.SQLException;
import java.util.ArrayList;
public class TaiKhoanDAL implements  InterFaceDAL<TaiKhoanDTO>{
        private final Database db = new Database();
        @Override
        public ArrayList<TaiKhoanDTO> getAll(){
            
            ArrayList<TaiKhoanDTO> list = new ArrayList<>();
//            try {
//              Connection con = db.connectDb();
//              String sql = "SELECT * FROM TAI_KHOAN";
//               PreparedStatement pst = con.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//                while (rs.next()) {
//                  String userName = rs.getString("userName");
//                 String passWord = rs.getString("passWord");
//                 String role = rs.getString("role");
//                 String Email =rs.getString("Email");
//                 String sdt = rs.getString("sdt");
//                  String status_sdt= rs.getString("status_sdt");
//                   // lấy lớp NguoiDungDTO và tạo đôi tượng ->gắn giá trị cho đối tượng
//                                  
//                 list.add(user);
//               
//            }
//            }
//            catch(SQLException e){
//            }
            return list;
          
    }
        @Override
        public TaiKhoanDTO getById(String id){
            TaiKhoanDTO user = new TaiKhoanDTO();
            return user;
        } 
        @Override
        public int insert(TaiKhoanDTO user) {
         return 404;
        }
        @Override 
        public int update(TaiKhoanDTO user) {
            return 404;
        }
         @Override
         public int delete(TaiKhoanDTO user) {
          return 404;
         }
    public TaiKhoanDTO getUserByEmail(String emailUser) {
       
      try {
         String sql = "SELECT * FROM `users` WHERE users.email = ?";
       Connection conn = this.db.connectDb();// -> get connect databassse
PreparedStatement statement = conn.prepareStatement(sql);// -> tao doi tuong truy van
statement.setString(1, emailUser); // thay the day ? bang email
ResultSet rs = statement.executeQuery(); // -> thuc thi truy van        
// lay gia tri cua user 
/*
 re.next -> cho den doi tuong tiep theo 
 rs.next = null khi khong con doi tuong nao trong table database duong tra ve
*/
 TaiKhoanDTO user = new TaiKhoanDTO();
if (rs.next()) {
    user.setEmail(rs.getString("email"));
    user.setUserName(rs.getString("name"));
    user.setRole(rs.getString(7));
    user.setPassWord(rs.getString(3));
}
         // tao doi tuong tai khoan
               
              
                       System.out.println("get user run ");
                       this.db.closeConnection(conn);
               return user;
      }
      catch(SQLException e ) {
          System.out.println("loi connect db DAL");
      }
      /*
       -> if connect db error then function return  null
       -> terminal -> meesage: loi conect db DAL
     
      
      
      */
      return null;
    }
}
