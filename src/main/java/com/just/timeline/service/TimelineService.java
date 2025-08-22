package com.just.timeline.service;

import com.just.timeline.dto.n8n.response.N8nGenerateTimelineResponseDTO;
import com.just.timeline.dto.timeline.request.TimelineRequestDTO;
import com.just.timeline.dto.timeline.response.TimelineResponseDTO;
import com.just.timeline.entity.TimelineEntity;
import com.just.timeline.integrator.N8nTimelineApiIntegrator;
import com.just.timeline.mapper.TimelineMapper;
import com.just.timeline.repository.TimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimelineService {
    private final N8nTimelineApiIntegrator n8nTimelineApiIntegrator;
    private final TimelineRepository repository;
    private final TimelineMapper timelineMapper;

    public TimelineResponseDTO createTimeline(TimelineRequestDTO createTimelineRequestDTO){
        N8nGenerateTimelineResponseDTO n8nTimelineResponse = n8nTimelineApiIntegrator.generateTimeline(createTimelineRequestDTO.description());
        TimelineEntity createdTimeline = repository.save(timelineMapper.toEntity(n8nTimelineResponse));
        return timelineMapper.toDTO(createdTimeline);
    }
}
