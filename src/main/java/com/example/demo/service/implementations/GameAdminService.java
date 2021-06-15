package com.example.demo.service.implementations;

import com.example.demo.dal.interfaces.IBoardDao;
import com.example.demo.dal.interfaces.IGameDao;

import com.example.demo.service.interfaces.IGameAdminService;
import com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.model.Board;
import com.example.demo.model.Player;
import com.example.demo.model.admin.Game;
import com.example.demo.model.admin.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameAdminService implements IGameAdminService {

    private final IBoardDao boardDao;
    private final IGameDao gameDao;

    public GameAdminService(IBoardDao boardDao, IGameDao gameDao){

        this.boardDao = boardDao;
        this.gameDao = gameDao;
    }

    @Override
    public List<Game> getGames() throws ServiceException, DaoException{
        // TODO Change (only for demo)... This needs to be ONLY games send back not taking the boards and making them into games
        List<Game> result = new ArrayList<>(gameDao.getGames());
        /*for (Board board: boardDao.getBoards()){
            Game game = new Game();
            game.name = board.boardName;
            game.id = board.getGameId();
            result.add(game);

            game.started = board.getPlayersNumber() > 1;
            for (int i=0; i < board.getPlayersNumber(); i++){
                Player player = board.getPlayer(i);
                User user = new User();
                user.playerId = player.getPlayerId();
                user.playerName = player.getName();
                game.users.add(user);
            }
        }*/
        return result;
    }

    @Override
    public int createGame(Game game) throws ServiceException, DaoException {
        int gameId = gameDao.createGame(game);
        if (gameId < 0) {
            throw new ServiceException("BoardDao generated invalid boardId " + gameId, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return gameId;
        //return "";
    }


}
