package com.example.restoap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
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

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_resto);
        Intent intent = getIntent();
        Resto resto = (Resto) intent.getSerializableExtra("Resto");

        Button button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(view ->{
            Intent intentLogin= new Intent(this, LoginActivity.class);
            startActivity(intentLogin);
        });

        // Données des restaurants affichées
        TextView nomResto = findViewById(R.id.textViewNomResto);
        TextView numAdrR = findViewById(R.id.textViewNumRue);
        TextView voieAdrR = findViewById(R.id.textViewNomRue);
        TextView codePostal = findViewById(R.id.textViewCodePostal);
        TextView ville = findViewById(R.id.textViewVille);
        webView = findViewById(R.id.WebViewHorairesResto);
        webView.setBackgroundColor(Color.TRANSPARENT);
        TextView description = findViewById(R.id.textViewDescription);

        nomResto.setText(resto.getNomResto());
        codePostal.setText(resto.getCodePostal());
        numAdrR.setText(resto.getNumAdrR());
        voieAdrR.setText(resto.getVoieAdrR());
        ville.setText(resto.getVille());
        description.setText(resto.getDescription());
        webView.loadData(resto.getHoraires(),"text/html" ,"UTF-8");

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