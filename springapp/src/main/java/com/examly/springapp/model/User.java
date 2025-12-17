package com.examly.springapp.model;
import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    
    private String userName;
    private String email;
    private String password;
    private String role;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
     
    public User(){}

    public long getUserId(){
        return userId;
    }
    public void setPositionId(long userId){
        this.userId = userId;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public Department getDepartment(){
        return department;
    }
    public void setDepartment(Department department){
        this.department = department;
    }
    
}