package com.example.nono.oxfamv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by BasilFabris on 26/01/2018.
 */

public class StockDB extends SQLiteOpenHelper {

    static ArrayList<Product_Stock> data = new ArrayList<Product_Stock>();

    private static final int DATA_BASE_VERSION = 1;

    private static final String TABLE_NAME = "Stock";
    private static final String ID = "ID";
    private static final String PRODUCTTYPE= "ProductType";
    private static final String PRODUCTNAME = "ProductName";
    private static final String DISPONIBILITY = "Disponible";

    private static final String DATABASE_NAME = "OxfamPreInit.db";

    public StockDB(Context context) {
        super(context, DATABASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, ProductType TEXT, ProductName TEXT,  Disponible TEXT)");

        MainActivity ma = new MainActivity();
        Produits[] produits = ma.getListeProduits();

        System.out.println("Log: new DB " + produits.length);

        for(int i = 0; i < produits.length; i++) {

            ContentValues contentValues = new ContentValues();

            contentValues.put(PRODUCTTYPE, produits[i].getCategory());
            contentValues.put(PRODUCTNAME, produits[i].getNomProduits());
            contentValues.put(DISPONIBILITY, "0");

            db.insert(TABLE_NAME, null, contentValues);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void initialization() {
        SQLiteDatabase db = this.getWritableDatabase();

        System.out.println("Log Init");

        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);

        while (res.moveToNext()) {

            System.out.println("Log: ID: " + res.getString(0) + " Type: " + res.getString(res.getColumnIndex(PRODUCTTYPE)) + " Name: " + res.getString(res.getColumnIndex(PRODUCTNAME)) + " Dispo: " + res.getString(res.getColumnIndex(DISPONIBILITY)));
            int givenID = Integer.valueOf(res.getString(0));
            Product_Stock product_stock = new Product_Stock(givenID, res.getString(res.getColumnIndex(PRODUCTTYPE)), res.getString(res.getColumnIndex(PRODUCTNAME)), res.getString(res.getColumnIndex(DISPONIBILITY)));
            data.add(product_stock);
        }

        res.close();
    }

    public boolean empty() {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = ("SELECT count(*) FROM "+TABLE_NAME);
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);

        if(icount>0) {
            mcursor.close();
            return false;
        }

        else {
            mcursor.close();
            return true;
        }
    }

    public void stockUpdate(Product_Stock obj, String amount) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID, obj.getID());
        contentValues.put(DISPONIBILITY, amount);

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {obj.getID()});

        obj.setStock(amount);
    }

    public static ArrayList getData() {
       return data;
    }
}