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
        this.userService = new UserService();
    }


    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {
        try{
            User u = this.userService.userLogin(userInput,passInput);
            return u != null ?
                    new RespuestaHTTP<User>(200, "OK", u) :
                    new RespuestaHTTP<User>(404, "BAD REQUEST", null);

        }catch (Exception e){
            return new RespuestaHTTP<User>(500, "SERVER ERROR", null);
        }

    }
}
