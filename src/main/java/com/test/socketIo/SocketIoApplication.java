package com.test.socketIo;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class SocketIoApplication implements CommandLineRunner {

    private final SocketIOServer socketIOServer;

    public static void main(String[] args) {
        SpringApplication.run(SocketIoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        socketIOServer.start();
    }
}
