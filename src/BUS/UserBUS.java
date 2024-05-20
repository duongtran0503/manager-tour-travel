/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAL.UserDAL;
import DTO.User;
import java.util.ArrayList;
import java.util.List;

public class UserBUS {
    UserDAL dal = new UserDAL();
    List<User> datalist;
    public List<User> getcustomer(){
        datalist=dal.getCustomerList(null);
        return datalist;
    }
    public void addcustomer(User user){
        dal.insert(user);
        datalist=dal.getCustomerList(null);
    }
    public void delete (String id){
        dal.delete(id);
        datalist=dal.getCustomerList(null);
    }
    public void update (User user){
        dal.update(user);
        datalist = dal.getCustomerList(null);
    }
    public List<User> search(String s){
        datalist=dal.getCustomerList(s);
        return datalist;
    }   
}
