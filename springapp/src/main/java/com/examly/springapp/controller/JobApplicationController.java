package com.examly.springapp.controller;
import com.examly.springapp.model.JobApplication;
import com.examly.springapp.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {
    @Autowired private JobApplicationService service;
    @PostMapping
    public ResponseEntity<JobApplication> addJobApplication(@RequestBody(required = false) JobApplication jobApplication) {
        if (jobApplication == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(service.addJobApplication(jobApplication), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<JobApplication>> getAllJobApplications() {
        List<JobApplication> list = service.getAllJobApplications();
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getJobApplicationById(@PathVariable Long id) {
        JobApplication obj = service.getJobApplicationById(id);
        if (obj == null) return new ResponseEntity<>("Job application not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateJobApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) {
        return new ResponseEntity<>(service.addJobApplication(jobApplication), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
