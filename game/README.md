# 石頭剪刀布網絡遊戲

這是一個基於 Java Swing 和 Socket 編程的多人石頭剪刀布網絡遊戲。

## 功能特點

- 多人網絡對戰
- 實時聊天功能
- 美觀的圖形界面
- 表情符號支持

## 系統需求

- Java 8 或更高版本
- Maven 3.6 或更高版本

## 安裝與運行

### 1. 編譯項目
```bash
cd game

# 編譯所有 Java 檔案
javac -d target/classes src/main/java/com/example/common/GameChoice.java
javac -d target/classes -cp target/classes src/main/java/com/example/common/Message.java
javac -d target/classes -cp target/classes src/main/java/com/example/server/ClientHandler.java src/main/java/com/example/server/GameServer.java
javac -d target/classes -cp target/classes src/main/java/com/example/client/GameClient.java src/main/java/com/example/client/GameWindow.java src/main/java/com/example/RPSGame.java
```

### 2. 啟動服務器
```bash
cd game
java -cp target/classes com.example.server.GameServer
```

### 3. 啟動客戶端（多個）
```bash
cd game
java -cp target/classes com.example.RPSGame
```

**注意：** 請確保先啟動伺服器，再啟動客戶端。

## 故障排除

### 常見問題解決方案：

1. **編譯錯誤：NoClassDefFoundError**
   - 解決：使用手動編譯方式，確保所有類別檔案都正確生成

2. **序列化錯誤**
   - 解決：GameChoice 枚舉已實現 Serializable 接口

3. **連接失敗**
   - 確保服務器已啟動在端口 8888
   - 檢查防火牆設置
   - 確保先啟動伺服器再啟動客戶端

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

1. **啟動服務器**：首先運行服務器程序
2. **啟動客戶端**：運行多個客戶端程序
3. **輸入名稱**：每個客戶端輸入玩家名稱
4. **開始遊戲**：選擇石頭、剪刀或布進行對戰
5. **聊天交流**：使用聊天框與其他玩家交流

## 遊戲規則

- 石頭 ✊ 勝 剪刀 ✌️
- 剪刀 ✌️ 勝 布 ✋  
- 布 ✋ 勝 石頭 ✊

## 技術棧

- Java 21
- Swing (GUI)
- Socket 編程
- 多線程
- Maven 項目管理

## 開發日誌

- Day 1：基礎網絡通信 + 簡單GUI
- Day 2：遊戲邏輯 + 勝負判斷  
- Day 3：聊天功能 + 界面美化 + 測試

## 修復記錄

- 更新 Java 版本到 21
- 修復 GameChoice 序列化問題
- 更新 Windows PowerShell 使用說明
