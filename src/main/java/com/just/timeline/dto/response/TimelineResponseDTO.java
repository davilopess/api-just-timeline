package com.just.timeline.dto.response;

import com.just.timeline.entity.TimelineEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TimelineResponseDTO {

    private Long id;

    private String title;

    private List<TimelineEventResponseDTO> events;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TimelineResponseDTO(TimelineEntity timelineEntity){
        this.id = timelineEntity.getId();
        this.title = timelineEntity.getTitle();
    }
}
