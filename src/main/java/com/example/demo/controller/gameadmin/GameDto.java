package com.example.demo.controller.gameadmin;

import com.example.demo.controller.GameController.UserDto;

import java.util.ArrayList;

public class GameDto {

    private Integer gameId;
    private String name;
    private UserDto[] users;

    public Integer getGameId(){
        return this.gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
