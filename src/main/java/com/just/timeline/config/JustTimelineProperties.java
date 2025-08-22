package com.just.timeline.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class JustTimelineProperties {

    @Value("${n8n.generate.timeline.url}")
    private String n8nGenerateTimelineUrl;

}
