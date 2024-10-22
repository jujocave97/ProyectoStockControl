package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;
import com.es.stockcontrol.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserController implements UserControllerAPI {
    private UserService userService;

    public UserService(){

    }

    public UserService createUserService (){

    }

    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {

        return null;
    }
}
