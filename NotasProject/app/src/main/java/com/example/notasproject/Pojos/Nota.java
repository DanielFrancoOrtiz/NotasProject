package com.example.notasproject.Pojos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Nota implements Serializable {

    private int _id;
    private String titulo;
    private String descripcion;

    public Nota() {
    }
    public Nota(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int get_Id() {
        return _id;
    }

    public void set_Id(int id) {
        this._id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
