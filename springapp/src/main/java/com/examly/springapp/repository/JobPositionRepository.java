package com.examly.springapp.repository;
import com.examly.springapp.model.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {
    @Query("SELECT j FROM JobPosition j WHERE LOWER(j.positionTitle) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(j.location) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<JobPosition> searchByKeyword(@Param("keyword") String keyword);
}
