package com.just.timeline.repository;

import com.just.timeline.entity.TimelineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface TimelineRepository extends JpaRepository<TimelineEntity, Long>{
    @Query("SELECT t FROM TimelineEntity t WHERE (:title IS NULL OR t.title LIKE %:title%)")
    List<TimelineEntity> findByFilters(@Param("title") String title);
}
