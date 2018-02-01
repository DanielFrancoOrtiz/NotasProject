package com.example.notasproject.Pojos;

import java.io.Serializable;

public class Multimedia implements Serializable {

    private int _id;
    private String nombre;
    private String direccion;
    private int tipo;
    private String descripcion;

    public Multimedia() {
    }

    public Multimedia(String nombre, String direccion, int tipo, String descripcion) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo=tipo;
        this.descripcion=descripcion;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
