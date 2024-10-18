package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;

public class UserController implements UserControllerAPI {


    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {
        return null;
    }
}
