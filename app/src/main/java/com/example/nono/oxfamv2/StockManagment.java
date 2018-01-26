package com.example.nono.oxfamv2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by BasilFabris on 26/01/2018.
 */

public class StockManagment extends Fragment {

    private final Context CONTEXT = getActivity();
    private final StockDB STOCK_DB = new StockDB(getActivity());

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        Button AddButton = view.findViewById(R.id.addition_button);
        AddButton.setVisibility(view.GONE);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageView myChips = (ImageView) getView().findViewById(R.id.chips_button);
        assert myChips != null;
        myChips.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent chips_start = new Intent(getActivity(), Chips.class);
                chips_start.putExtra("Uniqid","Prof");
                startActivity(chips_start);
                return false;
            }
        });
        ImageView myChocolate = (ImageView) getView().findViewById(R.id.chocolate_button);
        assert myChocolate != null;
        myChocolate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent chocolate_start = new Intent(getActivity(), Chocolate.class);
                chocolate_start.putExtra("Uniqid","Prof");
                startActivity(chocolate_start);
                return false;
            }
        });
        ImageView myJuice = (ImageView) getView().findViewById(R.id.juice_button);
        assert myJuice != null;
        myJuice.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent juice_start = new Intent(getActivity(), Juice.class);
                juice_start.putExtra("Uniqid","Prof");
                startActivity(juice_start);
                return false;
            }
        });
        ImageView myCandy = (ImageView) getView().findViewById(R.id.candy_button);
        assert myCandy != null;
        myCandy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent candy_start = new Intent(getActivity(), Candy.class);
                candy_start.putExtra("Uniqid","Prof");
                startActivity(candy_start);
                return false;
            }
        });
        ImageView mySoft = (ImageView) getView().findViewById(R.id.soft_button);
        assert mySoft != null;
        mySoft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent soft_start = new Intent(getActivity(), Soft.class);
                soft_start.putExtra("Uniqid","Prof");
                startActivity(soft_start);
                return false;
            }
        });
        ImageView myBarre = (ImageView) getView().findViewById(R.id.barre_button);
        assert myBarre != null;
        myBarre.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent barre_start = new Intent(getActivity(), Barre.class);
                barre_start.putExtra("Uniqid","Prof");
                startActivity(barre_start);
                return false;
            }
        });
        Button myAddition = (Button) getView().findViewById(R.id.addition_button);
        assert myAddition != null;
        myAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addition_start= new Intent(getActivity(), Name.class);
                addition_start.putExtra("Uniqid","Prof");
                startActivity(addition_start);
            }
        });
        ImageView myPromos = (ImageView) getView().findViewById(R.id.promos_button);
        assert myPromos!= null;
        myPromos.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent promos_start = new Intent(getActivity(), Promos.class);
                promos_start.putExtra("Uniqid","Prof");
                startActivity(promos_start);
                return false;
            }
        });
    }

    public void ajouté(final Produits objet, final TextView textProduit, final TextView textProduitPlus, ImageView imageProduit) {

            textProduit.setText(objet.getNomProduits() + ": " + objet.getStock());

            assert textProduit != null;

            imageProduit.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setTitle(objet.getNomProduits());

                    final EditText input = new EditText(getActivity());
                    input.setText("");
                    alert.setView(input);

                    alert.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            STOCK_DB.stockUpdate(String.valueOf(objet.getId()), input.getText().toString());
                        }
                    });

                    alert.show();
                    return true;
                }
            });
    }
}
