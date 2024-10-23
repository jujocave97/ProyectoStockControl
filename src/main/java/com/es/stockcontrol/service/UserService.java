package com.es.stockcontrol.service;

import com.es.stockcontrol.model.User;
import com.es.stockcontrol.repository.UserRepository;
import com.es.stockcontrol.utils.Encrypter;
import com.es.stockcontrol.utils.Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserService {
    private UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository(createEntityManager());
    }

    public EntityManager createEntityManager(){
        return Factory.crearEMFactory().createEntityManager();
    }
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userLogin(String nombre, String pass){
        try{
            User u = userRepository.get(nombre);
            String passEncrypted = Encrypter.encryptPassword(pass);

            if (u.getNombre().equals(nombre) && u.getPassword().equals(passEncrypted))
                return u;
            else
                return null;
        }catch (Exception e){
            return null;
        }
    }
}
