package com.just.timeline.controller;

import com.just.timeline.dto.request.CreateTimelineRequestDTO;
import com.just.timeline.dto.response.TimelineResponseDTO;
import com.just.timeline.service.TimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timelines")
@RequiredArgsConstructor
public class TimelineController {
    private final TimelineService timelineService;

    @PostMapping
    public ResponseEntity<TimelineResponseDTO> createTimeline(@RequestBody CreateTimelineRequestDTO createTimelineRequestDTO){
        TimelineResponseDTO timelineResponseDTO = timelineService.createTimeline(createTimelineRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(timelineResponseDTO);
    }
}
