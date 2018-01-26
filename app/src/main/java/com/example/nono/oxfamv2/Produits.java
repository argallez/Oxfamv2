package com.example.nono.oxfamv2;

import android.media.Image;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.nono.oxfamv2.MainActivity.tabQuant;

/**
 * Created by Nono on 24-08-17.
 */

public class Produits{
    //Getters & Setters
    public String getNomProduits() {
        return nomProduits;
    }



    public int getNbreProduitsPlus() {
        return nbreProduitsPlus;
    }

    public float getPrixProduits() {
        return prixProduits;
    }

    public int getTab() {
        return tab;
    }

    public int getId() {
        return this.id;
    }

    public int getStock() {
        return this.stock;
    }

    public void setNomProduits(String nomProduits) {
        this.nomProduits = nomProduits;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setNbreProduitsPlus(int nbreProduitsPlus) {
        this.nbreProduitsPlus = nbreProduitsPlus;
    }

    public void setPrixProduits(float prixProduits) {
        this.prixProduits = prixProduits;
    }

    public void setTab(int tab) {
        this.tab = tab;
    }



    //Variables d'instance
    private String nomProduits;

    private int nbreProduitsPlus;
    private float prixProduits;
    private int tab;
    private static int ID = 1;
    private int id;
    private int stock;



    //Constructeur
    public Produits (String pNom, float pPrix, int ptab){
        this.nomProduits= pNom;
        this.prixProduits = pPrix;
        this.nbreProduitsPlus = 0;
        this.tab=ptab;
        this.id = ID;
        ID++;

        }


}
