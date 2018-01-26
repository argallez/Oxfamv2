package com.example.nono.oxfamv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BasilFabris on 26/01/2018.
 */

public class StockDB extends SQLiteOpenHelper {

    private static String used;
    private static final int DATA_BASE_VERSION = 1;

    private static final String TABLE_NAME = "Stock";
    private static final String ID = "ID";
    private static final String PRODUCTNAME = "ProductName";
    private static final String DISPONIBILITY = "Disponible";

    private static final String DATABASE_NAME = "Stock.db";

    public StockDB(Context context) {
        super(context, DATABASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, ProductName TEXT, Disponible INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean empty() {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = ("SELECT count(*) FROM "+TABLE_NAME);
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);

        if(icount>0)
            return false;
        else
            return true;
    }

    public void insert(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, contentValues);
    }

    public void stockUpdate(String id, String amount) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID, id);
        contentValues.put(DISPONIBILITY, amount);

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}
