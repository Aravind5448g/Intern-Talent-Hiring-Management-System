package com.examly.springapp.repository;
import com.examly.springapp.model.InterviewFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InterviewFeedbackRepository extends JpaRepository<InterviewFeedback, Long> {
    @Query("SELECT i FROM InterviewFeedback i WHERE i.jobApplication.applicationId = :appId")
    List<InterviewFeedback> findByApplicationId(@Param("appId") Long appId);
}
