package com.examly.springapp.service;
import com.examly.springapp.model.Department;
import java.util.List;
public interface DepartmentService {
    Department addDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
}