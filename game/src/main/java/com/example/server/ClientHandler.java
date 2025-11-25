package com.example.server;

import com.example.common.*;
import java.net.*;
import java.io.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private GameServer server;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private String playerName;
    
    public ClientHandler(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;
    }
    
    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            
            while (true) {
                Message message = (Message) in.readObject();
                handleMessage(message);
            }
        } catch (Exception e) {
            // 客戶端斷開連接
        }
    }
    
    private void handleMessage(Message message) {
        switch (message.getType()) {
            case JOIN:
                playerName = (String) message.getData();
                server.broadcast(new Message(Message.Type.CHAT, "系統", playerName + " 加入了遊戲"));
                break;
            case CHOICE:
                server.recordChoice(playerName, (GameChoice) message.getData());
                break;
            case CHAT:
                server.broadcast(message);
                break;
        }
    }
    
    public void sendMessage(Message message) {
        try {
            out.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
