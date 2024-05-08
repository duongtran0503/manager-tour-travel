package DTO;

import java.sql.Date;

public class Tour {
    private String tour_id;
    private String title;
    private double price_one_person;
    private String image_id ="0";
    private String destination_description;
    private String address;
    private Date time_book_start;
    private int  quantity;
    private Date time_book_end;
    private double rating;
    private int total_rating;
    private int total_start;
    private String imgUrl;
    private String create_by;
    private double expense;
    public void setQuantity(int  t)
    {
        this.quantity = t;}
    public  int getQuantity(){ return this.quantity;}
    public void setExpense(double i) {
       this.expense =i;
    }
    public double getExpense() {
     return this.expense;
    }
     public void setImgUrl(String url) {
      this.imgUrl = url;
     }
     public String getImgUrl(){
       return this.imgUrl;
     }
    // setter va getter tour_id
    public void setTour_id(String tour_id) {
        this.tour_id = tour_id;
    }
    public String getTour_id() {
        return tour_id;
    }

    // setter va getter title
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    // setter va getter price_one_person
    public void setPrice_one_person(double price_one_person) {
        this.price_one_person = price_one_person;
    }
    public double getPrice_one_person() {
        return price_one_person;
    }

    // setter va getter image_id
    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }
    public String getImage_id() {
        return image_id;
    }

    // setter va getter destination_description
    public void setDestination_description(String destination_description) {
        this.destination_description = destination_description;
    }
    public String getDestination_description() {
        return destination_description;
    }

    // setter va getter address
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    // setter va getter time_book_start
    public void setTime_book_start(Date time_book_start) {
        this.time_book_start = time_book_start;
    }
    public Date getTime_book_start() {
        return this.time_book_start;
    }


  

    // setter va getter time_book_end
    public void setTime_book_end(Date time_book_end) {
        this.time_book_end = time_book_end;
    }
    public Date getTime_book_end() {
        return time_book_end;
    }

    // setter va getter rating
    public void setRating(double rating) {
        this.rating = rating;
    }
    public double getRating() {
        return rating;
    }

    // setter va getter total_rating
    public void setTotal_rating(int total_rating) {
        this.total_rating = total_rating;
    }
    public int getTotal_rating() {
        return total_rating;
    }
    
    // setter va getter total_start
    public void setTotal_start(int total_start) {
        this.total_start = total_start;
    }
    public int getTotal_start() {
        return total_start;
    }
    
    // setter va getter create_by
    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }
    public String getCreate_by() {
        return create_by;
    }

}
