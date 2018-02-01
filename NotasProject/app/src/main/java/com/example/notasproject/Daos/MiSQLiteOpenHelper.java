package com.example.notasproject.Daos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MiSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DBNOTAS";
    private static final int DB_VERSION = 2;

    public static final String TABLE_NOTAS_NAME="NOTAS";
    public static final String TABLE_RECORDATORIOS_NAME="RECORDATORIOS";
    public static final String TABLE_MULTIMEDIA_NAME = "MULTIMEDIA";
    public static final String TABLE_NOTAS_RECORDATORIOS_NAME="NOTAS_RECORDATORIOS";

    public static final String[] COLUMNS_NOTAS = {"_id","nombre","descripcion"};
    public static final String[] COLUMNS_RECORDATORIOS = {"_id","nombre","fecha","hora"};
    public static final String[] COLUMNS_MULTIMEDIA = {"_id","nombre","direccion","tipo","descripcion"};
    public static final String[] COLUMNS_NOTAS_RECORDATORIOS ={"_id, id_Nota, id_Recordatoio,nombre"};

    private static final String TABLE_NOTAS = "CREATE TABLE " + TABLE_NOTAS_NAME +" ("
            + COLUMNS_NOTAS[0] + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMNS_NOTAS[1] + " VARCHAR(30) not null, "
            + COLUMNS_NOTAS[2] + " TEXT  null );";

    private static final String TABLE_RECORDATORIOS = "CREATE TABLE " + TABLE_RECORDATORIOS_NAME + " ("
            + COLUMNS_RECORDATORIOS[0] + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMNS_RECORDATORIOS[1] + " VARCHAR(30) not null, "
            + COLUMNS_RECORDATORIOS[2] + " DATE not null, "
            + COLUMNS_RECORDATORIOS[3] + " TIME not null );";

    private static final String TABLE_MULTIMEDIA = "CREATE TABLE " + TABLE_MULTIMEDIA_NAME + " ("
            + COLUMNS_MULTIMEDIA[0] + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMNS_MULTIMEDIA[1] + " VARCHAR(30) not null, "
            + COLUMNS_MULTIMEDIA[2] + " TEXT not null, "
            + COLUMNS_MULTIMEDIA[3] + " INTEGER not null, "
            + COLUMNS_MULTIMEDIA[4] + " TEXT null );";

    private static final String TABLE_NOTAS_RECORDATORIOS = "CREATE TABLE " + TABLE_NOTAS_RECORDATORIOS_NAME + " ("
            + COLUMNS_NOTAS_RECORDATORIOS[0] + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMNS_NOTAS_RECORDATORIOS[1] + " INTEGER not null, "
            + COLUMNS_NOTAS_RECORDATORIOS[2] + " INTEGER not null, "
            + COLUMNS_NOTAS_RECORDATORIOS[3] + " VARCHAR(30) null, FOREIGN KEY ( "
            + COLUMNS_NOTAS_RECORDATORIOS[1] + ") REFERENCES "
            + TABLE_NOTAS_NAME + " ( "+ COLUMNS_NOTAS[0] + " ), FOREIGN KEY ("
            + COLUMNS_NOTAS_RECORDATORIOS[2] + ") REFERENCES "
            + TABLE_RECORDATORIOS_NAME + " ( "+ COLUMNS_RECORDATORIOS[0] + "));";



    public MiSQLiteOpenHelper(Context contexto) {
        super(contexto, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_NOTAS);
        sqLiteDatabase.execSQL(TABLE_RECORDATORIOS);
        sqLiteDatabase.execSQL(TABLE_MULTIMEDIA);
        sqLiteDatabase.execSQL(TABLE_NOTAS_RECORDATORIOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
         sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DB_NAME);
         onCreate(sqLiteDatabase);
    }
}
