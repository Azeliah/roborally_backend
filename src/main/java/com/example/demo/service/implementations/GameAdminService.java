package com.example.demo.service.implementations;

import com.example.demo.dal.interfaces.IBoardDao;
import com.example.demo.dal.interfaces.IGameDao;

import com.example.demo.service.interfaces.IGameAdminService;
import com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.ServiceException;
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

    public GameAdminService(IBoardDao boardDao, IGameDao gameDao) {

        this.boardDao = boardDao;
        this.gameDao = gameDao;
    }

    @Override
    public List<Game> getGames() throws ServiceException, DaoException {
        return new ArrayList<>(gameDao.getGames());
    }

    @Override
    public int createGame(Game game) throws ServiceException, DaoException {
        int gameId = gameDao.createGame(game);
        if (gameId < 0) {
            throw new ServiceException("BoardDao generated invalid boardId " + gameId, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return gameId;
    }

    @Override
    public User createUser(int gameId) {
        return gameDao.createUser(gameId);
    }

    @Override
    public void updateUser(User user) {
        gameDao.updateUser(user);
    }

    @Override
    public void editGame(Game game, int gameId) throws ServiceException, DaoException {
        gameDao.updateGame(game, gameId);
    }

    @Override
    public void startGame(int gameId) throws DaoException {
        for (Game g : gameDao.getGames()) {
            if (g.getGameId() == gameId) {
                g.started = true;
                return;
            }
        }
    }
}
