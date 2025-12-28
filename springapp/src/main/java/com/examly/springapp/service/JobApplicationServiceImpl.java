package com.examly.springapp.service;
import com.examly.springapp.model.JobApplication;
import com.examly.springapp.repository.JobApplicationRepository;
import com.examly.springapp.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class JobApplicationServiceImpl implements JobApplicationService {
    private final JobApplicationRepository repo;
    public JobApplicationServiceImpl(JobApplicationRepository repo) { this.repo = repo; }
    public JobApplication addJobApplication(JobApplication jobApplication) { return repo.save(jobApplication); }
    public List<JobApplication> getAllJobApplications() { return repo.findAll(); }
    public JobApplication getJobApplicationById(Long id) { 
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job application not found")); 
    }
    public void deleteJobApplication(Long id) {
        if(!repo.existsById(id)) throw new ResourceNotFoundException("Job application not found");
        repo.deleteById(id);
    }
    public JobApplication updateJobApplication(Long id, JobApplication jobApplication) {
        this.getJobApplicationById(id);
        jobApplication.setApplicationId(id);
        return repo.save(jobApplication);
    }
}
