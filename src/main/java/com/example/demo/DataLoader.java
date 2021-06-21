package com.example.demo;


import com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.model.Board;
import com.example.demo.model.Player;
import com.example.demo.service.interfaces.IGameService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * The run method is executed upon startup, this can be used to do some data seeding.
 */
@Component
public class DataLoader implements ApplicationRunner {
    private final IGameService gameService;

    public DataLoader(IGameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void run(ApplicationArguments args) throws ServiceException, DaoException {

        /*Board board = new Board(8, 8, "Board1");
        gameService.saveBoard(board);

        Player player1 = new Player(board, "blue", "Player1Name");
        gameService.addPlayer(board.getGameId(), player1);
        gameService.setCurrentPlayer(board.getGameId(), player1.getPlayerId());
        gameService.moveCurrentPlayer(board.getGameId(), 1, 1);

        Player player2 = new Player(board, "green", "Player2Name");
        gameService.addPlayer(board.getGameId(), player2);
        gameService.movePlayer(board, 4, 4, player2.getPlayerId());*/
        /*gameService.switchCurrentPlayer(board);*/
    }
}
