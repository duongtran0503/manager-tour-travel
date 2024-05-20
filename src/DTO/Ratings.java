package DTO;
public class Ratings {
    private String rating_id;
    private String comment_id;
    private String tour_id;
    private String detail;
    private String user_id;
    
    // setter va getter rating_id
    public void setRating_id(String rating_id) {
        this.rating_id = rating_id;
    }
    public String getRating_id() {
        return rating_id;
    }

    // setter va getter comment_id
    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }
    public String getComment_id() {
        return comment_id;
    }

    // setter va getter tour_id
    public void setTour_id(String tour_id) {
        this.tour_id = tour_id;
    }
    public String getTour_id() {
        return tour_id;
    }

    // setter va getter detail
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getDetail() {
        return detail;
    }

    // setter va getter user_id
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getUser_id() {
        return user_id;
    }
}
