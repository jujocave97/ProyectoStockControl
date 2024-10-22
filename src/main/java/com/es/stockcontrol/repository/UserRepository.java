package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserRepository {
    private EntityManager em;

    public UserRepository(EntityManager em){
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


    public User get(String nombre){
        try {
            em.getTransaction().begin();
            User u = em.find(User.class, nombre);
            em.close();
            return u;
        }catch (Exception e){
            return null;
        }
    }

    public List<User> getAll(){
        try{
            em.getTransaction().begin();
            TypedQuery<User> query=  em.createQuery("SELECT * FROM usuarios",User.class);
            List<User> listUsers = query.getResultList();
            em.close();
            return listUsers;
        }catch (Exception e){
            return null;
        }
    }
}
