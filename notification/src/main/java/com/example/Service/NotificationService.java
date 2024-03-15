package com.example.Service;

import com.example.Entities.Notification;
import com.example.Repository.NotificationRepository;
import com.example.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public void sendNotification(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .sender(notificationRequest.sender())
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()

        );
    }
}
