/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class TaiKhoanDTO {

      private  String userId;
     private String userName;
    private String passWord;
    private String role;
    private String Email;
  
  public void setUserId(String id) {
    this.userId = id;
  }
  public String getUserId() {
   return this.userId;
  }
    public TaiKhoanDTO() {

    }
    
    public void TaiKhoanDTO(){
        
    }
   
    // Setter methods
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

  

   

    // Getter methods
    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return Email;
    }

   

   
}
