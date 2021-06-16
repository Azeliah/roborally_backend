package com.example.demo.controller.gameadmin;

import com.example.demo.controller.GameController.BoardDto;
import com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.MappingException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.model.Board;
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

    public GameAdminController(GameAdminService gameAdminService, DtoMapper dtoMapper) {

        this.gameAdminService = gameAdminService;
        this.dtoMapper = dtoMapper;
    }


    @GetMapping("/game")
    public ResponseEntity<List<Game>> getGames() throws ServiceException, DaoException{
        List<Game> games = gameAdminService.getGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @PostMapping("/game")
    public ResponseEntity<String> createGame(@RequestBody GameDto gameDto) throws ServiceException, DaoException, MappingException {
        Game game = dtoMapper.convertToEntity(gameDto, false);
        gameAdminService.createGame(game);
        String gameName = gameDto.getName();
        return new ResponseEntity<>(gameName, HttpStatus.CREATED);
    }

    @PostMapping("/game/{gameId}/user")
    public ResponseEntity<User> createUser(@PathVariable int gameId) throws ServiceException, DaoException {
        User user = new User();
        user.setPlayerId(1234);
        user.setPlayerName("Player");
        user.setPlayerColor("red");

        Game game = gameAdminService.getGames().get(gameId - 1);

        game.getUsers().add(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("game/{gameId}/user")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto, @PathVariable int gameId) throws ServiceException, DaoException {
        User user = dtoMapper.convertToEntity(userDto);
        gameAdminService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/game/{gameId}")
    public ResponseEntity<Void> editBoard(@RequestBody GameDto gameDto, @PathVariable("gameId") int gameId ) throws ServiceException, DaoException, MappingException {
        Game game = dtoMapper.convertToEntity(gameDto, true);
        gameAdminService.editGame(game, gameId);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
