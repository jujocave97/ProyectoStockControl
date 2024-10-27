package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProductoControllerAPI;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProductoService;

import java.util.List;

public class ProductoController implements ProductoControllerAPI {
    private final ProductoService productoService;

    public ProductoController() {
        this.productoService = new ProductoService();
    }

    @Override
    public RespuestaHTTP<Producto> altaProducto(String categoria, String nombreProducto, String precioSinIva, String descripcionProducto, String nombreProveedor) {
        try{
            Producto producto = productoService.insertProducto(categoria,nombreProducto,precioSinIva,descripcionProducto,nombreProveedor);
            return producto != null?
                    new RespuestaHTTP<>(200,"OK",producto) :
                    new RespuestaHTTP<>(404, "NOT FOUND", producto);
        }catch (Exception e){
            return  new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }
    }

    @Override
    public RespuestaHTTP<Producto> bajaProducto(String id) {
        try{
            Producto p = productoService.getProducto(id);
            return productoService.deleteProducto(id) ?
                    new RespuestaHTTP<>(200,"OK",p) :
                    new RespuestaHTTP<>(404, "NOT FOUND", p);
        }catch (Exception e){
            return  new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }

    }

    @Override
    public RespuestaHTTP<Producto> modificarNombreProducto(String id, String nuevoNombre) {
        try{
            Producto p = productoService.modificarNombreProducto(id,nuevoNombre);
            return p != null ? new RespuestaHTTP<>(200, "OK",p):
                    new RespuestaHTTP<>(404,"NOT FOUND",p);
        }catch (Exception e){
            return new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }

    }

    @Override
    public RespuestaHTTP<Producto> modificarStockProducto(String id, String nuevoStock) {

        try{
            Producto p = productoService.modificarStockProducto(id,nuevoStock);
            return p != null ? new RespuestaHTTP<>(200, "OK",p):
                    new RespuestaHTTP<>(404,"NOT FOUND",p);
        }catch (Exception e){
            return new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }
    }

    @Override
    public RespuestaHTTP<Producto> getProducto(String id) {

        try{
            Producto p = productoService.getProducto(id);
            return p != null ? new RespuestaHTTP<>(200, "OK",p):
                    new RespuestaHTTP<>(404,"NOT FOUND",p);
        }catch (Exception e){
            return new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosConStock() {

        try{
            List<Producto> listaP = productoService.getProductosConStock();
            return listaP != null ? new RespuestaHTTP<>(200, "OK",listaP):
                    new RespuestaHTTP<>(404,"NOT FOUND",listaP);
        }catch (Exception e){
            return new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosSinStock() {
        try{
            List<Producto> listaP = productoService.getProductosSinStock();
            return listaP != null ? new RespuestaHTTP<>(200, "OK",listaP):
                    new RespuestaHTTP<>(404,"NOT FOUND",listaP);
        }catch (Exception e){
            return new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }
    }
}
