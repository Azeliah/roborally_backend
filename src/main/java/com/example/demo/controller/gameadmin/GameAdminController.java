package com.example.demo.controller.gameadmin;

import com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.MappingException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.model.admin.Game;
import com.example.demo.model.admin.User;
import com.example.demo.service.implementations.GameAdminService;
import com.example.demo.util.mapping.DtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class GameAdminController {
    private final GameAdminService gameAdminService;
    private final DtoMapper dtoMapper;

    public GameAdminController(GameAdminService gameAdminService, DtoMapper dtoMapper){

        this.gameAdminService = gameAdminService;
        this.dtoMapper = dtoMapper;
    }


    @GetMapping("/game")
    public ResponseEntity<List<Game>> getGames() throws ServiceException, DaoException, MappingException{
        List<Game> games = gameAdminService.getGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @PostMapping("/game")
    public ResponseEntity<String> createGame(@RequestBody GameDto gameDto) throws ServiceException, DaoException, MappingException {
        Game game = dtoMapper.convertToEntity(gameDto);
        gameAdminService.createGame(game);
        String gameName = gameDto.getName();
        return new ResponseEntity<>(gameName, HttpStatus.CREATED);
    }

    @PostMapping("/game/{gameId}/user")
    public ResponseEntity<User> createUser(@PathVariable int gameId) throws ServiceException, DaoException {
        User user = new User();
        user.playerId = 1234;
        user.playerName = "Player";
        user.color = "red";

        Game game = gameAdminService.getGames().get(gameId - 1);

        game.getUsers().add(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
