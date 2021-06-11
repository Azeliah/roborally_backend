package com.example.demo.controller.gameadmin;

public class GameDto {

    private Integer gameId;
    private String name;

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
