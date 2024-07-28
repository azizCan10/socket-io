package com.test.socketIo.socket;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.test.socketIo.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SocketModule {

    private final SocketIOServer socketIOServer;

    public SocketModule(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
        socketIOServer.addConnectListener(onConnected());
        socketIOServer.addDisconnectListener(onDisconnected());
        socketIOServer.addEventListener("sendMessage", MessageDTO.class, onMessageReceived());
    }

    private ConnectListener onConnected() {
        return client -> log.info("SocketID: {} connected", client.getSessionId().toString());
    }

    private DisconnectListener onDisconnected() {
        return client -> log.info("SocketID: {} disconnected", client.getSessionId().toString());
    }

    private DataListener<MessageDTO> onMessageReceived() {
        return (senderClient, data, ackSender) -> {
            log.info("{}: {}", senderClient.getSessionId().toString(), data.content());

            String room = senderClient.getHandshakeData().getSingleUrlParam("room");
            senderClient.getNamespace().getRoomOperations(room).getClients()
                    .forEach(client -> {
                        if (!client.getSessionId().equals(senderClient.getSessionId())) {
                            client.sendEvent("getMessage", data.content());
                        }
                    });
        };
    }
}
