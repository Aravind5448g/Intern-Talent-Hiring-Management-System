package com.examly.springapp.service;
import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired private DepartmentRepository repo;
    public Department addDepartment(Department department) { return repo.save(department); }
    public List<Department> getAllDepartments() { return repo.findAll(); }
    public Department getDepartmentById(Long id) { return repo.findById(id).orElse(null); }
    public Department updateDepartment(Long id, Department department) {
        department.setDepartmentId(id);
        return repo.save(department);
    }
    public Page<Department> getDepartmentsPaginated(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}
