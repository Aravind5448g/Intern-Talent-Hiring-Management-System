package com.examly.springapp.repository;
import com.examly.springapp.model.InterviewFeedback;
import org.springFramework.data.jpa.repository.JpaRepository;
import org.springFramework.stereotype.Repository;

@Repository
public interface InterviewFeedbackRepository extends JpaRepository <InterviewFeedback , Long>{
    
}