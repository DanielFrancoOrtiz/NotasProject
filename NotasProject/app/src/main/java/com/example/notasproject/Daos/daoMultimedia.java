package com.example.notasproject.Daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notasproject.Pojos.Multimedia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franco on 01/02/2018.
 */

public class daoMultimedia implements IDao <Multimedia>{

    private Context contexto;
    private SQLiteDatabase database;

    public daoMultimedia(Context contexto){
        this.contexto = contexto;
        this.database = new MiSQLiteOpenHelper(contexto).getWritableDatabase();
    }

    @Override
    public Long insertar(Multimedia obj) {
        ContentValues cv = new ContentValues();
        cv.put(MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA[1],obj.getNombre());
        cv.put(MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA[2],obj.getDireccion());
        cv.put(MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA[3],obj.getTipo());
        cv.put(MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA[4], obj.getDescripcion());
        return database.insert(MiSQLiteOpenHelper.TABLE_MULTIMEDIA_NAME,null,cv);
    }

    @Override
    public Multimedia ConsultarUno(int _id) {
        Cursor cur = database.query(MiSQLiteOpenHelper.TABLE_MULTIMEDIA_NAME,
                                    MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA,
                                    "_id = ?",new String[]{String.valueOf(_id)},
                                    null,
                                    null,
                                    null);
        if(cur.moveToFirst()){
            Multimedia m = new Multimedia();
            m.set_id(cur.getInt(0));
            m.setNombre(cur.getString(1));
            m.setDireccion(cur.getString(2));
            m.setTipo(cur.getInt(3));
            m.setDescripcion(cur.getString(4));
            return m;
        }
        return null;
    }

    @Override
    public List<Multimedia> consultarTodos() {
        List<Multimedia> lista = null;
        Cursor cur = database.query(MiSQLiteOpenHelper.TABLE_MULTIMEDIA_NAME,
                                    MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null);
        if(cur.moveToFirst()){
            lista = new ArrayList<>();
            do {
                Multimedia m = new Multimedia();
                m.set_id(cur.getInt(0));
                m.setNombre(cur.getString(1));
                m.setDireccion(cur.getString(2));
                m.setTipo(cur.getInt(3));
                m.setDescripcion(cur.getString(4));
                lista.add(m);

            }while (cur.moveToNext());
        }
        return null;
    }

    @Override
    public int eliminar(int _id) {
        return database.delete(MiSQLiteOpenHelper.TABLE_NOTAS_NAME,"_id = ?",new String[]{String.valueOf(_id)});

    }

    @Override
    public int actualizar(Multimedia obj) {
        ContentValues cv = new ContentValues();
        cv.put(MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA[0],obj.get_id());
        cv.put(MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA[1],obj.getNombre());
        cv.put(MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA[2],obj.getDireccion());
        cv.put(MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA[3],obj.getTipo());
        cv.put(MiSQLiteOpenHelper.COLUMNS_MULTIMEDIA[4], obj.getDescripcion());
        return database.update(MiSQLiteOpenHelper.TABLE_MULTIMEDIA_NAME,cv,
                "_id = ?",new String[]{String.valueOf(obj.get_id())});


    }
}
