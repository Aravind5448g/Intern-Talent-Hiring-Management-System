package com.examly.springapp.service;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.repository.InterviewFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {

    @Autowired
    private InterviewFeedbackRepository repo;

    @Override
    public InterviewFeedback addInterviewFeedback(InterviewFeedback interviewFeedback) {
        return repo.save(interviewFeedback);
    }

    @Override
    public List<InterviewFeedback> getAllInterviewFeedbacks() {
        return repo.findAll();
    }

    @Override
    public InterviewFeedback getInterviewFeedbackById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public InterviewFeedback updateInterviewFeedback(Long id, InterviewFeedback interviewFeedback) {
        // FETCH existing record first
        InterviewFeedback existing = repo.findById(id).orElse(null);
        
        if (existing != null) {
            // Update only the fields provided in the request
            existing.setContent(interviewFeedback.getContent());
            existing.setIsInternal(interviewFeedback.getIsInternal());
            existing.setInterviewRound(interviewFeedback.getInterviewRound());
            
            // CRITICAL: Only update user/application if they are NOT null in the request
            // This prevents wiping out the relationship during a partial update
            if (interviewFeedback.getJobApplication() != null) {
                existing.setJobApplication(interviewFeedback.getJobApplication());
            }
            if (interviewFeedback.getUser() != null) {
                existing.setUser(interviewFeedback.getUser());
            }
            
            return repo.save(existing);
        }
        return null; // Or handle as Not Found
    }

    @Override
    public List<InterviewFeedback> getFeedbacksByApplicationId(Long applicationId) {
        // Using the query method we defined earlier
        return repo.findByApplicationId(applicationId);
    }
}
