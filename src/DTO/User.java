package DTO;
public class User {
    private String user_id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String status;
    private String roleid;
    private String account_authorize;
    private String phone_number;
    private String description;

    // setter va getter User_id
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getUser_id() {
        return user_id;
    }

    // setter va getter Name
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    // setter va getter password
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    // setter va getter Email
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    // setter va getter Address
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    
    // setter va getter Status
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    // setter va getter Roleid
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
    public String getRoleid() {
        return roleid;
    }

    // setter va getter Account_Authorize
    public void setAccount_authorize(String account_authorize) {
        this.account_authorize = account_authorize;
    }
    public String getAccount_authorize() {
        return account_authorize;
    }

    // setter va getter Phone_Number
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getPhone_number() {
        return phone_number;
    }

    // setter va getter Description
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}

