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
    //Variables d'instance
    private String nomProduits;
    private String instance_name;
    private int nbreProduitsPlus;
    private float prixProduits;
    private int tab;
    private static int ID = 1;
    private int id;
    private int stock;



    //Constructeur
    public Produits (String pNom, String instance_name, float pPrix, int ptab){
        this.nomProduits= pNom;
        this.prixProduits = pPrix;
        this.nbreProduitsPlus = 0;
        this.tab=ptab;
        this.instance_name = instance_name;
        this.id = ID;
        ID++;

    }
    //Getters & Setters
    public String getNomProduits() {
        return nomProduits;
    }
    public void setNomProduits(String nomProduits) {
        this.nomProduits = nomProduits;
    }

    public int getNbreProduitsPlus() {
        return nbreProduitsPlus;
    }
    public void setNbreProduitsPlus(int nbreProduitsPlus) {
        this.nbreProduitsPlus = nbreProduitsPlus;
    }

    public float getPrixProduits() {
        return prixProduits;
    }
    public void setPrixProduits(float prixProduits) {
        this.prixProduits = prixProduits;
    }

    public int getTab() {
        return tab;
    }
    public void setTab(int tab) {
        this.tab = tab;
    }

    public int getId() {
        return this.id;
    }

    public int getStock() {
        return this.stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getInstance_name() {
        return instance_name;
    }
    public void setInstance_name(String instance_name) {
        this.instance_name = instance_name;
    }


   //Methodes de classe
    public String toString(){
        return this.getNomProduits()+": "+tabQuant[this.getTab()];
    }
}
