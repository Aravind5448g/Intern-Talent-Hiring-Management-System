package com.examly.springapp.model;
import jakarta.persistence.*;

@Entity
public class InterviewFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long feedbackId;
    
    private String content;
    private boolean isInternal;
    private String interviewRound;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private JobApplication jobApplication;
     
    public InterviewFeedback(){}

    public long getfeedbackId(){
        return feedbackId;
    }
    public void setfeedbackId(long feedbackId){
        this.feedbackId = feedbackId;
    }
    public String getcontent(){
        return content;
    }
    public void setcontent(String content){
        this.content = content;
    }
    public boolean getisInternal(){
        return isInternal;
    }
    public void setisInternal(boolean isInternal){
        this.isInternal = isInternal;
    }
    public String getinterviewRound(){
        return interviewRound;
    }
    public void setinterviewRound(String interviewRound){
        this.interviewRound = interviewRound;
    }
    public jobApplication getJobApplication(){
        return jobApplication;
    }
    public void setJobApplication(JobApplication jobApplication){
        this.jobApplication = jobApplication;
    }
    
}