package com.examly.springapp.service;
import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.repository.InterviewFeedbackRepository;
import com.examly.springapp.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {
    private final InterviewFeedbackRepository repo;
    public InterviewFeedbackServiceImpl(InterviewFeedbackRepository repo) { this.repo = repo; }
    @Override
    public InterviewFeedback addInterviewFeedback(InterviewFeedback feedback) { return repo.save(feedback); }
    @Override
    public List<InterviewFeedback> getAllInterviewFeedbacks() { return repo.findAll(); }
    @Override
    public InterviewFeedback getInterviewFeedbackById(Long id) { 
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Feedback not found with ID: " + id)); 
    }
    @Override
    public InterviewFeedback updateInterviewFeedback(Long id, InterviewFeedback feedback) {
        InterviewFeedback existing = this.getInterviewFeedbackById(id);
        if(feedback.getContent() != null) existing.setContent(feedback.getContent());
        if(feedback.getInterviewRound() != null) existing.setInterviewRound(feedback.getInterviewRound());
        existing.setIsInternal(feedback.getIsInternal());
        if(feedback.getJobApplication() != null) existing.setJobApplication(feedback.getJobApplication());
        if(feedback.getUser() != null) existing.setUser(feedback.getUser());
        return repo.save(existing);
    }
    @Override
    public List<InterviewFeedback> getFeedbacksByApplicationId(Long applicationId) { return repo.findByApplicationId(applicationId); }
}
