package com.just.timeline.repository;

import com.just.timeline.entity.TimelineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineRepository extends JpaRepository<TimelineEntity, Long>, JpaSpecificationExecutor<TimelineEntity>{
}
