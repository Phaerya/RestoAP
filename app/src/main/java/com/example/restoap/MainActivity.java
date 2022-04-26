package com.example.restoap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //On définit une collection de restaurants
        ArrayList<Resto> lesRestos = new ArrayList<Resto>();

        Button button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(view ->{
            Intent intent= new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        OkHttpClient httpclient = new OkHttpClient();
        final ListView listViewRestos = findViewById(R.id.listViewRestos);

        //Prépare la requête
        Request requestClients = new Request.Builder().url("http://192.168.1.46/projet/getAllRestosJSON.php").build();
        httpclient.newCall(requestClients).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                Log.i("Erreur 1", "Erreur requête getAllByJSON");
            }

            @Override
            public void onResponse(@NonNull Call Call, @NonNull Response response) throws IOException {

                final String myResponse = response.body().string();
                System.out.println(myResponse);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObjectLesRestos = new JSONObject(myResponse);
                            JSONArray jsonArray = jsonObjectLesRestos.optJSONArray("restos");
                            lesRestos.clear();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int idResto = jsonObject.getInt("idResto");
                                String nom = jsonObject.getString("nomResto");
                                String ville = jsonObject.getString("ville");
                                String codePostal = jsonObject.getString("codePostal");
                                String localisation = jsonObject.getString("localisation");
                                String horaires = jsonObject.getString("horaires");
                                String description = jsonObject.getString("description");

                                Log.i("restos", nom + " " + ville + " ");
                                Resto r = new Resto(idResto, nom, ville, codePostal, localisation, horaires, description);
                                lesRestos.add(r);
                            }

                            ArrayAdapter<Resto> dataAdapter = new ArrayAdapter<Resto>(MainActivity.this, android.R.layout.simple_list_item_1, lesRestos);
                            listViewRestos.setAdapter(dataAdapter);

                        } catch (final JSONException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.i("Erreur 2", "ligne 76");
                                }
                            });
                        }
                    }
                });

                listViewRestos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Resto r = (Resto) listViewRestos.getItemAtPosition(position);
                        startViewUnRestoActivity(r);
                    }

                });

            }

            private void startViewUnRestoActivity(Resto r) {
                Intent intent = new Intent(MainActivity.this, DetailRestoActivity.class);
                intent.putExtra("Resto", r);
                startActivity(intent);
            }

        });
    }
}
