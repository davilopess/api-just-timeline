package com.just.timeline.service;

import com.just.timeline.dto.n8n.response.N8nGenerateTimelineResponseDTO;
import com.just.timeline.dto.timeline.request.TimelineRequestDTO;
import com.just.timeline.dto.timeline.response.TimelineResponseDTO;
import com.just.timeline.dto.timeline.TimelineDTO;
import com.just.timeline.entity.TimelineEntity;
import com.just.timeline.integrator.N8nTimelineApiIntegrator;
import com.just.timeline.mapper.TimelineMapper;
import com.just.timeline.repository.TimelineRepository;
import com.just.timeline.exception.TimelineNotFoundException;
import com.just.timeline.repository.specification.TimelineSpecifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;


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

    public TimelineDTO findById(Long id) {
        TimelineEntity timeline = repository.findById(id)
                .orElseThrow(() -> new TimelineNotFoundException(id));

        return timelineMapper.TimelineToDTO(timeline);
    }

    public List<TimelineDTO> findTimelines(String title) {
        Specification<TimelineEntity> spec = Specification
                .where(TimelineSpecifications.hasTitle(title));

        return repository.findAll(spec).stream()
                .map(t -> timelineMapper.TimelineToDTO(t))
                .collect(Collectors.toList());
    }
}
