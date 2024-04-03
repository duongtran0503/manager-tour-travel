/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.TaiKhoanDTO;



/**
 *
 * @author ACER
 */
public class App {
    public static TaiKhoanDTO status =null;
 
    public void App(){
         
}
    /*
     user --> login -> status = info user -> routes
      -- routes
         
    
      --
    
    */
    public static void routes(){
      if(status==null) {
            Login login = new Login();
           login.setVisible(true);
           login.setLocationRelativeTo(null);

           
      } else {
          Home home = new Home();
           home.setVisible(true);
           home.setLocationRelativeTo(null);
           home.showToast("Đăng nhập thành công");
      }
    }
   
    public static void main(String[] args) {
      routes();
    
}
}
