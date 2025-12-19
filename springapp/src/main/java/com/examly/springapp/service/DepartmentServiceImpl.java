package com.examly.springapp.service;
import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repo;
    @Override
    public Department addDepartment(Department department) { return repo.save(department); }
    @Override
    public List<Department> getAllDepartments() { return repo.findAll(); }
    @Override
    public Department getDepartmentById(Long id) { return repo.findById(id).orElse(null); }
}