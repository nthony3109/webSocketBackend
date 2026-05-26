package com.webSocket.webSocketLesson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class Controller {
    private final LogicClass logicClass;


    public Controller(LogicClass logicClass) {
        this.logicClass = logicClass;
    }

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody NotificatiionInfo info) {
        log.info("data received", info);
        System.out.println(info);
        logicClass.sendNotification(info);
    }
}
