package com.test.socketIo.config;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocketIOConfig {

    @Value("${socket-server.host}")
    private String SOCKET_SERVER_HOST;

    @Value("${socket-server.port}")
    private int SOCKET_SERVER_PORT;

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname(SOCKET_SERVER_HOST);
        config.setPort(SOCKET_SERVER_PORT);

        return new SocketIOServer(config);
    }
}
