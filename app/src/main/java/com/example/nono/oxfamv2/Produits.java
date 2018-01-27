package com.example.nono.oxfamv2;

import static com.example.nono.oxfamv2.MainActivity.tabQuant;

/**
 * Created by Nono on 24-08-17.
 */

public class Produits implements Comparable{
    //Variables d'instance
    private String nomProduits;
    private String category;
    private int nbreProduitsPlus;
    private float prixProduits;
    private int tab;
    private static int ID = 1;
    private int id;
    private int stock;



    //Constructeur
    public Produits (String pNom, String category, float pPrix, int ptab){
        this.nomProduits= pNom;
        this.prixProduits = pPrix;
        this.nbreProduitsPlus = 0;
        this.tab=ptab;
        this.category = category;
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

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }


   //Methodes de classe
    public String toString(){
        return this.getNomProduits()+": "+tabQuant[this.getTab()];
    }
    /*
    * CompareTo : trie alphabetiquement en fonction de category
    * */
    public int compareTo(Object other){
        Produits o = (Produits) other;
        return (this.getCategory().compareTo(o.getCategory()));
    }
}
