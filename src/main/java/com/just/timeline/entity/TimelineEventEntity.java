package com.just.timeline.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(schema = "timeline", name = "timeline_event")
public class TimelineEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_timeline_event")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "resume")
    private String resume;

    @Column(name = "dt_event")
    private LocalDate eventDate;

    @ManyToOne
    @JoinColumn(name = "id_timeline", nullable = false)
    private TimelineEntity timeline;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TimelineEventSourceEntity> sources;

    @Column(name = "dh_created")
    private LocalDateTime createdAt;

    @Column(name = "dh_updated")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
