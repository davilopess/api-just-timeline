package com.just.timeline.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "timeline", name = "timeline_event_source")
public class TimelineEventSourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_timeline_event_source")
    private Long id;

    @Column(name = "link")
    private String link;

    @ManyToOne
    @JoinColumn(name = "id_timeline_event", nullable = false)
    private TimelineEventEntity event;
}
