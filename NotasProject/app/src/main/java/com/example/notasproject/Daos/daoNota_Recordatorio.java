package com.example.notasproject.Daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notasproject.Pojos.Nota_Recordatorio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franco on 01/02/2018.
 */

public class daoNota_Recordatorio implements IDao<Nota_Recordatorio> {
    private Context contexo;
    private SQLiteDatabase database;

    public daoNota_Recordatorio(Context context){
        this.contexo = context;
        database = new MiSQLiteOpenHelper(contexo).getWritableDatabase();
    }

    @Override
    public Long insertar(Nota_Recordatorio obj)
    {
        ContentValues cv = new ContentValues();
        cv.put(MiSQLiteOpenHelper.COLUMNS_NOTAS_RECORDATORIOS[1],obj.getId_Nota());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NOTAS_RECORDATORIOS[2],obj.getId_Recordatorio());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NOTAS_RECORDATORIOS[3],obj.getNombre());
        return database.insert(MiSQLiteOpenHelper.TABLE_NOTAS_RECORDATORIOS_NAME,null,cv);
    }

    @Override
    public Nota_Recordatorio ConsultarUno(int _id) {
        Cursor c = database.query(MiSQLiteOpenHelper.TABLE_NOTAS_RECORDATORIOS_NAME,
                MiSQLiteOpenHelper.COLUMNS_NOTAS_RECORDATORIOS,"_id = ?",
                new String[]{String.valueOf(_id)},
                null,
                null,
                null);
        if (c.moveToFirst()){
            Nota_Recordatorio n = new Nota_Recordatorio();
            n.set_id(c.getInt(0));
            n.setId_Nota(c.getInt(1));
            n.setId_Recordatorio(c.getInt(2));
            n.setNombre(c.getString(3));
            return n;
        }
        return null;
    }

    @Override
    public List<Nota_Recordatorio> consultarTodos() {
        List<Nota_Recordatorio> lista = null;
        Cursor c = database.query(MiSQLiteOpenHelper.TABLE_NOTAS_RECORDATORIOS_NAME,
                MiSQLiteOpenHelper.COLUMNS_NOTAS_RECORDATORIOS,
                null,null,null,null,null);
        if (c.moveToFirst()){
            lista = new ArrayList<>();
            do{
                Nota_Recordatorio n = new Nota_Recordatorio();
                n.set_id(c.getInt(0));
                n.setId_Nota(c.getInt(1));
                n.setId_Recordatorio(c.getInt(2));
                n.setNombre(c.getString(3));
                lista.add(n);
            }while (c.moveToNext());
        }
        return lista;
    }

    @Override
    public int eliminar(int _id) {
        return 0;
    }

    @Override
    public int actualizar(Nota_Recordatorio obj) {
        return 0;
    }
}
