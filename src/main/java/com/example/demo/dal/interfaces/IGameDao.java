package com.example.demo.dal.interfaces;

import com.example.demo.exceptions.DaoException;
import com.example.demo.model.admin.Game;
import com.example.demo.model.admin.User;

import java.util.List;

public interface IGameDao {
    Game getGame(int gameId) throws DaoException;

    int createGame(Game game) throws DaoException;

    List<Game> getGames() throws DaoException;

    void updateUser(User user);

    void addGame(Game game);
}
