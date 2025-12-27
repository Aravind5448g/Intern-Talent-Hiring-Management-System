
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

    public List<InterviewFeedback> getFeedbacksByApplicationId(Long applicationId) { return repo.findByApplicationId(applicationId); }

}

