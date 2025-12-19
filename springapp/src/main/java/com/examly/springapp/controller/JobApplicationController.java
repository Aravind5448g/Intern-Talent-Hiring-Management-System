package com.examly.springapp.controller;
import com.examly.springapp.model.JobApplication;
import com.examly.springapp.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobapplication")
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    @PostMapping
    public ResponseEntity<JobApplication> addJobApplication(@RequestBody(required = false) JobApplication jobApplication) {
        // Fix for "NoBody_StatusBadRequestFailure"
        if (jobApplication == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        JobApplication obj = service.addJobApplication(jobApplication);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobApplication>> getAllJobApplications() {
        List<JobApplication> list = service.getAllJobApplications();
        // Fix for "StatusNoContentFailure"
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobApplicationById(@PathVariable Long id) {
        JobApplication obj = service.getJobApplicationById(id);
        // Fix for "StatusNotFoundFailure"
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateJobApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) {
        JobApplication check = service.getJobApplicationById(id);
        if (check == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        jobApplication.setApplicationId(id);
        JobApplication updated = service.addJobApplication(jobApplication);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
        JobApplication obj = service.getJobApplicationById(id);
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

