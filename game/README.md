# 石頭剪刀布網絡遊戲

這是一個基於 Java Swing 和 Socket 編程的多人石頭剪刀布網絡遊戲。

## 功能特點

- 多人網絡對戰
- 實時聊天功能
- 美觀的圖形界面
- 表情符號支持

## 運行方式

### 1. 啟動服務器
```bash
cd game
mvn compile exec:java -Dexec.mainClass="com.example.server.GameServer"
```

### 2. 啟動客戶端（多個）
```bash
cd game
mvn compile exec:java -Dexec.mainClass="com.example.RPSGame"
```

## 項目結構

```
game/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   ├── RPSGame.java          # 主程序入口
│                   ├── client/
│                   │   ├── GameClient.java   # 客戶端邏輯
│                   │   └── GameWindow.java   # 圖形界面
│                   ├── common/
│                   │   ├── GameChoice.java   # 遊戲選擇枚舉
│                   │   └── Message.java      # 消息類
│                   └── server/
│                       ├── GameServer.java   # 服務器主程序
│                       └── ClientHandler.java # 客戶端處理器
├── pom.xml              # Maven 配置文件
└── README.md           # 項目說明
```

## 使用說明

1. 首先啟動服務器
2. 然後啟動多個客戶端
3. 每個客戶端輸入玩家名稱
4. 選擇石頭、剪刀或布進行遊戲
5. 可以通過聊天框進行交流

## 技術棧

- Java 11
- Swing (GUI)
- Socket 編程
- 多線程
- Maven
