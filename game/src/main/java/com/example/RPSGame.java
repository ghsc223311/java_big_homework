package com.example;

import com.example.client.*;
import javax.swing.*;

public class RPSGame {
    public static void main(String[] args) {
        String playerName = JOptionPane.showInputDialog("請輸入你的名字:");
        if (playerName != null && !playerName.trim().isEmpty()) {
            GameClient client = new GameClient();
            GameWindow window = new GameWindow(client);
            client.setWindow(window);
            client.connect("localhost", 8888, playerName.trim());
        }
    }
}
