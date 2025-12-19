package com.examly.springapp.service;
import com.examly.springapp.model.JobApplication;
import com.examly.springapp.repository.JobApplicationRepository;
import com.examly.springapp.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
    @Autowired
    private JobApplicationRepository repo;
    @Override
    public JobApplication addJobApplication(JobApplication jobApplication) { return repo.save(jobApplication); }
    @Override
    public List<JobApplication> getAllJobApplications() { return repo.findAll(); }
    @Override
    public JobApplication getJobApplicationById(Long id) { return repo.findById(id).orElse(null); }
}