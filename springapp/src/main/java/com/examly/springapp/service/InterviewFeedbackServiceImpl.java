package com.examly.springapp.service;
import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.repository.InterviewFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Collections;
@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {
    @Autowired private InterviewFeedbackRepository repo;
    public InterviewFeedback addInterviewFeedback(InterviewFeedback interviewFeedback) { return null; }
    public List<InterviewFeedback> getAllInterviewFeedbacks() { return Collections.emptyList(); }
    public InterviewFeedback getInterviewFeedbackById(Long id) { return null; }
    public InterviewFeedback updateInterviewFeedback(Long id, InterviewFeedback interviewFeedback) { return null; }
    public List<InterviewFeedback> getFeedbacksByApplicationId(Long applicationId) { return Collections.emptyList(); }
}
