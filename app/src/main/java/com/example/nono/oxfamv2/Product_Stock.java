package com.example.nono.oxfamv2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by BasilFabris on 03/02/2018.
 */

public class Product_Stock implements Parcelable{

    private int ID;
    private String type;
    private String name;
    private String stock;

    public Product_Stock(int ID, String type, String nom, String stock) {
        this.ID = ID;
        this.type = type;
        this.name = nom;
        this.stock = stock;
    }

    private Product_Stock(Parcel in) {
        this.ID = in.readInt();
        this.type = in.readString();
        this.name = in.readString();
        this.stock = in.readString();
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(this.ID);
        dest.writeString(this.type);
        dest.writeString(this.name);
        dest.writeString(this.stock);

    }

    public static final Parcelable.Creator<Product_Stock> CREATOR = new Parcelable.Creator<Product_Stock>() {
        public Product_Stock createFromParcel(Parcel in) {
            return new Product_Stock(in);
        }

        public Product_Stock[] newArray(int size) {
            return new Product_Stock[size];
        }
    };

    // all get , set method

    public void setStock(String stock) {
        System.out.println("Log: Updated" + stock );
        this.stock = stock;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return Integer.parseInt(this.stock);
    }

    public String getID() { return  String.valueOf(this.ID);}
}