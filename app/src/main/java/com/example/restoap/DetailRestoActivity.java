package com.example.restoap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetailRestoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_resto);
        Intent intent = getIntent();
        Resto resto = (Resto) intent.getSerializableExtra("Resto");

        // Données des restaurants affichées
        TextView nomResto = findViewById(R.id.textViewNomResto);
        TextView localisation = findViewById(R.id.textViewLocalisation);
        TextView codePostal = findViewById(R.id.textViewCodePostal);
        TextView ville = findViewById(R.id.textViewVille);
        TextView horaires = findViewById(R.id.textViewHoraires);
        TextView description = findViewById(R.id.textViewDescription);

        nomResto.setText(resto.getNomResto());
        codePostal.setText(resto.getCodePostal());
        localisation.setText(resto.getLocalisation());
        ville.setText(resto.getVille());
        horaires.setText(resto.getHoraires());
        description.setText(resto.getDescription());

        // Bouton retour et réserver
        Button btnRetour = findViewById(R.id.btnRetour);
        View.OnClickListener ecouteur = new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Faire un switch case avec bouton réserver
                finish();
            }
        };
        btnRetour.setOnClickListener(ecouteur);
    }
}