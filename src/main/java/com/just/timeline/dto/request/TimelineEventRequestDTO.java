package com.just.timeline.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TimelineEventRequestDTO {

    private String title;

    private String resume;

    private LocalDate eventDate;
}
