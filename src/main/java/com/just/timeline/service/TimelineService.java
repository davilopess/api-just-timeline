package com.just.timeline.service;

import com.just.timeline.dto.request.CreateTimelineRequestDTO;
import com.just.timeline.dto.response.TimelineResponseDTO;
import com.just.timeline.entity.TimelineEntity;
import com.just.timeline.repository.TimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimelineService {
    private final TimelineRepository repository;

    public TimelineResponseDTO createTimeline(CreateTimelineRequestDTO createTimelineRequestDTO){
        TimelineEntity timelineEntity = new TimelineEntity(createTimelineRequestDTO);
        timelineEntity.getEvents().forEach(event -> event.setTimeline(timelineEntity));
        TimelineEntity timelineSaved = repository.save(timelineEntity);
        return new TimelineResponseDTO(timelineSaved);
    }
}
