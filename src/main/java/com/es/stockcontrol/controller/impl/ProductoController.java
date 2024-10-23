package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProductoControllerAPI;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProductoService;

import java.util.List;

public class ProductoController implements ProductoControllerAPI {
    private final ProductoService ps;

    public ProductoController() {
        this.ps = new ProductoService();
    }

    @Override
    public RespuestaHTTP<Producto> altaProducto(String idProducto, String nombreProducto, String precioSinIva, String descripcionProducto, String nombreProveedor, String direccionProveedor) {

        return null;
    }

    @Override
    public RespuestaHTTP<Producto> bajaProducto(String id) {
        try{
            Producto p = ps.getProducto(id);
            return ps.deleteProducto(id) ?
                    new RespuestaHTTP<>(200,"OK",p) :
                    new RespuestaHTTP<>(404, "NOT FOUND", p);
        }catch (Exception e){
            return  new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }

    }

    @Override
    public RespuestaHTTP<Producto> modificarNombreProducto(String id, String nuevoNombre) {
        try{
            Producto p = ps.modificarNombreProducto(id,nuevoNombre);
            return p != null ? new RespuestaHTTP<>(200, "OK",p):
                    new RespuestaHTTP<>(404,"NOT FOUND",p);
        }catch (Exception e){
            return new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }

    }

    @Override
    public RespuestaHTTP<Producto> modificarStockProducto(String id, String nuevoStock) {

        try{
            Producto p = ps.modificarStockProducto(id,nuevoStock);
            return p != null ? new RespuestaHTTP<>(200, "OK",p):
                    new RespuestaHTTP<>(404,"NOT FOUND",p);
        }catch (Exception e){
            return new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }
    }

    @Override
    public RespuestaHTTP<Producto> getProducto(String id) {

        try{
            Producto p = ps.getProducto(id);
            return p != null ? new RespuestaHTTP<>(200, "OK",p):
                    new RespuestaHTTP<>(404,"NOT FOUND",p);
        }catch (Exception e){
            return new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosConStock() {

        try{
            List<Producto> listaP = ps.getProductosConStock();
            return listaP != null ? new RespuestaHTTP<>(200, "OK",listaP):
                    new RespuestaHTTP<>(404,"NOT FOUND",listaP);
        }catch (Exception e){
            return new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosSinStock() {
        try{
            List<Producto> listaP = ps.getProductosSinStock();
            return listaP != null ? new RespuestaHTTP<>(200, "OK",listaP):
                    new RespuestaHTTP<>(404,"NOT FOUND",listaP);
        }catch (Exception e){
            return new RespuestaHTTP<>(500,"SERVER ERROR", null);
        }
    }
}
