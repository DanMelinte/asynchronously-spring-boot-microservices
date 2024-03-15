package com.openFeign.clients.notification;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification-service")
public interface NotificationClient {
    @PostMapping(path = "api/notification/")
    void sendNotification(NotificationRequest notificationRequest);
}
