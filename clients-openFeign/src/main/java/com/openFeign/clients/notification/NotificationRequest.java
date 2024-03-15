package com.openFeign.clients.notification;

public record NotificationRequest(Integer toCustomerId, String sender, String message) {
}
