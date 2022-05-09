package com.example.restoap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DetailRestoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_resto);
        Intent intent = getIntent();
        Resto resto = (Resto) intent.getSerializableExtra("Resto");
        Util user = intent.getParcelableExtra("user");

        Button button_reserver = findViewById(R.id.btnReserver);
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

        button_reserver.setOnClickListener(view -> {

            MediaType JSON = MediaType.parse("application/json; charset=utf-8");


            Reservation reservation = new Reservation(user.getPseudo(), resto.getidResto());
            RequestBody body = RequestBody.create(new Gson().toJson(reservation), JSON);

            OkHttpClient httpclient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://192.168.1.46/projet/sendReservJSON.php")
                    .post(body)
                    .build();
            httpclient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    e.printStackTrace();
                    Log.i("Erreur 1", "Erreur requête sendResa");
                    DetailRestoActivity.this.runOnUiThread(()->{
                        Toast.makeText(DetailRestoActivity.this, "erreur dans la requête ", Toast.LENGTH_SHORT).show();

                    });
                }


                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    System.out.println(response.code());
                    DetailRestoActivity.this.runOnUiThread(()->{
                        Toast.makeText(DetailRestoActivity.this, "La reservation a bien été enregistrée " , Toast.LENGTH_SHORT).show();

                    });

                }
            });


        });
    }
}