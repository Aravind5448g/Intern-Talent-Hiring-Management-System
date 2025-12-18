package com.examly.springapp.controller;
import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.service.InterviewFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/interviewfeedback")
public class InterviewFeedbackController {
    @Autowired
    private InterviewFeedbackService service;
    @PostMapping
    public ResponseEntity<InterviewFeedback> addInterviewFeedback(@RequestBody InterviewFeedback interviewFeedback) {
        InterviewFeedback obj = service.addInterviewFeedback(interviewFeedback);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InterviewFeedback>> getAllInterviewFeedbacks() {
        List<InterviewFeedback> list = service.getAllInterviewFeedbacks();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<InterviewFeedback> getInterviewFeedbackById(@PathVariable Long id) {
        InterviewFeedback obj = service.getInterviewFeedbackById(id);
        if(obj == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}