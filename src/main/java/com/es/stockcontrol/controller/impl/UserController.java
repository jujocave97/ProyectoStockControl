package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;
import com.es.stockcontrol.service.UserService;
import com.es.stockcontrol.utils.Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserController implements UserControllerAPI {
    private UserService userService;
// TODO : Los services, meter el entity manager en cada service (clase static factory para el manager), y los controllers
    public UserController(){
        this.userService = createUserService();
    }

    public UserService createUserService (){
        EntityManager em = Factory.crearEMFactory().createEntityManager();
        return new UserService(em);
    }

    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {

        return null;
    }
}
