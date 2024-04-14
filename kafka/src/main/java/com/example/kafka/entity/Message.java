package com.example.kafka.entity;

import java.time.LocalDateTime;

public record Message(String message, LocalDateTime created) {
}
