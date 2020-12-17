package com.yunbao.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class WebsocketSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketSpringbootApplication.class, args);
	}

}
