package com.egotcha.proj.lautre.squeletteandroidgm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MarkersBDD {


    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "markers.db";

    private static final String TABLE_MARKERS = "table_markers";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_TITRE = "TITRE";
    private static final int NUM_COL_TITRE = 1;
    private static final String COL_LAT = "LAT";
    private static final int NUM_COL_LAT = 2;
    private static final String COL_LNG = "LNG";
    private static final int NUM_COL_LNG = 3;
    private SQLiteDatabase bdd;

    private MySQLiteDatabase maBaseSQLite;

    public MarkersBDD(Context context) {
        maBaseSQLite = new MySQLiteDatabase(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open() {bdd = maBaseSQLite.getWritableDatabase();}
    public void close() {bdd.close();}
    public SQLiteDatabase getBDD() { return bdd; }

    public long insertMarker(Marker marker) {
        ContentValues values = new ContentValues();

        values.put(COL_TITRE, marker.getTitre());
        values.put(COL_LAT, marker.getLat());
        values.put(COL_LNG, marker.getLng());

        return bdd.insert(TABLE_MARKERS, null, values);
    }

    public Marker getFirstMarker() {
        Cursor c = bdd.query(TABLE_MARKERS, new String[] {COL_ID, COL_TITRE, COL_LAT, COL_LNG}, null, null, null, null, null);
        return cursorToMarker(c);
    }

    private Marker cursorToMarker(Cursor c) {
        if (c.getCount() == 0) return null;

        c.moveToFirst();

        Marker marker = new Marker();
        marker.setId(c.getInt(NUM_COL_ID));
        marker.setTitre(c.getString(NUM_COL_TITRE));
        marker.setLat(c.getDouble(NUM_COL_LAT));
        marker.setLng(c.getDouble(NUM_COL_LNG));

        c.close();

        return marker;
    }

}
