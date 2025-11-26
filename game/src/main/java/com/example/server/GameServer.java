package com.example.server;

import com.example.common.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class GameServer {
    private static final int PORT = 8888;
    private ServerSocket serverSocket;
    private List<ClientHandler> clients = new ArrayList<>();
    private Map<String, GameChoice> choices = new HashMap<>();
    
    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("服務器啟動，端口: " + PORT);
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void broadcast(Message message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }
    
    public void recordChoice(String playerName, GameChoice choice) {
        choices.put(playerName, choice);
        if (choices.size() == 2) {
            calculateResult();
        }
    }
    
    private void calculateResult() {
        // 計算勝負邏輯
        String[] players = choices.keySet().toArray(new String[0]);
        GameChoice choice1 = choices.get(players[0]);
        GameChoice choice2 = choices.get(players[1]);
        
        String result;
        if (choice1 == choice2) {
            result = "平局！雙方都出了 " + choice1.getName();
        } else if (choice1.beats(choice2)) {
            result = players[0] + " 勝利！" + choice1.getEmoji() + " 勝 " + choice2.getEmoji();
        } else {
            result = players[1] + " 勝利！" + choice2.getEmoji() + " 勝 " + choice1.getEmoji();
        }
        
        broadcast(new Message(Message.Type.RESULT, "系統", result));
        choices.clear(); // 清空選擇，準備下一輪
    }
    
    public static void main(String[] args) {
        new GameServer().start();
    }
}
