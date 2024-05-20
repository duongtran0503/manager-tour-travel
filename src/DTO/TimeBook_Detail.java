package DTO;
public class TimeBook_Detail {
    private String time_id;
    private String tour_id;
    private String start_time;
    private String end_time;
    private String is_paying;
    private String is_deleted;
    
    // setter va getter time_id
    public void setTime_id(String time_id) {
        this.time_id = time_id;
    }
    public String getTime_id() {
        return time_id;
    }

    // setter va getter tour_id
    public void setTour_id(String tour_id) {
        this.tour_id = tour_id;
    }
    public String getTour_id() {
        return tour_id;
    }

    // setter va getter start_time
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
    public String getStart_time() {
        return start_time;
    }

    // setter va getter end_time
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
    public String getEnd_time() {
        return end_time;
    }

    // setter va getter is_paying
    public void setIs_paying(String is_paying) {
        this.is_paying = is_paying;
    }
    public String getIs_paying() {
        return is_paying;
    }

    //setter va getter is_deleted
    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }
    public String getIs_deleted() {
        return is_deleted;
    }
}
