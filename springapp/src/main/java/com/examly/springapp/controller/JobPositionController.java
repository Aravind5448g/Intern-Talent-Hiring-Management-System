package com.examly.springapp.controller;
import com.examly.springapp.model.JobPosition;
import com.examly.springapp.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/jobposition")
public class JobPositionController {
    @Autowired
    private JobPositionService service;
    @PostMapping
    public ResponseEntity<JobPosition> addJobPosition(@RequestBody JobPosition jobPosition) {
        JobPosition obj = service.addJobPosition(jobPosition);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<JobPosition>> getAllJobPositions() {
        List<JobPosition> list = service.getAllJobPositions();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobPosition> getJobPositionById(@PathVariable Long id) {
        JobPosition obj = service.getJobPositionById(id);
        if(obj == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}