/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author ACER
 */
import DAL.TaiKhoanDAL;
import DTO.TaiKhoanDTO;
public class TaiKhoanBUS {
    private final TaiKhoanDAL tkdal = new TaiKhoanDAL();
   private final CheckError checkError = new CheckError();
    public void TaiKhoanBUS(){
    }
    public static class  ErrorMessage{
         public String Message;
         public boolean  Status;
         public ErrorMessage(String Message,boolean  status) {
             this.Message = Message;
             this.Status = status;
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
    
    public ErrorMessage  checkAcount(TaiKhoanDTO user){
          ErrorMessage result = new ErrorMessage("", true);
          if(!this.checkError.CheckEmail((String)user.getEmail())) {    
            result.setMessage("email không hợp lệ");
            result.setStatus(false);
            return  result;
          }
          TaiKhoanDTO checkUser =  tkdal.getUserByEmail(user.getEmail());
          if(checkUser == null) {
              result.setMessage("tài khoản không tồn tại");
              result.setStatus(false);
          } else if( !user.passWord.equalsIgnoreCase(checkUser.passWord)){
              result.setMessage("mật khẩu không đúng");
              result.setStatus(false);
          }
          
       
         return result;
    }
}
