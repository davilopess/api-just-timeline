package com.just.timeline.integrator;

import com.just.timeline.config.JustTimelineProperties;
import com.just.timeline.dto.n8n.request.N8nGenerateTimelineRequestDTO;
import com.just.timeline.dto.n8n.response.N8nGenerateTimelineResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class N8nTimelineApiIntegrator {

    private final JustTimelineProperties properties;

    public N8nGenerateTimelineResponseDTO generateTimeline(String description) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(
                properties.getN8nGenerateTimelineUrl(),
                new N8nGenerateTimelineRequestDTO(description),
                N8nGenerateTimelineResponseDTO.class);
    }
}
