package com.just.timeline.dto.timeline.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimelineResponseDTO {

    private Long id;
    private String title;
    private List<TimelineEventResponseDTO> events;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
