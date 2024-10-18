package com.es.stockcontrol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @Column(name ="nombre_usuario")
    private String nombre;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    public User() {
    }

    public User(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
