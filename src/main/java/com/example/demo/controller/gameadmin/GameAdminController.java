package com.example.demo.controller.gameadmin;

import com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.MappingException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.model.admin.Game;
import com.example.demo.service.implementations.GameAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class GameAdminController {
    private final GameAdminService gameAdminService;

    public GameAdminController(GameAdminService gameAdminService){
        this.gameAdminService = gameAdminService;
    }


    @GetMapping("/game")
    public ResponseEntity<List<Game>> getGames() throws ServiceException, DaoException, MappingException{
        List<Game> games = gameAdminService.getGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }
}
