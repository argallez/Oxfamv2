package com.example.nono.oxfamv2;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static String vendeur1;
    public static String vendeur2;
    public static String vendeur3;
    public static String vendeur4;


    //DECLARATION DES PRODUITS
/* Le prochain produit portera le nombre 25 dans le tableau des entiers*/
    //CHIPS

    Produits Chips_sel= new Produits("Sel","Chips", 1.2f, 0);
    Produits Chips_paprika = new Produits("Paprika","Chips", 1.2f, 1);
    Produits Chips_tacos = new Produits("Tacos","Chips", 1.2f, 2);
    Produits Chips_caca = new Produits("Cacahuètes","Chips", 2.5f, 23);
    //CHOCOLAT
    Produits Chocolat_lait = new Produits("Lait","Chocolat",0.9f,3);
    Produits Chocolat_noir = new Produits("Noir","Chocolat",0.9f,4);
    Produits Chocolat_nois = new Produits("Noisettes","Chocolat",0.9f, 5);
    Produits Chocolat_praline = new Produits("Praliné","Chocolat",0.9f, 6);
    Produits Chocolat_blanc = new Produits ("Blanc","Chocolat",0.9f,7);

    //JUS
    Produits Jus_orange = new Produits("Orange","Jus",0.6f,8);
    Produits Jus_tropical = new Produits("Tropical","Jus",0.6f,9);
    Produits Jus_world = new Produits("Worldsh.","Jus",0.6f,10);
    Produits Jus_pomme = new Produits("Pomme","Jus",0.6f,22);
    Produits Jus_vidange = new Produits("Vidange","Jus",-0.1f,11);

    //BONBONS
    Produits Bon_SuMiel = new Produits("Su. Miel","Bon", 0.3f,12);
    Produits Bon_SaSuMiel = new Produits("Sa. Su. Miel","Bon", 1.9f,13);
    Produits Bon_cafe = new Produits("Bon. Café","Bon", 0.1f,14);
    Produits Bon_SaCafe = new Produits("Sa. Bon. Café.","Bon", 1.6f,15);
    Produits Bon_ourson = new Produits("Oursons","Bon", 1.6f,16);

    //SOFTS
    Produits Soft_cola = new Produits ("Coca","Soft",1.0f,17);
    Produits Soft_IceTea = new Produits("Ice Tea","Soft", 1.0f,18);
    Produits Soft_limonade = new Produits("Limonade","Soft",1.0f,19);

    //BARRES
    Produits Barre_nougat = new Produits ("Nougat","Barre",0.6f,20);
    Produits Barre_sesame = new Produits("Sésame","Barre",0.5f,21);

    //PROMOS
    Produits Promos_jusChoco = new Produits("Jus+Choco.","Promos",1.5f,24);

    public Produits listeProduits[]={Chips_sel, Chips_paprika, Chips_tacos, Chocolat_lait,Chocolat_noir,Chocolat_nois,
            Chocolat_praline,Chocolat_blanc, Jus_orange,Jus_tropical, Jus_vidange, Jus_world, Bon_SuMiel, Bon_SaSuMiel, Bon_cafe,
            Bon_SaCafe, Bon_ourson,Soft_cola,Soft_IceTea,Soft_limonade,Barre_nougat, Barre_sesame, Jus_pomme, Chips_caca, Promos_jusChoco};

    public Produits[] getListeProduits() {
        return listeProduits;
    }
    //DECLARATION DES ENTIERS

    //CHIPS
    public static int nbreChipsSel;
    public static int nbreChipsPaprika;
    public static int nbreChipsTacos;
    public static int nbreChipsCaca;

    //CHOCOLAT
    public static int nbreChocolatLait;
    public static int nbreChocolatNoir;
    public static int nbreChocolatNois;
    public static int nbreChocolatPraline;
    public static int nbreChocolatBlanc;

    //JUS
    public static int nbreJusOrange;
    public static int nbreJusTropical;
    public static int nbreJusWorldSh;
    public static int nbreJusPomme;
    public static int nbreJusVidange;

    //BONBONS
    public static int nbreBonSuMiel;
    public static int nbreBonSaSuMiel;
    public static int nbreBonCafe;
    public static int nbreBonSaCafe;
    public static int nbreBonOurson;

    //SOFTS
    public static int nbreSoftCola;
    public static int nbreSoftIceTea;
    public static int nbreSoftLimonade;

    //BARRES
    public static int nbreBarreSesame;
    public static int nbreBarreNougat;
    //PROMOS
    public static int nbrePromosJusChoco;
    public static int tabQuant[]={nbreChipsSel,nbreChipsPaprika,nbreChipsTacos,nbreChocolatLait,nbreChocolatNoir,nbreChocolatNois,
            nbreChocolatPraline,nbreChocolatBlanc,nbreJusOrange,nbreJusTropical,nbreJusWorldSh,nbreJusVidange,nbreBonSuMiel,nbreBonSaSuMiel,
            nbreBonCafe,nbreBonSaCafe,nbreBonOurson, nbreSoftCola, nbreSoftIceTea,nbreSoftLimonade, nbreBarreNougat,nbreBarreSesame,nbreJusPomme,
    nbreChipsCaca, nbrePromosJusChoco};




    //METHODES PRINCIPALES
    public void achat (final Produits objet, final TextView textProduit, final TextView textProduitPlus, ImageView imageProduit){
        textProduit.setText(objet.getNomProduits() + ": " + tabQuant[objet.getTab()]);
        assert textProduit != null;
        imageProduit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tabQuant[objet.getTab()]++;
                objet.setNbreProduitsPlus(objet.getNbreProduitsPlus()+1);
                textProduit.setText(objet.getNomProduits() + ": " + tabQuant[objet.getTab()]);
                textProduitPlus.setText("+" + objet.getNbreProduitsPlus());
                System.out.println(tabQuant[objet.getTab()]);
                return false;

            }
        });
        textProduitPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabQuant[objet.getTab()] --;
                textProduit.setText(objet.getNomProduits() + ": " + tabQuant[objet.getTab()]);
                objet.setNbreProduitsPlus(objet.getNbreProduitsPlus()-1);
                textProduitPlus.setText("+" + objet.getNbreProduitsPlus());
            }
        });



    }
    public void back_button(Button button) {
        final Intent backI = new Intent(this, MainScreen.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backI);
                finish();
            }
        });
    };

    //CALCUL ET AFFICHAGE DE L'ADDITION
    public void affichageTotal (final Produits objet, final TextView viewFinal){
        viewFinal.setText(objet.getNomProduits()+": "+tabQuant[objet.getTab()]);
    }

    /*
    * Methode calculant l'addition total de la journee
    */

    int longueur=listeProduits.length;
    public float tabAdditionFinale[]=new float[longueur];
    public float recette;
    public void calculAddition() {
        for (int i = 0; i < longueur; i++) {
            tabAdditionFinale[i] = tabQuant[listeProduits[i].getTab()] * listeProduits[i].getPrixProduits();
        }
        for (int j=0; j<longueur;j++){
            recette=recette+tabAdditionFinale[j];
        }
        recette=(recette*100)/100;
    }



    /*
    * @pre -
    * @post A cree un fichier .txt avec la date comme nom, reprenant les ventes de la journee
    * */
    public void printDay() {
        PrintWriter pr = null;

        try {
            //Nom du fichier
            Calendar rightNow = Calendar.getInstance();
            String date = rightNow.get(Calendar.DAY_OF_MONTH) + "-" + (rightNow.get(Calendar.MONTH)+1) + "-" + rightNow.get(Calendar.YEAR);
            String fileName = date.concat(".txt");

            ArrayList<Produits> listeTriee = new ArrayList<>();//Copie du tableau de produits dans une ArrayList, puis tri de celle-ci
            for(int k=0;k<listeProduits.length;k++)
            {
                listeTriee.add(listeProduits[k]);
            }
            Collections.sort(listeTriee);

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),fileName);//Creation du fichier
            pr = new PrintWriter(file);


            //On commence a ecrire dans le fichier
            pr.println(date);
            pr.println("--------------------------------------------------------");
            pr.println("VENDEURS");
            pr.println(vendeur1+"    "+vendeur2);
            pr.println(vendeur3+"    "+vendeur4);
            pr.println("--------------------------------------------------------");
            String first = listeTriee.get(0).getCategory();
            pr.println(first);
            String a;
            for(int j = 0;j<listeTriee.size();j++)
            {
                a = (listeTriee.get(j).getCategory());
                if(a.equals(first))
                    pr.println(listeTriee.get(j).toString());
                else{
                    pr.println();
                    first = a;
                    pr.println(first);
                    pr.println("-----------------");
                    pr.println(listeTriee.get(j));
                }
            }
            pr.println("--------------------------------------------------------");
            pr.println("SOMME TOTALE: "+recette+"€");
            pr.println("--------------------------------------------------------");
            //Affichage du Toast
            Context context = getApplicationContext();
            CharSequence text = "Fichier correctement imprimé!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            pr.close();//Fermeture du flux
        } catch (IOException p) {
            System.out.println("Fichier non créé! IO " + "msg: " + p.toString());
            pr.close();
        }
    }
}
