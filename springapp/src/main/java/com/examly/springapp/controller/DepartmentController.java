package com.examly.springapp.controller;
import com.examly.springapp.model.Department;
import com.examly.springapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired 
    private DepartmentService service;
    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(service.addDepartment(department), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<>(service.getAllDepartments(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getDepartmentById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return new ResponseEntity<>(service.updateDepartment(id, department), HttpStatus.OK);
    }
    @GetMapping("/page/{pageNo}/{pageSize}")
    public ResponseEntity<Page<Department>> getDepartmentsPaginated(@PathVariable int pageNo, @PathVariable int pageSize) {
        return new ResponseEntity<>(service.getDepartmentsPaginated(pageNo, pageSize), HttpStatus.OK);
    }
}
