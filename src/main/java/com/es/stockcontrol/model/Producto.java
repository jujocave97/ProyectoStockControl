package com.es.stockcontrol.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    private String id;

    @Column(name = "categoria",nullable = false, length = 10)
    private String categoria;

    @Column(name = "nombre",nullable = false, length = 50 )
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precioSinIva", nullable = false)
    private float precioSinIva;

    @Column(name = "precioConIva",nullable = false)
    private float precioConIva;

    @Column(name="fechaAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    @Column(name = "stock")
    private int stock;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    public Producto(){

    }

    public Producto(String id, String nombre, String categoria, String descripcion, float precioSinIva, float precioConIva, Date fechaAlta, int stock, Proveedor proveedor){
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioConIva = precioConIva;
        this.precioSinIva = precioSinIva;
        this.fechaAlta = fechaAlta;
        this.stock = stock;
        this.proveedor = proveedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(float precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public float getPrecioConIva() {
        return precioConIva;
    }

    public void setPrecioConIva(float precioConIva) {
        this.precioConIva = precioConIva;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
