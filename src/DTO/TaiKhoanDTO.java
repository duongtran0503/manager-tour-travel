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

    public TaiKhoanDTO(String userName1, String passWord1, String role1, String Email1, String sdt1, String status_sdt) {
    }
    public String userName;
    public String passWord;
    public String role;
    public String Email;
    public String sdt;
    public String status_std;

    public TaiKhoanDTO() {

    }
    
    public void TaiKhoanDTO(){
        
    }
    public void TaiKHoanDTO(String userName,String passWord,String role,String Email,String sdt,String status_std){
      this.userName = userName;
      this.passWord = passWord;
      this.role= role;
      this.sdt = sdt;
      this.status_std = status_std;
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

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setStatus_std(String status_std) {
        this.status_std = status_std;
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

    public String getSdt() {
        return sdt;
    }

    public String getStatus_std() {
        return status_std;
    }
  
}
