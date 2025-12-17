package com.examly.springapp.repository;
import com.examly.springapp.model.JobApplication;
import org.springFramework.data.jpa.repository.JpaRepository;
import org.springFramework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository <JobApplication , Long>{
    
}