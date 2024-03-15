package com.notification.Service;

import com.notification.Entities.Notification;
import com.notification.Repository.NotificationRepository;
import com.openFeign.clients.notification.NotificationRequest;
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
