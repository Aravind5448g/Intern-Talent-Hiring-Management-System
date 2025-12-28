package com.examly.springapp.controller;
import com.examly.springapp.model.JobApplication;
import com.examly.springapp.service.JobApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {
    private final JobApplicationService service;
    public JobApplicationController(JobApplicationService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<JobApplication> addJobApplication(@RequestBody JobApplication jobApplication) {
        return new ResponseEntity<>(service.addJobApplication(jobApplication), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<JobApplication>> getAllJobApplications() {
        List<JobApplication> list = service.getAllJobApplications();
        if(list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobApplicationById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getJobApplicationById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateJobApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) {
        return new ResponseEntity<>(service.updateJobApplication(id, jobApplication), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
        service.deleteJobApplication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
