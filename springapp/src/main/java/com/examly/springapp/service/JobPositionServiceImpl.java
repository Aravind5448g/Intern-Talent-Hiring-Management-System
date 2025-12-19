package com.examly.springapp.service;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobPositionServiceImpl implements JobPositionService {
    @Autowired
    private JobPositionRepository repo;

    @Override
    public JobPosition addJobPosition(JobPosition jobPosition) { return repo.save(jobPosition); }
    @Override
    public List<JobPosition> getAllJobPositions() { return repo.findAll(); }
    @Override
    public JobPosition getJobPositionById(Long id) { return repo.findById(id).orElse(null); }
}
