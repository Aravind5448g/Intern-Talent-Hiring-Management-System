package com.examly.springapp.repository;
import com.examly.springapp.model.User;
import org.springFramework.data.jpa.repository.JpaRepository;
import org.springFramework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User , Long>{
    
}