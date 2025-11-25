package com.example.client;

import com.example.common.*;
import java.net.*;
import java.io.*;

public class GameClient {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private GameWindow window;
    private String playerName;
    
    public void connect(String serverHost, int port, String playerName) {
        try {
            this.playerName = playerName;
            socket = new Socket(serverHost, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            
            // 發送加入消息
            sendMessage(new Message(Message.Type.JOIN, playerName, playerName));
            
            // 啟動消息接收线程
            new Thread(this::receiveMessages).start();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void receiveMessages() {
        try {
            while (true) {
                Message message = (Message) in.readObject();
                window.displayMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendMessage(Message message) {
        try {
            out.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setWindow(GameWindow window) {
        this.window = window;
    }
    
    public String getPlayerName() {
        return playerName;
    }
}
