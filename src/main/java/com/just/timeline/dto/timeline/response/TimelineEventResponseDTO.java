package com.just.timeline.dto.timeline.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimelineEventResponseDTO {

    private Long id;
    private String title;
    private String resume;
    private List<TimelineEventSourceResponseDTO> sources;
    private LocalDate eventDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
