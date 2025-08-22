package com.just.timeline.mapper;

import com.just.timeline.dto.n8n.response.N8nGenerateTimelineResponseDTO;
import com.just.timeline.dto.timeline.response.TimelineResponseDTO;
import com.just.timeline.entity.TimelineEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimelineMapper {

    TimelineEntity toEntity(N8nGenerateTimelineResponseDTO n8nGenerateTimelineResponseDTO);

    TimelineResponseDTO toDTO(TimelineEntity timelineEntity);
}
