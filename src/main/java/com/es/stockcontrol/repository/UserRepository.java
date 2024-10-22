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
        return em.find(User.class, nombre);
    }

    public List<User> getAll(){
        TypedQuery<User> query=  em.createQuery("SELECT * FROM usuarios",User.class);
        return query.getResultList();
    }
}
