package com.example.notasproject.Daos;

import com.example.notasproject.Pojos.Recordatorio;

import java.util.List;

/**
 * Created by Franco on 01/02/2018.
 */

public class daoRecordatorio implements IDao<Recordatorio> {
    @Override
    public Long insertar(Recordatorio obj) {
        return null;
    }

    @Override
    public Recordatorio ConsultarUno(int _id) {
        return null;
    }

    @Override
    public List<Recordatorio> consultarTodos() {
        return null;
    }

    @Override
    public int eliminar(int _id) {
        return 0;
    }

    @Override
    public int actualizar(Recordatorio obj) {
        return 0;
    }
}
