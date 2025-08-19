package com.toxicant123.config;

import com.toxicant123.controller.WebSocketController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import static com.toxicant123.config.WebConfig.API_PREFIX;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-08-20 00:28
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocketController webSocketController;

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                .addHandler(webSocketController, API_PREFIX + "/ws")
                .addInterceptors(authInterceptor)
                .setAllowedOrigins("*");
    }
}
