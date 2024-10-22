package com.es.stockcontrol.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory {
    public static EntityManagerFactory crearEMFactory () {
        return Persistence.createEntityManagerFactory("CRUDProductosHibernate");
    }
}
