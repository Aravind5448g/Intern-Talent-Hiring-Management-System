package com.examly.springapp.controller;
import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.service.InterviewFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/interview-feedbacks")
public class InterviewFeedbackController {
    @Autowired private InterviewFeedbackService service;
    @PostMapping
    public ResponseEntity<InterviewFeedback> addInterviewFeedback(@RequestBody InterviewFeedback interviewFeedback) {
        return new ResponseEntity<>(service.addInterviewFeedback(interviewFeedback), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InterviewFeedback>> getAllInterviewFeedbacks() {
        return new ResponseEntity<>(service.getAllInterviewFeedbacks(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<InterviewFeedback> getInterviewFeedbackById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getInterviewFeedbackById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<InterviewFeedback> updateInterviewFeedback(@PathVariable Long id, @RequestBody InterviewFeedback interviewFeedback) {
        return new ResponseEntity<>(service.updateInterviewFeedback(id, interviewFeedback), HttpStatus.OK);
    }
    @GetMapping("/application/{applicationId}")
    public ResponseEntity<List<InterviewFeedback>> getFeedbacksByJobApplication(@PathVariable Long applicationId) {
        return new ResponseEntity<>(service.getFeedbacksByApplicationId(applicationId), HttpStatus.OK);
    }
}
