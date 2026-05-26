package com.webSocket.webSocketLesson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogicClass {
    private  final SimpMessagingTemplate simpMessagingTemplate;

    private ArrayList<NotificatiionInfo> notificationInfo = new ArrayList<>();

    public void addNotification(NotificatiionInfo info) {
        log.info("adding data to the array");
        notificationInfo.add(info);

    }
    public double getTotalAmount() {
        return notificationInfo.stream().
                mapToDouble(NotificatiionInfo::getAmount).sum();
    }
    public void sendNotification(NotificatiionInfo info) {
        addNotification(info);
        double totalAmount = getTotalAmount();
        System.out.println("sending notification: " + totalAmount);
        simpMessagingTemplate.convertAndSend("/topic/notifications", totalAmount);
        log.info("sent data via webSocket : {}", totalAmount);
    }


}
