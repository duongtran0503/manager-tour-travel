/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.ThongKeDAL;
import DTO.Payment;
import java.util.ArrayList;

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
}
