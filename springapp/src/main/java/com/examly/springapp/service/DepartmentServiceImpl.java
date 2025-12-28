package com.examly.springapp.service;
import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repo;
    public DepartmentServiceImpl(DepartmentRepository repo) {
        this.repo = repo;
    }
    @Override
    public Department addDepartment(Department department) { return repo.save(department); }
    @Override
    public List<Department> getAllDepartments() { return repo.findAll(); }
    @Override
    public Department getDepartmentById(Long id) { 
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + id)); 
    }
    @Override
    public Department updateDepartment(Long id, Department department) {
        this.getDepartmentById(id); // Check existence
        department.setDepartmentId(id);
        return repo.save(department);
    }
    @Override
    public Page<Department> getDepartmentsPaginated(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}
