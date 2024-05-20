/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.QLTourDAL;
import DTO.Tour;
import java.util.ArrayList;
import  DTO.Orders;
import DTO.Payment;
/**
 *
 * @author ACER
 */
public class QLTourBUS {
    private final  QLTourDAL qltdal;
    private Object ObjectType;
    public QLTourBUS(){
      qltdal = new QLTourDAL();
      
    }
    public ArrayList<Tour> getAllTour(){
         return this.qltdal.getAll();
    }
    public  ObjectType.MessageDAL createNewTour(Tour tour) {
       String tour_id = RandomIdGenerator.generateRandomId();
       tour.setTour_id(tour_id);
       if(tour.getImgUrl() !=null){
         tour.setImage_id(RandomIdGenerator.generateRandomId());
       }
       boolean create = this.qltdal.createNewTour(tour);
        ObjectType.MessageDAL result = new ObjectType.MessageDAL();
       if(create) {
          result.setStatus(true);
          result.setMessage("tạo tour mới thành công");
       } else {
           result.setStatus(false);
          result.setMessage("tạo tour mới không thành công");
       }
       return result;
    }
    public ObjectType.MessageDAL deleteTour(String tour_id) {
       ObjectType.MessageDAL result = new ObjectType.MessageDAL();
        boolean delete = this.qltdal.deleteTour(tour_id);
        if(delete) {
          result.setStatus(delete);
           result.setMessage("xóa tour thành công");
        } else {
          result.setStatus(delete);
          result.setMessage("xóa tour không thành công");
        }
       return result;
    }
    public ObjectType.MessageDAL updateTour(Tour tour) {
       ObjectType.MessageDAL  result = new ObjectType.MessageDAL();
        boolean update = this.qltdal.updateTour(tour);
        if(update) {
          result.setStatus(update);
          result.setMessage("update tour thành công");
        } else {
           result.setStatus(update);
           result.setMessage("update tour lỗi");
        }
       return result;
           
    }
    public ArrayList<Tour> searchTour(String key) {
      ArrayList<Tour> result = this.qltdal.searchTours(key);
      return result;
    }
    public ObjectType.MessageDAL AddOrder(Orders order,int quantityTour){
      ObjectType.MessageDAL  message =   new  ObjectType.MessageDAL();
         Payment pay  = new Payment();
         pay.setPaymentid(RandomIdGenerator.generateRandomId()
         );
         pay.setOrderid(order.getOrderid());
         pay.setUserid(RandomIdGenerator.generateRandomId());
         pay.setPrice(order.getPrice());
         pay.setNumber(order.getQuantity());
      boolean add = this.qltdal.addOrder(order,quantityTour,pay);
      if(add) {
       message.setStatus(add);
       message.setMessage("đặt chổ thành công!");
      }
      else {
           message.setStatus(add);
       message.setMessage("đặt chổ không  thành công!");
      }
      return message;
    }
 }
