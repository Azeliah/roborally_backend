package com.example.demo.model.admin;

import java.util.ArrayList;

public class Game {
    public String name;
    public Integer id;
    public boolean started;
    public int width = 6;
    public int height = 6;

    public ArrayList<User> users = new ArrayList<>();

    public Integer getGameId() {
        return id;
    }

    public void setGameId(int gameId) {
        if (this.id == null) {
            this.id = gameId;
        } else {
            if (!this.id.equals(gameId)) {
                throw new IllegalStateException("A game with a set id may not be assigned a new id!");
            }
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setName(String name) {
        this.name = name;
    }
}
