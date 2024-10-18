package com.es.stockcontrol.controller.api;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;

import java.util.List;

public interface ProveedorControllerAPI {

    RespuestaHTTP<List<Proveedor>> getProveedoresProducto(String idProducto);
    RespuestaHTTP<List<Proveedor>> getTodosProveedores();
}
