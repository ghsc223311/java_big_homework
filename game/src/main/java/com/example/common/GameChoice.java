package com.example.common;

import java.io.Serializable;

public enum GameChoice implements Serializable {
    ROCK("石頭", "✊"),
    PAPER("布", "✋"), 
    SCISSORS("剪刀", "✌️");
    
    private String name;
    private String emoji;
    
    GameChoice(String name, String emoji) {
        this.name = name;
        this.emoji = emoji;
    }
    
    public boolean beats(GameChoice other) {
        return (this == ROCK && other == SCISSORS) ||
               (this == PAPER && other == ROCK) ||
               (this == SCISSORS && other == PAPER);
    }
    
    public String getName() { return name; }
    public String getEmoji() { return emoji; }
}
