/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.ThongKeDAL;
import DTO.Orders;
import DTO.Payment;
import DTO.Revenue;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author ACER
 */
public class ThongKeBUS {
    private ThongKeDAL thongKeDAL;
    public ThongKeBUS(){
     thongKeDAL = new ThongKeDAL();
    }
    public ArrayList revenueData(int month, int year){
        ArrayList<Payment> data = thongKeDAL.getPaymentByDate(month+1, year);
        System.out.println(data.size());
        return data;
    }
    // ============  doanh thu
   public double getRevenue(int month, int year){
       double result =this.thongKeDAL.getRevenue(month+1, year);
       return result;
       
   }   
   // ======== total customer
   public int  getTotalCusTomer(int month, int year){
        return this.thongKeDAL.getTotalCusTomer(month+1, year);
   }
   public int  getTotalOrder(int month, int year){
        return this.thongKeDAL.getTotalOrder(month+1, year);
   }
   public ArrayList<Payment> getPayment(int month, int year) {
     return this.thongKeDAL.getPayment( month+1, year);
   }
   public ArrayList<Orders> getOrders(int month ,int year) {
     return this.thongKeDAL.getOrders(month+1, year);
   }
   public ArrayList<Revenue> getRevenueOFDay(int month, int year) {
    return this.thongKeDAL.getRevenuesOFDay(month+1, year);
    }
   public ArrayList<DTO.Tour> getTopTour(int month,int year){
    return this.thongKeDAL.getTOpTour(month +1, year);
   }
public String formatPrice(Double price) {
    NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    String formattedPrice = formatter.format(price*1000);
  
    formattedPrice = formattedPrice.replace("₫", "").trim() + " ₫";
    return formattedPrice;
}
}
