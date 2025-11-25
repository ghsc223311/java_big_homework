package main.java.com.example.common;

import java.io.Serializable;

public class Message {
     private static final long serialVersionUID = 1L;
    
    public enum Type {
        PLAYER_JOIN,        // 玩家加入
        PLAYER_READY,       // 玩家準備
        PLAYER_CHOICE,      // 玩家選擇
        GAME_RESULT,        // 遊戲結果
        CHAT_MESSAGE        // 聊天消息
    }
    
    private Type type;
    private String playerId;
    private Object data;
    
    public Message(Type type, String playerId, Object data) {
        this.type = type;
        this.playerId = playerId;
        this.data = data;
    }
    
    // Getters and Setters
    public Type getType() { return type; }
    public String getPlayerId() { return playerId; }
    public Object getData() { return data; }
}
