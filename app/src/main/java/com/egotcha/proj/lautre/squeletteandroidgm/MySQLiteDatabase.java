package com.egotcha.proj.lautre.squeletteandroidgm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteDatabase extends SQLiteOpenHelper {

    private static final String TABLE_MARKERS = "table_markers";
    private static final String COL_ID = "ID";
    private static final String COL_TITRE = "TITRE";
    private static final String COL_LAT = "LAT";
    private static final String COL_LNG = "LNG";

    private static final String CREATE_TABLE_CONTACTS =
            "CREATE TABLE " + TABLE_MARKERS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_TITRE  + " TEXT NOT NULL, "
            + COL_LAT  + " DOUBLE , "
            + COL_LNG + " DOUBLE ) ; ";

    public MySQLiteDatabase(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CONTACTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_MARKERS + ";");
        onCreate(sqLiteDatabase);
    }
}