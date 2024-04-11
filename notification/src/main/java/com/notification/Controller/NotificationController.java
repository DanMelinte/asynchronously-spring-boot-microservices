package com.notification.Controller;

import com.notification.Service.NotificationService;
//import com.example.clients.notification.NotificationResponse;
import com.clients.openFeign.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/notification")
public record NotificationController(NotificationService notificationService) {

    @PostMapping
    public void notificationResponse(@RequestBody NotificationRequest notificationRequest) {
        log.info("notification ... {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
//        return ResponseEntity.status(HttpStatus.OK).body("Notification send successfully");
    }

}
