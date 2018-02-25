package com.example.nono.oxfamv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by BasilFabris on 19/02/2018.
 */

public class PromoDB {
 /*
    private static ArrayList<String[]> promoList = new ArrayList<>() ;

    private static final int DATA_BASE_VERSION = 1;

    private static final String TABLE_NAME = "Promos";
    private static final String ID = " id";
    private static final String NAME_PROMO = " promoName";

    private static final String DATABASE_NAME = "Promo.db";

    public PromoDB(Context context) {
        super(context, DATABASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, promoName TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void initialization() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);

        while(res.moveToNext()) {
            String[] tempArray = {String.valueOf(ID), res.getString(res.getColumnIndex(NAME_PROMO))};
            promoList.add(tempArray);
        }
    }

    public void update(int id, String updated) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID, id);
        contentValues.put(NAME_PROMO, updated);

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {String.valueOf(id)});

        String[] list = promoList.get(id);

        list[1] = updated;

        promoList.add(list);
    }

    public void add(String newPromo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME_PROMO, newPromo);

        db.insert(TABLE_NAME ,null ,contentValues );

        initialization();
    }

    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID = ?", new String[] {String.valueOf(id)});

        promoList.remove(id);
    }

    public ArrayList getPromos() {
        return promoList;
    }
    */
}