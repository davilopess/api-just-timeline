package com.just.timeline.repository.specification;

import com.just.timeline.entity.TimelineEntity;
import org.springframework.data.jpa.domain.Specification;

public class TimelineSpecifications {
    public static Specification<TimelineEntity> hasTitle(String title) {
        return (root, query, cb) -> {
            if (title == null || title.trim().isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
        };
    }
}
