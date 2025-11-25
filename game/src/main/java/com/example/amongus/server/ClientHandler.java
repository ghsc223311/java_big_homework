package com.example.amongus.server;

import com.example.amongus.common.Message;
import com.example.amongus.common.Player;
import java.net.Socket;
import java.io.*;
import java.util.List;

public class ClientHandler implements Runnable{
    private Socket socket;
    private List<ClientHandler> clients ;
    private GameLogic gameLogic ;
    private ObjectOutputStream out ;
    private ObjectInputStream in ;
    private Player player ;

    public ClientHandler(Socket socket , List<ClientHandler> clients , GameLogic gameLogic){
        this.socket = socket ;
        this.clients = clients ;
        this.gameLogic = gameLogic ;
    }

    @Override
    public void run(){
        try{
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            // 接收玩家信息
            Message joinMessage = (Message) in.readObject();
            //味寫gameLogic 调用游戏逻辑，添加这个玩家到游戏中（存玩家ID和名字）
            this.player = gameLogic.addPlayer(joinMessage.getPalyerID(),(String) joinMessage.getData()); 

            System.out.println("玩家 " + player.getName() + " 加入游戏");
        }
        catch(Exception e){

        }
    } 
}
