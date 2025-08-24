package com.just.timeline.exception;

public class TimelineNotFoundException extends RuntimeException {
    public TimelineNotFoundException(Long id) {
        super("Timeline " + id + " não encontrada");
    }
}
