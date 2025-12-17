package com.examly.springapp.repository;
import com.examly.springapp.model.Department;
import org.springFramework.data.jpa.repository.JpaRepository;
import org.springFramework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <Department , Long>{

}