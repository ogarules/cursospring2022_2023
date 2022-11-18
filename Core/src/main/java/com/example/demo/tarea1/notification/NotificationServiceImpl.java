package com.example.demo.tarea1.notification;

import com.example.demo.tarea1.message.IMessageService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements INotificationService {
    IMessageService facebookMessageService;
    IMessageService twitterMessageService;
    IMessageService emailMessageService;

    @Override
    public void notifyTo(String user, String message, NotificationType notificationType) {
        log.info("Sending message....");

        switch (notificationType) {
            case FACEBOOK:
                this.facebookMessageService.sendMessage(user, message);
                break;
            case TWITTER:
                this.twitterMessageService.sendMessage(user, message);
                break;
            case EMAIL:
                this.emailMessageService.sendMessage(user, message);
                break;
            default:
                break;
        }
    }
}
