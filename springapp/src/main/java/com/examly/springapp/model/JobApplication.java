package com.examly.springapp.model;
import jakarta.persistence.*;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicationId;
    
    private String coverLetter;
    private String resumeUrl;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
     
    public JobApplication(){}

    public long getApplicationId(){
        return applicationId;
    }
    public void setApplicationId(long applicationId){
        this.applicationId = applicationId;
    }
    public String getCoverLetter(){
        return coverLetter;
    }
    public void setCoverLetter(String coverLetter){
        this.coverLetter = coverLetter;
    }
    public String getResumeUrl(){
        return resumeUrl;
    }
    public void setResumeUrl(String resumeUrl){
        this.resumeUrl = resumeUrl;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public user getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
    
}