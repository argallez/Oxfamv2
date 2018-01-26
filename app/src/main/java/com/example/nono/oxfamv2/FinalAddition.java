package com.example.nono.oxfamv2;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Nono on 02-09-17.
 */

public class FinalAddition extends MainActivity {
    public void print2() {
        PrintWriter pr;

        try {
            //Nom du fichier
            Calendar rightNow = Calendar.getInstance();
            String date = rightNow.get(Calendar.DAY_OF_MONTH) + "-" + rightNow.get(Calendar.MONTH) + "-" + rightNow.get(Calendar.YEAR);
            String fileName = date.concat(".txt");


            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),fileName);
            pr = new PrintWriter(file);


            //On commence a ecrire dans le fichier
            pr.println(date);
            pr.println("--------------------------------------------------------");
            String first = "Chips";
            String[] a;
            for(int j = 0;j<listeProduits.length;j++)
            {
                a = (listeProduits[j].toString()).split(" ");
                if(a[0].equals(first))
                    pr.println(listeProduits[j].toString());

                else{
                    pr.println();
                    first = a[0];
                    pr.println(first);
                }
            }

        pr.close();
        System.out.println("terminé");
            System.out.println("Fichier créé!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Fichier non créé! OOB ");

        } catch (IOException p) {
            System.out.println("Fichier non créé! IO " + "msg: " + p.toString());

        }
    }
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.addition_layout2);
            //DATE
            Calendar rightNow = Calendar.getInstance();
            String dayLongName = rightNow.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
            TextView weekday = (TextView) findViewById(R.id.weekday);
            weekday.setText(dayLongName);
            TextView date = (TextView) findViewById(R.id.date);
            date.setText(rightNow.get(Calendar.DAY_OF_MONTH) + "/" + rightNow.get(Calendar.MONTH) + "/" + rightNow.get(Calendar.YEAR));

            TextView viewVendeur1 = (TextView) findViewById(R.id.viewVendeur1);
            TextView viewVendeur2 = (TextView) findViewById(R.id.viewVendeur2);
            TextView viewVendeur3 = (TextView) findViewById(R.id.viewVendeur3);
            TextView viewVendeur4 = (TextView) findViewById(R.id.viewVendeur4);

            System.out.println(vendeur1);
            viewVendeur1.setText(vendeur1);
            viewVendeur2.setText(vendeur2);
            viewVendeur3.setText(vendeur3);
            viewVendeur4.setText(vendeur4);

            //AFFICHAGE PRODUITS

            //CHIPS
            affichageTotal(Chips_sel, (TextView) findViewById(R.id.viewSelFinal));
            affichageTotal(Chips_paprika, (TextView) findViewById(R.id.viewPaprikaFinal));
            affichageTotal(Chips_tacos, (TextView) findViewById(R.id.viewTacosFinal));
            affichageTotal(Chips_caca, (TextView) findViewById(R.id.viewCacaFinal));

            //CHOCOLAT
            affichageTotal(Chocolat_lait, (TextView) findViewById(R.id.viewLaitFinal));
            affichageTotal(Chocolat_noir, (TextView) findViewById(R.id.viewNoirFinal));
            affichageTotal(Chocolat_nois, (TextView) findViewById(R.id.viewNoisFinal));
            affichageTotal(Chocolat_praline, (TextView) findViewById(R.id.viewPralineFinal));
            affichageTotal(Chocolat_blanc, (TextView) findViewById(R.id.viewBlancFinal));

            //JUS
            affichageTotal(Jus_orange, (TextView) findViewById(R.id.viewOrangeFinal));
            affichageTotal(Jus_tropical, (TextView) findViewById(R.id.viewTropicalFinal));
            affichageTotal(Jus_world, (TextView) findViewById(R.id.viewWorldFinal));
            affichageTotal(Jus_pomme, (TextView) findViewById(R.id.viewPommeFinal));
            affichageTotal(Jus_vidange, (TextView) findViewById(R.id.viewVidangeFinal));

            //BONBONS
            affichageTotal(Bon_SuMiel, (TextView) findViewById(R.id.viewSuMielFinal));
            affichageTotal(Bon_SaSuMiel, (TextView) findViewById(R.id.viewSaSuMielFinal));
            affichageTotal(Bon_SaSuMiel, (TextView) findViewById(R.id.viewSaSuMielFinal));
            affichageTotal(Bon_cafe, (TextView) findViewById(R.id.viewBonCafeFinal));
            affichageTotal(Bon_SaCafe, (TextView) findViewById(R.id.viewSaBonCafeFinal));
            affichageTotal(Bon_ourson, (TextView) findViewById(R.id.viewSaBonOursonFinal));

            //SOFTS
            affichageTotal(Soft_cola, (TextView) findViewById(R.id.viewColaFinal));
            affichageTotal(Soft_IceTea, (TextView) findViewById(R.id.viewIceteaFinal));
            affichageTotal(Soft_limonade, (TextView) findViewById(R.id.viewLimonadeFinal));

            //BARRES
            affichageTotal(Barre_nougat, (TextView) findViewById(R.id.viewNougatFinal));
            affichageTotal(Barre_sesame, (TextView) findViewById(R.id.viewSesameFinal));

            //PROMOS
            affichageTotal(Promos_jusChoco, (TextView) findViewById(R.id.viewJusChocoFinal));

            calculAddition();
            TextView affichageRecette = (TextView) findViewById(R.id.viewMontantTotal);
            affichageRecette.setText("Recette Totale: " + recette + "€");


            print2();
        }

    }

