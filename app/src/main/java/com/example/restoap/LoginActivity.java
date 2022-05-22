package com.example.restoap;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button_register = findViewById(R.id.button_register);
        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        MaterialButton loginbtn = findViewById(R.id.loginbtn);


        OkHttpClient httpclient = new OkHttpClient();
        final ListView listViewRestos = findViewById(R.id.listViewRestos);


        Set<Util> users = new HashSet<>();






        //Prépare la requête
        Request requestUtil = new Request.Builder().url("http://192.168.1.45/projet/getAllAccountJSON.php").build();
        httpclient.newCall(requestUtil).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                Log.i("Erreur 1", "Erreur requête getAllByJSON");
            }

            @Override
            public void onResponse(@NonNull Call Call, @NonNull Response response) throws IOException {

                final String myResponse = response.body().string();
                System.out.println(myResponse);
                LoginActivity.this.runOnUiThread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void run() {
                        try {
                            Gson gson = new Gson();
                            JsonObject obj = gson.fromJson(myResponse, JsonObject.class);
                            JsonArray array = gson.fromJson(obj.get("util").getAsJsonArray(), JsonArray.class);

                            array.forEach(jsonElement -> {
                                JsonObject object = jsonElement.getAsJsonObject();
                                users.add(gson.fromJson(object.toString(), Util.class));


                            });
                        } catch (final Exception e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.i("Erreur 2", "ligne 76");
                                }
                            });
                        }
                    }
                });
                loginbtn.setOnClickListener((view)->{
                    String pseudo = username.getText().toString();
                    String mdp = password.getText().toString();
                    boolean register = false;
                    for (Util user : users) {
                        if (user.getPseudo().equals(pseudo) && user.getMdp().equals(mdp)){
                            Toast.makeText(LoginActivity.this, "Tu es bien connectée ! "+ user.getPseudo() , Toast.LENGTH_SHORT).show();
                            Intent intent3 = new Intent(LoginActivity.this, MainActivity.class);
                            intent3.putExtra("user", user);
                            startActivity(intent3);
                            register = true;
                        }
                    }
                    if (!register){
                        Toast.makeText(LoginActivity.this, "Identifiant invalide ! ", Toast.LENGTH_SHORT).show();
                    }


                });

                //admin and admin



                button_register.setOnClickListener(view -> {
                    Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent2);
                });

            }
        });
    }
}