package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProveedorControllerAPI;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;
import com.es.stockcontrol.service.ProveedorService;

import java.util.List;

public class ProveedorController implements ProveedorControllerAPI {
    ProveedorService proveedorService;

    public ProveedorController() {
        this.proveedorService = new ProveedorService();
    }

    @Override
    public RespuestaHTTP<List<Proveedor>> getProveedoresProducto(String idProducto) {
        try{
            List<Proveedor> list = this.proveedorService.getProveedoresProducto(idProducto);
            return list != null ?
                    new RespuestaHTTP<List<Proveedor>>(200, "OK", list) :
                    new RespuestaHTTP<List<Proveedor>>(404, "BAD REQUEST", null);

        }catch (Exception e){
            return new RespuestaHTTP<List<Proveedor>>(500, "SERVER ERROR", null);
        }
    }

    @Override
    public RespuestaHTTP<List<Proveedor>> getTodosProveedores() {
        try{
            List<Proveedor> list = this.proveedorService.getTodosProveedores();
            return list != null ?
                    new RespuestaHTTP<List<Proveedor>>(200, "OK", list) :
                    new RespuestaHTTP<List<Proveedor>>(404, "BAD REQUEST", null);

        }catch (Exception e){
            return new RespuestaHTTP<List<Proveedor>>(500, "SERVER ERROR", null);
        }
    }

    public RespuestaHTTP<Proveedor> getByNombre(String nombre) {
        try{
            Proveedor prov = this.proveedorService.getByNombre(nombre);
            return prov != null ?
                    new RespuestaHTTP<Proveedor>(200, "OK", prov) :
                    new RespuestaHTTP<Proveedor>(404, "BAD REQUEST", prov);

        }catch (Exception e){
            return new RespuestaHTTP<Proveedor>(500, "SERVER ERROR", null);
        }
    }

}
