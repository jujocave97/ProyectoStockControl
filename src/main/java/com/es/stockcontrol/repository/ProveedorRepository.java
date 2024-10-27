package com.es.stockcontrol.repository;
import java.util.List;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ProveedorRepository {
    private EntityManager entityManager;

    public ProveedorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Proveedor> getProveedoresProducto(String idProducto){
        String jpql = "SELECT p FROM Proveedor p JOIN p.productos pr WHERE pr.id = :productoId";
        TypedQuery<Proveedor> query = this.entityManager.createQuery(jpql, Proveedor.class);
        query.setParameter("productoId",idProducto);
        return query.getResultList();
    }

    public List<Proveedor> getTodosProveedores(){
        String jpql = "FROM Proveedor";
        TypedQuery<Proveedor> query = this.entityManager.createQuery(jpql, Proveedor.class);
        return query.getResultList();
    }

    public Proveedor getByNombre(String nombreProveedor){
        String jpql = "FROM Proveedor WHERE nombre = :nombreProveedor";
        TypedQuery<Proveedor> query = this.entityManager.createQuery(jpql,Proveedor.class);
        query.setParameter("nombreProveedor",nombreProveedor);
        return query.getSingleResult();
    }

}
