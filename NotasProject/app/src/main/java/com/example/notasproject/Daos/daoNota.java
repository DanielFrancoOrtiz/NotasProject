package com.example.notasproject.Daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notasproject.Pojos.Nota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franco on 01/02/2018.
 */

public class daoNota implements IDao<Nota> {
    private Context contexto;
    private SQLiteDatabase database;

    public daoNota(Context contexto){
        this.contexto = contexto;
        this.database = new MiSQLiteOpenHelper(contexto).getWritableDatabase();
    }

    @Override
    public Long insertar(Nota obj) {
        ContentValues cv = new ContentValues();
        cv.put(MiSQLiteOpenHelper.COLUMNS_NOTAS[1],obj.getTitulo());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NOTAS[2],obj.getDescripcion());
        return database.insert(MiSQLiteOpenHelper.TABLE_NOTAS_NAME,null,cv);
    }

    @Override
    public Nota ConsultarUno(int _id) {
        Cursor c = database.query(MiSQLiteOpenHelper.TABLE_NOTAS_NAME,
                MiSQLiteOpenHelper.COLUMNS_NOTAS,"_id = ?",
                new String[]{String.valueOf(_id)},
                null,null,null);
        if (c.moveToFirst()){
            Nota n = new Nota();
            n.set_Id(c.getInt(0));
            n.setTitulo(c.getString(1));
            n.setDescripcion(c.getString(2));
        }
        return null;
    }

    @Override
    public List<Nota> consultarTodos() {
        List<Nota> lista = null;
        Cursor c = database .query(MiSQLiteOpenHelper.TABLE_NOTAS_NAME,
                                    MiSQLiteOpenHelper.COLUMNS_NOTAS,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null);
        if (c.moveToFirst()){
            lista = new ArrayList<>();
            do{
                Nota n = new Nota();
                n.set_Id(c.getInt(0));
                n.setTitulo(c.getString(1));
                n.setDescripcion(c.getString(2));
            }while (c.moveToNext());
        }

        return null;
    }

    @Override
    public int eliminar(int _id) {
        return database.delete(MiSQLiteOpenHelper.TABLE_NOTAS_NAME,"_id = ?",new String[]{String.valueOf(_id)});
    }

    @Override
    public int actualizar(Nota obj) {
        ContentValues cv = new ContentValues();
        cv.put(MiSQLiteOpenHelper.COLUMNS_NOTAS[0],obj.get_Id());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NOTAS[1],obj.getTitulo());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NOTAS[2],obj.getDescripcion());
        return database.update(MiSQLiteOpenHelper.TABLE_NOTAS_NAME,cv,"_id = ?",new String[]{String.valueOf(obj.get_Id())});
    }
}
