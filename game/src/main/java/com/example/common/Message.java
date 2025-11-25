package com.example.common;

import java.io.Serializable;

public class Message implements Serializable {
    public enum Type { JOIN, READY, CHOICE, RESULT, CHAT, QUIT }
    
    private Type type;
    private String playerName;
    private Object data;
    
    public Message(Type type, String playerName, Object data) {
        this.type = type;
        this.playerName = playerName;
        this.data = data;
    }
    
    // Getter方法
    public Type getType() { return type; }
    public String getPlayerName() { return playerName; }
    public Object getData() { return data; }
}
