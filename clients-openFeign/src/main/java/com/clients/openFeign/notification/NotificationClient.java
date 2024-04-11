package com.clients.openFeign.notification;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient("notification-service")
@FeignClient(
        name = "notification-service",
        url = "${clients.openFeign.notification.url}"
)
public interface NotificationClient {
    @PostMapping(path = "api/notification/")
    void sendNotification(NotificationRequest notificationRequest);
}
