package com.example.notasproject.Pojos;

/**
 * Created by Franco on 26/01/2018.
 */

public class Nota_Recordatorio {
    private int _id;
    private int id_Nota;
    private int id_Recordatorio;
    private String nombre;

    public Nota_Recordatorio() {
    }

    public Nota_Recordatorio(int id_Nota, int id_Recordatorio, String nombre) {
        this.id_Nota = id_Nota;
        this.id_Recordatorio = id_Recordatorio;
        this.nombre = nombre;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getId_Nota() {
        return id_Nota;
    }

    public void setId_Nota(int id_Nota) {
        this.id_Nota = id_Nota;
    }

    public int getId_Recordatorio() {
        return id_Recordatorio;
    }

    public void setId_Recordatorio(int id_Recordatorio) {
        this.id_Recordatorio = id_Recordatorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
