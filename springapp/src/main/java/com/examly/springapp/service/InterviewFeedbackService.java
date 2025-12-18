package com.examly.springapp.service;
import com.examly.springapp.model.InterviewFeedback;
import java.util.List;
public interface InterviewFeedbackService {
    InterviewFeedback addInterviewFeedback(InterviewFeedback interviewFeedback);
    List<InterviewFeedback> getAllInterviewFeedbacks();
    InterviewFeedback getInterviewFeedbackById(Long id);
}