package com.example.example02.VO;

public class ChattingRoom {
    private String name;
    private String lastChat;
    private String lastTime;

    public ChattingRoom(String name) {
        this(name, null, null);
    }

    public ChattingRoom(String name, String lastChat, String lastTime) {
        this.name = name;
        this.lastChat = lastChat;
        this.lastTime = lastTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastChat() {
        return lastChat;
    }

    public void setLastChat(String lastChat) {
        this.lastChat = lastChat;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}
