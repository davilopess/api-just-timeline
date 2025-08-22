package com.just.timeline.dto.timeline.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimelineEventSourceResponseDTO {

    private Long id;
    private String link;
}
