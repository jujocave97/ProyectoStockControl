package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.repository.ProductoRepository;
import com.es.stockcontrol.repository.ProveedorRepository;
import com.es.stockcontrol.utils.Factory;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.Date;

import java.util.List;

public class ProductoService {
    ProductoRepository productoRepository;
    EntityManager em;
    ProveedorRepository proveedorRepository;

    public ProductoService(){
        EntityManager em = Factory.crearEMFactory().createEntityManager();
        productoRepository = new ProductoRepository(em);
        proveedorRepository = new ProveedorRepository(em);
    }

    public Producto insertProducto(String categoria, String nombreProducto, String precioSinIva, String descripcionProducto, String nombreProveedor){
        String idProducto =  categoria.substring(0,3) + nombreProducto.substring(0,3) + nombreProveedor.substring(0,3);
        Date fechaAlta =  new Date();
        float precioConIva = (float) ((Float.parseFloat(precioSinIva) * 0.21) + Float.parseFloat(precioSinIva));
        int stock = 0;
        Proveedor proveedor = proveedorRepository.getByNombre(nombreProveedor);
        Producto producto = new Producto(idProducto,nombreProducto,categoria, descripcionProducto, Float.parseFloat(precioSinIva), precioConIva, fechaAlta, stock, proveedor);
        return  this.productoRepository.insertProducto(producto);
    }

    public boolean deleteProducto(String id){
        if(id != null){
            return this.productoRepository.eliminarProducto(id);
        }else{
            return false;
        }
    }

    public Producto modificarNombreProducto(String id, String nuevoNombre){
        if(id != null || nuevoNombre != null){
            return this.productoRepository.modificarNombreProducto(id,nuevoNombre);
        }else{
            return null;
        }
    }

    public Producto modificarStockProducto(String id, String nuevoStock){
        if(id != null || nuevoStock != null){
            return this.productoRepository.modificarStockProducto(id,nuevoStock);
        }else{
            return null;
        }
    }

    public Producto getProducto(String id){
        if(id != null){
            return this.productoRepository.getProducto(id);
        }else{
            return null;
        }
    }

    public List<Producto> getProductosConStock(){
        return this.productoRepository.getProductosConStock();
    }

    public List<Producto> getProductosSinStock(){
        return this.productoRepository.getProductosSinStock();
    }
}
