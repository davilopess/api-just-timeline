package com.just.timeline.controller;

import com.just.timeline.dto.timeline.request.TimelineRequestDTO;
import com.just.timeline.dto.timeline.response.TimelineResponseDTO;
import com.just.timeline.service.TimelineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timelines")
@RequiredArgsConstructor
public class TimelineController {
    private final TimelineService timelineService;
    @GetMapping
    @Operation(summary = "Listar todas timelines", description = "Listar timelines",
            tags = {"Timeline"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = TimelineResponseDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public List<TimelineResponseDTO> getTimelines(@RequestParam(required = false) String title){
        return timelineService.findTimelines(title);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Buscar uma timeline por id", description = "Buscar timeline",
            tags = {"Timeline"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = TimelineResponseDTO.class)
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public TimelineResponseDTO getTimelineId(@PathVariable Long id){
        return timelineService.findById(id);
    }

    @Operation(summary = "Generate a timeline", description = "Add a new timeline to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Timeline created successfully",
                    content = @Content(schema = @Schema(implementation = TimelineResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "424", description = "Failed to generate timeline N8N.",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "500", description = "An unexpected error occurred.",
                    content = @Content(schema = @Schema()))
    })
    @PostMapping
    public ResponseEntity<TimelineResponseDTO> createTimeline(@RequestBody TimelineRequestDTO createTimelineRequestDTO){
        TimelineResponseDTO timelineResponseDTO = timelineService.createTimeline(createTimelineRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(timelineResponseDTO);
    }




}
