package com.example.amongus.common;

import java.io.Serializable;
import java.util.List;

public class Message {
    private static final long serialVersionUID = 1L ;    
    
    public enum Type{
        PLAYER_JOIN,      // 玩家加入
        PLAYER_MOVE,      // 玩家移动
        PLAYER_ACTION,    // 玩家行动（任务/破坏）
        PLAYER_REPORT,    // 报告尸体
        EMERGENCY_MEETING,// 紧急会议
        VOTE,             // 投票
        GAME_STATE,       // 游戏状态更新
        CHAT_MESSAGE      // 聊天消息
    }

    private Type type ;
    private String playerID ;
    private Object data ;
    private long timestamp ;

    public Message(Type type , String playerID , Object data){
        this.type = type ;
        this.playerID = playerID ;
        this.data = data ;
        this.timestamp = System.currentTimeMillis(); // 记录消息创建时间
    }

    //Getters and Setters 
    public Type getType(){return type;}
    public String getPalyerID(){return playerID;}
    public Object getData(){return data;}
    public long getTimestmap(){return timestamp;}
}
