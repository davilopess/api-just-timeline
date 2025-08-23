package com.just.timeline.integrator;

import com.just.timeline.config.JustTimelineProperties;
import com.just.timeline.dto.n8n.request.N8nGenerateTimelineRequestDTO;
import com.just.timeline.dto.n8n.response.N8nGenerateTimelineResponseDTO;
import com.just.timeline.exception.N8nTimelineIntegrationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class N8nTimelineApiIntegrator {
    private final JustTimelineProperties properties;
    private final RestTemplate restTemplate;

    public N8nGenerateTimelineResponseDTO generateTimeline(String description) {
        try{
            return restTemplate.postForObject(
                    properties.getN8nGenerateTimelineUrl(),
                    new N8nGenerateTimelineRequestDTO(description),
                    N8nGenerateTimelineResponseDTO.class);

        }catch (Exception e){
            log.error("Failed to generate timeline N8N", e);
            throw new N8nTimelineIntegrationException();
        }
    }
}
