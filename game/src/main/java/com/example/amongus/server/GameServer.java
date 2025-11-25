package com.example.amongus.server;
//Socket
import com.example.amongus.common.Message;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {
    private static final int PORT = 8888;
    private CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>() ;
    private GameLogic gameLogic ;
    private ExecutorService threadPool = Executors.newCachedThreadPool() ;

    public GameServer(){
        this.gameLogic = new GameLogic() ;
    }

    public void start(){
        //try-catch捕获
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Among US"+ PORT);
            System.out.println("等待玩家连接...");

            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("新玩家连接:" + clientSocket.getInetAddress());
                // 为每个客户端创建处理线程
                ClientHandler clientHandler = new ClientHandler(clientSocket, clients , gameLogic);
                clients.add(clientHandler);
                threadPool.execute(clientHandler); // 使用线程池管理线程

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new GameServer().start();
    }
}
