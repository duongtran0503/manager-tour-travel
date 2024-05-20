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
   
    
    public ObjectType.CheckErrorLogin checkAcount(TaiKhoanDTO user){
         ObjectType.CheckErrorLogin result = new ObjectType.CheckErrorLogin("", true);
          if(!this.checkError.CheckEmail((String)user.getEmail())) {    
            result.setMessage("email không hợp lệ");
            result.setStatus(false);
            return  result;
          }
          TaiKhoanDTO checkUser =  tkdal.getUserByEmail(user.getEmail());
          if(checkUser == null) {
              result.setMessage("tài khoản không tồn tại");
              result.setStatus(false);
          } else if( !user.getPassWord().equalsIgnoreCase(checkUser.getPassWord())){
              result.setMessage("mật khẩu không đúng");
              result.setStatus(false);
          }else {
            result.setUser(checkUser);
          }
          
       
         return result;
    }
}
