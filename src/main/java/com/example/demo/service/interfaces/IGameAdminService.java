package com.example.demo.service.interfaces;


import com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.model.admin.Game;
import com.example.demo.model.admin.User;

import java.util.List;

public interface IGameAdminService{

    List<Game> getGames() throws ServiceException, DaoException;

    int createGame(Game game) throws ServiceException, DaoException;

    User createUser(int gameId);

    void updateUser(User user);

    void editGame(Game game, int gameId) throws ServiceException, DaoException;
}