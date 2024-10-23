package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Producto;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ProductoRepository{
    private EntityManager entityManager;

    public ProductoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Producto getProducto(String id) {
        Producto productoBusqueda = this.entityManager.find(Producto.class,id);
        return productoBusqueda;
    }

    public Producto insertProducto(Producto newProducto) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(newProducto);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return getProducto(newProducto.getId());
    }

    public Producto modificarNombreProducto(String id, String nuevoNombre){
        this.entityManager.getTransaction().begin();
        Producto productoBusqueda = this.entityManager.find(Producto.class,id);
        productoBusqueda.setNombre(nuevoNombre);
        this.entityManager.getTransaction().commit();
        return getProducto(id);
    }

    public Producto modificarStockProducto(String id, String nuevoStock){
        this.entityManager.getTransaction().begin();
        Producto productoBusqueda = this.entityManager.find(Producto.class,id);
        productoBusqueda.setStock(parseInt(nuevoStock));
        this.entityManager.getTransaction().commit();
        return getProducto(id);
    }

    public List<Producto> getProductosConStock() {
        String jpql = "SELECT p FROM Producto p WHERE p.stock =! 0";
        TypedQuery<Producto> query = this.entityManager.createQuery(jpql, Producto.class);
        return query.getResultList();
    }
    public List<Producto> getProductosSinStock() {
        String jpql = "SELECT p FROM Producto p WHERE p.stock = 0";
        TypedQuery<Producto> query = this.entityManager.createQuery(jpql, Producto.class);
        return query.getResultList();
    }

    public boolean eliminarProducto(String id){
        if(getProducto(id) != null){
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(getProducto(id));
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
            return true;
        }else{
            return false;
        }

    }

}
