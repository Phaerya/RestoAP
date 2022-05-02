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
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.*;

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
                EditText nbpersonne = (EditText) findViewById(R.id.nbpersonne);
                EditText date_heure = (EditText) findViewById(R.id.dateheure);

                String username1 = username.getText().toString();


                OkHttpClient httpclient = new OkHttpClient();

                Gson gson = new Gson();
                if (idResto.getText().length() ==0){
                    Toast.makeText(DetailRestoActivity.this, "Erreur : aucun restaurant choisis" , Toast.LENGTH_SHORT).show();
                    return;
                }
                Reserv reserv1 = new Reserv(idResto.toString(), idUtil.toString(), date_heure.getText().toString(), nbpersonne.toString())

                String reservation = gson.toJson(reserv1);
                System.out.println(reserv1);

                MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(reservation, JSON);

                OkHttpClient client = new OkHttpClient();

            }
        };
        btnRetour.setOnClickListener(ecouteur);
    }
}