package DTO;
import BUS.RandomIdGenerator;
import java.util.Date;
public class Orders {
     private String orderid;
    private String tourid;
    private double price;
    private double totalPrice;
    private int quantity;
    private String create_by;
    private String address;
    private String phone;
    private String nameUser;
    private Date time_book;
     public Orders() {
       this.orderid =  RandomIdGenerator.generateRandomId();
     }
    // Getter và Setter cho orderid
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    // Getter và Setter cho tourid
    public String getTourid() {
        return tourid;
    }

    public void setTourid(String tourid) {
        this.tourid = tourid;
    }

    // Getter và Setter cho price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter và Setter cho totalPrice
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Getter và Setter cho quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter và Setter cho create_by
    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    // Getter và Setter cho address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter và Setter cho phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter và Setter cho nameUser
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    // Getter và Setter cho time_book
    public Date getTime_book() {
        return time_book;
    }

    public void setTime_book(Date time_book) {
        this.time_book = time_book;
    }
}
