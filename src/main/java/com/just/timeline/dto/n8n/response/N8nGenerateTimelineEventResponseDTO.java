package com.just.timeline.dto.n8n.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class N8nGenerateTimelineEventResponseDTO {

    private String title;
    private String resume;
    private LocalDate eventDate;
    private List<GenerateTimelineEventSourceExternalResponseDTO> sources;

}
