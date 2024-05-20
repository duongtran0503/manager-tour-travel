/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.TaiKhoanDTO;
/**
 *
 * @author ACER
 */
public class ObjectType {
    // type trả về đối tượng user và trạng thái đăng nhập 
    /*
       mật khẩu sai->> { mesage:" password không đúng" ,status:false}
       người dùng không tồn tại ->> {message:"nguoif dùng không tồn tại , status:false }
       đăng nhập thành công ->> { message:"" , status: true}
    */
   public static class  CheckErrorLogin{
         public String Message;
         public boolean  Status;
         private TaiKhoanDTO user;
         public CheckErrorLogin(String Message,boolean  status) {
             this.Message = Message;
             this.Status = status;
             
         }
         public void setUser(TaiKhoanDTO user) {
            this.user  = user;
         }
         public TaiKhoanDTO getUser() { return this.user;}
         public String getMessage(){
             return this.Message;
         }
         public boolean getStatus(){
          return this.Status;
         }
         public void setMessage(String ms) {
             this.Message = ms;
             
         }
         public void setStatus(boolean f) {
             this.Status =f;
         }
    }
   
   public static class MessageDAL{
      public String Message;
         public boolean  Status;
         public MessageDAL(String Message,boolean  status) {
             this.Message = Message;
             this.Status = status;
         }

        MessageDAL() {
          
        }
         public String getMessage(){
             return this.Message;
         }
         public boolean getStatus(){
          return this.Status;
         }
         public void setMessage(String ms) {
             this.Message = ms;
             
         }
         public void setStatus(boolean f) {
             this.Status =f;
         }
   }
}
