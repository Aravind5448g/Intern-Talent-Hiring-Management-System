package com.examly.springapp.service;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Department;
import com.examly.springapp.model.JobPosition;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.repository.JobPositionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class JobPositionServiceImpl implements JobPositionService {
    private final JobPositionRepository jobPositionRepository;
    private final DepartmentRepository departmentRepository;
    public JobPositionServiceImpl(JobPositionRepository jobPositionRepository, DepartmentRepository departmentRepository) {
        this.jobPositionRepository = jobPositionRepository;
        this.departmentRepository = departmentRepository;
    }
    @Override
    public JobPosition addJobPosition(JobPosition jobPosition) {
        Department dept = departmentRepository.findById(jobPosition.getDepartment().getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + jobPosition.getDepartment().getDepartmentId()));
        jobPosition.setDepartment(dept);
        return jobPositionRepository.save(jobPosition);
    }
    @Override
    public List<JobPosition> getAllJobPositions() {
        return jobPositionRepository.findAll();
    }
    @Override
    public JobPosition getJobPositionById(Long id) {
        return jobPositionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job position not found with ID: " + id));
    }
    @Override
    public JobPosition updateJobPosition(Long id, JobPosition jobPosition) {
        this.getJobPositionById(id);
        jobPosition.setPositionId(id);
        return jobPositionRepository.save(jobPosition);
    }
    @Override
    public List<JobPosition> searchJobPositions(String keyword) {
        return jobPositionRepository.searchByKeyword(keyword);
    }
}
