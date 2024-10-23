package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.repository.ProveedorRepository;
import com.es.stockcontrol.utils.Factory;

import java.util.List;

public class ProveedorService {
    private ProveedorRepository pr;

    public ProveedorService() {
        this.pr = new ProveedorRepository(Factory.crearEMFactory().createEntityManager());
    }

    public List<Proveedor> getProveedoresProducto(String producto){
        return pr.getProveedoresProducto(producto);
    }

    public List<Proveedor> getTodosProveedores(){
        return pr.getTodosProveedores();
    }
}
