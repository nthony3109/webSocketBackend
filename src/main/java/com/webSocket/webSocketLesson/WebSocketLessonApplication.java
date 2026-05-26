package com.webSocket.webSocketLesson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class WebSocketLessonApplication {

	public static void main(String[] args) {
		log.info("starting App");
		SpringApplication.run(WebSocketLessonApplication.class, args);
	}

}
