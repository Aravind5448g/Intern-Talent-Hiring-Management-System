package com.examly.springapp.model;
import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    
    private String userName;
    private String contactEmail;
    private String contactPhone;

    public Department(){}
    

    public Department(String departmentName , String contactEmail , String contactPhone){
        this.departmentName = departmentName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public long getId(){
        return departmentId;
    }
    public void setId(long departmentId){
        this.departmentId = departmentId;
    }
    public String getDepartmentName(){
        return departmentName;
    }
    public void set(String departmentName){
        this.departmentName = departmentName;
    }
    public String getContactEmail(){
        return contactEmail;
    }
    public void set(String contactEmail){
        this.contactEmail = contactEmail;
    }
    public String getContactPhone(){
        return contactPhone;
    }
    public void set(String contactPhone){
        this.contactPhone = contactPhone;
    }
    
}