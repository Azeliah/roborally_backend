package com.example.demo.controller.gameadmin;

import java.util.ArrayList;

public class GameDto {

    private Integer gameId;
    private String name;
    private UserDto[] users;
    private int width;
    private int height;

    public Integer getGameId(){
        return this.gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public UserDto[] getUsers() {
        return users;
    }
}
