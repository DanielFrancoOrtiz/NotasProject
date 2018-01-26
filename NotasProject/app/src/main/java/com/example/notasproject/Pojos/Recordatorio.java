package com.example.notasproject.Pojos;


import java.sql.Time;
import java.util.Date;

public class Recordatorio {

    private int _id;
    private String nombre;
    private Date fecha;
    private Time hora;

    public Recordatorio() {
    }

    public Recordatorio(int _id, String nombre, Date fecha, Time hora) {
        this._id = _id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}
