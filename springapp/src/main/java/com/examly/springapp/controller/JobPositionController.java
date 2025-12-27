
package com.examly.springapp.controller;

import com.examly.springapp.model.JobPosition;

import com.examly.springapp.service.JobPositionService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/job-positions")

public class JobPositionController {

    @Autowired private JobPositionService service;

    @PostMapping

    public ResponseEntity<JobPosition> addJobPosition(@RequestBody JobPosition jobPosition) {

        return new ResponseEntity<>(service.addJobPosition(jobPosition), HttpStatus.CREATED);

    }

    @GetMapping

    public ResponseEntity<List<JobPosition>> getAllJobPositions() {

        return new ResponseEntity<>(service.getAllJobPositions(), HttpStatus.OK);

    }

    @GetMapping("/{id}")

    public ResponseEntity<JobPosition> getJobPositionById(@PathVariable Long id) {

        return new ResponseEntity<>(service.getJobPositionById(id), HttpStatus.OK);

    }

    @PutMapping("/{id}")

    public ResponseEntity<JobPosition> updateJobPosition(@PathVariable Long id, @RequestBody JobPosition jobPosition) {

        return new ResponseEntity<>(service.updateJobPosition(id, jobPosition), HttpStatus.OK);

    }

    @GetMapping("/search/{keyword}")

    public ResponseEntity<List<JobPosition>> searchJobPositions(@PathVariable String keyword) {

        return new ResponseEntity<>(service.searchJobPositions(keyword), HttpStatus.OK);

    }

}

