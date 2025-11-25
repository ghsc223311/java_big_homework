package com.example.amongus.common;

import java.awt.*;
import java.io.Serializable;

public class Player {
    private String id ;
    private String name ;
    private int x , y ; 
    private Color color ;
    private boolean isAlive = true ; // 生存状态
    private boolean isImpostor = false ; //角色身份
    private int taskCompleted = 0 ;
    private int totalTask = 5 ; // 每个玩家5个任务

    public Player(String id, String name , Color color){
        this.id = id ;
        this.name = name ;
        this.color = color ;
        this.x = 400 ;
        this.y = 300 ;
    }

    public void move(int dx , int dy){
        this.x += dx ;
        this.y += dy ;
        // 边界检查
        this.x = Math.max(0, Math.min(800,this.x));
        this.y = Math.max(0,Math.min(600,this.y));
    }
    public void completeTask(){
        if(isAlive && !isImpostor){
            taskCompleted++ ;
        }
    }
    public boolean areAllTaskCompleted(){
        return taskCompleted >= totalTask ;
    }
    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getX() { return x; }
    public int getY() { return y; }
    public Color getColor() { return color; }
    public boolean isAlive() { return isAlive; }
    public boolean isImpostor() { return isImpostor; }
    public void setImpostor(boolean impostor) { isImpostor = impostor; }
    public void setAlive(boolean alive) { isAlive = alive; }
    public int getTasksCompleted() { return taskCompleted; }
    public int getTotalTasks() { return totalTask; }
}
