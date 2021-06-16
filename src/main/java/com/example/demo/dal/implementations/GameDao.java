package com.example.demo.dal.implementations;

import com.example.demo.dal.interfaces.IGameDao;
import com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.model.Board;
import com.example.demo.model.admin.Game;
import com.example.demo.model.admin.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class GameDao implements IGameDao {

    static final HashMap<Integer, Game> games = new HashMap<>();
    static private int gameIdCounter = 0;

    @Override
    public Game getGame(int gameId) {
        return games.get(gameId);
    }

    @Override
    public void updateUser(User user) {
        Game game = games.get(user.getGameId());
        if (game == null)
            return;

        User foundUser = null;
        int index = 0;
        for (User i : game.users) {
            if (i.getPlayerId() == user.getPlayerId()) {
                foundUser = i;
                break;
            }
            index++;
        }

        if (foundUser == null)
            return;

        game.users.get(index).setPlayerName(user.getPlayerName());
        game.users.get(index).setPlayerColor(user.getPlayerColor());
    }

    @Override
    public int createGame(Game game) {
        gameIdCounter++;
        game.setGameId(gameIdCounter);
        games.put(game.getGameId(), game);
        return gameIdCounter;
    }

    @Override
    public List<Game> getGames() {
        return new ArrayList<>(games.values());
    }

    @Override
    public void addGame(Game game) {
        games.put(game.getGameId(), game);
    }

    @Override
    public void updateGame (Game game, int gameId) {
            games.replace(gameId, game);
    }
}

