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
    public User createUser(int gameId) {
        if (gameId < 0)
            return null;

        Game game = games.get(gameId);
        if (game == null)
            return null;

        int userNum = game.getUsers().size() + 1;

        if (userNum > User.MAX_NO_USERS)
            return null;

        User user = new User();
        user.setPlayerName("Player" + userNum);
        user.setPlayerColor(User.COLORS[userNum - 1]);
        user.setGameId(gameId);

        game.getUsers().add(user);

        return user;
    }

    @Override
    public void updateUser(User user) {
        Game game = games.get(user.getGameId());
        if (game == null)
            return;

        User foundUser = null;
        for (User i : game.users) {
            if (i.getPlayerId() == user.getPlayerId()) {
                foundUser = i;
                break;
            }
        }

        if (foundUser == null)
            return;

        foundUser.setPlayerName(user.getPlayerName());
        foundUser.setPlayerColor(user.getPlayerColor());
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
        Game gameEdit = games.get(game.getGameId());
        gameEdit.name = game.name;
        gameEdit.width = game.width;
        gameEdit.height = game.height;
    }
}

