package com.example.demo.model.admin;

public class User {
    private int playerId;
    private String playerName;
    private String playerColor;
    private int gameId;

    public static final int MAX_NO_USERS = 4;
    public static final String[] COLORS = new String[]{"red", "green", "yellow", "blue"};

    private static int playerIdCounter = 1;

    public User() {
        this.playerId = playerIdCounter++;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public int getGameId() {
        return gameId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
