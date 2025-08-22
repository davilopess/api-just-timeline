package com.just.timeline.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(schema = "timeline", name = "timeline")
public class TimelineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_timeline")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "timeline", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TimelineEventEntity> events;

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
