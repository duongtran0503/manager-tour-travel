package DTO;
import java.util.Date;
public class Payment {
    private String paymentid;
    private String userid;
    private String orderid;
    private int quantity;
    private Date time_payment;
    private double price;

    public Payment() {
    }
    public int getDayPayment() {
     return time_payment.getDay();
    }
    public double getPrice(){
     return this.price;
    }
   public void setPrice(double price){
     this.price = price;
   }
    // setter va getter paymentid
    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }
    public String getPaymentid() {
        return paymentid;
    }

    // setter va getter userid
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUserid() {
        return userid;
    }

    // setter va getter orderid
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
    public String getOrderid() {
        return orderid;
    }

    // setter va getter number
    public void setNumber(int number) {
        this.quantity = number;
    }
    public int getNumber() {
        return quantity;
    }

    public void setTime_payment(Date time_payment) {
        this.time_payment = time_payment;
    }
    public Date getTime_payment() {
        return time_payment;
    }
}
