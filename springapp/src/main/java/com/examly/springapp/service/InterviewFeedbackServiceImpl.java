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
        InterviewFeedback existing = repo.findById(id).orElse(null);
        
        if (existing != null) {
            existing.setContent(interviewFeedback.getContent());
            existing.setIsInternal(interviewFeedback.getIsInternal());
            existing.setInterviewRound(interviewFeedback.getInterviewRound());
            
            if (interviewFeedback.getJobApplication() != null) {
                existing.setJobApplication(interviewFeedback.getJobApplication());
            }
            if (interviewFeedback.getUser() != null) {
                existing.setUser(interviewFeedback.getUser());
            }
            
            return repo.save(existing);
        }
        return null;
    }

    @Override
    public List<InterviewFeedback> getFeedbacksByApplicationId(Long applicationId) {
        return repo.findByApplicationId(applicationId);
    }
}
