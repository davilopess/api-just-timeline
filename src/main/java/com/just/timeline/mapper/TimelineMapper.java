package com.just.timeline.mapper;

import com.just.timeline.dto.n8n.response.N8nGenerateTimelineResponseDTO;
import com.just.timeline.dto.timeline.response.TimelineResponseDTO;
import com.just.timeline.dto.timeline.TimelineDTO;
import com.just.timeline.entity.TimelineEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TimelineMapper {

    TimelineEntity toEntity(N8nGenerateTimelineResponseDTO n8nGenerateTimelineResponseDTO);

    TimelineResponseDTO toDTO(TimelineEntity timelineEntity);

    TimelineDTO TimelineToDTO(TimelineEntity timelineEntity);

    @AfterMapping
    default void setupRelations(@MappingTarget TimelineEntity entity) {
        Optional.ofNullable(entity.getEvents())
                .ifPresent(events -> events.forEach(event -> {
                    event.setTimeline(entity);

                    Optional.ofNullable(event.getSources())
                            .ifPresent(sources -> sources.forEach(source -> source.setEvent(event)));
                }));
    }
}
