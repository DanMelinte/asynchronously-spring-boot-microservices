package com.clients.openFeign.notification;

public record NotificationRequest(Integer toCustomerId, String sender, String message) {
}
