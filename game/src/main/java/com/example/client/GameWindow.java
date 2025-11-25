package com.example.client;

import com.example.common.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    private GameClient client;
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton rockBtn, paperBtn, scissorsBtn;
    
    public GameWindow(GameClient client) {
        this.client = client;
        setupUI();
    }
    
    private void setupUI() {
        setTitle("石頭剪刀布");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // 聊天區域
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        
        // 輸入區域
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        JButton sendBtn = new JButton("發送");
        
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendBtn, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);
        
        // 選擇按鈕
        JPanel buttonPanel = new JPanel();
        rockBtn = createButton("✊ 石頭", GameChoice.ROCK);
        paperBtn = createButton("✋ 布", GameChoice.PAPER);
        scissorsBtn = createButton("✌️ 剪刀", GameChoice.SCISSORS);
        
        buttonPanel.add(rockBtn);
        buttonPanel.add(paperBtn);
        buttonPanel.add(scissorsBtn);
        add(buttonPanel, BorderLayout.NORTH);
        
        // 事件監聽
        sendBtn.addActionListener(e -> sendChatMessage());
        inputField.addActionListener(e -> sendChatMessage());
        
        setVisible(true);
    }
    
    private JButton createButton(String text, GameChoice choice) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {
            client.sendMessage(new Message(Message.Type.CHOICE, client.getPlayerName(), choice));
            appendMessage("你選擇了: " + choice.getName());
        });
        return button;
    }
    
    private void sendChatMessage() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            client.sendMessage(new Message(Message.Type.CHAT, client.getPlayerName(), text));
            inputField.setText("");
        }
    }
    
    public void displayMessage(Message message) {
        String displayText = message.getPlayerName() + ": " + message.getData();
        appendMessage(displayText);
    }
    
    private void appendMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            chatArea.append(message + "\n");
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        });
    }
}
