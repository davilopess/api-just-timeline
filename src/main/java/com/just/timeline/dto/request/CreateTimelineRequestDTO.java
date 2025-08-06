package com.just.timeline.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateTimelineRequestDTO {

    private String title;

    private List<TimelineEventRequestDTO> events;
}
