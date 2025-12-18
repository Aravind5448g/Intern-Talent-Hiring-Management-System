package com.examly.springapp.controller;
import com.examly.springapp.model.Department;
import com.examly.springapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department obj = service.addDepartment(department);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> list = service.getAllDepartments();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department obj = service.getDepartmentById(id);
        if(obj == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}