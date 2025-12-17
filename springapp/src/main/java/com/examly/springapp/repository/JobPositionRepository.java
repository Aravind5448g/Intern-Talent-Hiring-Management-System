package com.examly.springapp.repository;
import com.examly.springapp.model.JobPosition;
import org.springFramework.data.jpa.repository.JpaRepository;
import org.springFramework.stereotype.Repository;

@Repository
public interface JobPositionRepository extends JpaRepository <JobPosition , Long>{
    
}