package com.just.timeline.dto.n8n.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class N8nGenerateTimelineResponseDTO {

    String title;
    List<N8nGenerateTimelineEventResponseDTO> events;
}
