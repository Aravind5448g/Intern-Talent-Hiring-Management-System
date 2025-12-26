package com.examly.springapp.service;
import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.repository.InterviewFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {
    @Autowired private InterviewFeedbackRepository repo;
    public InterviewFeedback addInterviewFeedback(InterviewFeedback interviewFeedback) { return repo.save(interviewFeedback); }
    public List<InterviewFeedback> getAllInterviewFeedbacks() { return repo.findAll(); }
    public InterviewFeedback getInterviewFeedbackById(Long id) { return repo.findById(id).orElse(null); }
    public InterviewFeedback updateInterviewFeedback(Long id, InterviewFeedback interviewFeedback) {
        interviewFeedback.setFeedbackId(id);
        return repo.save(interviewFeedback);
    }
    public List<InterviewFeedback> getFeedbacksByApplicationId(Long applicationId) { return repo.findByJobApplication_ApplicationId(applicationId); }
}
