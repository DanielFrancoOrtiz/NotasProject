package com.example.notasproject.Daos;

import java.util.List;

/**
 * Created by Franco on 01/02/2018.
 */

public interface IDao <T> {

    public Long insertar(T obj);

    public T ConsultarUno(int _id);

    public List<T> consultarTodos();

    public int eliminar(int _id);

    public int actualizar(T obj);
}
