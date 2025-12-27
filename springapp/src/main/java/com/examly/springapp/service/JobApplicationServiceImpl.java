
package com.examly.springapp.service;

import com.examly.springapp.model.JobApplication;

import com.examly.springapp.repository.JobApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired private JobApplicationRepository repo;

    public JobApplication addJobApplication(JobApplication jobApplication) { return repo.save(jobApplication); }

    public List<JobApplication> getAllJobApplications() { return repo.findAll(); }

    public JobApplication getJobApplicationById(Long id) { return repo.findById(id).orElse(null); }

}

