package com.example.restoap;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        EditText username = (EditText) findViewById(R.id.username);
        EditText email = (EditText) findViewById(R.id.email);
        EditText mdp = (EditText) findViewById(R.id.password);

        MaterialButton regbtn = (MaterialButton) findViewById(R.id.signupbtn);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString();


                OkHttpClient httpclient = new OkHttpClient();

                Gson gson = new Gson();
                if (username.getText().length() ==0 || email.getText().length() ==0 || mdp.getText().length() ==0){
                    Toast.makeText(RegisterActivity.this, "Information invalide !  " , Toast.LENGTH_SHORT).show();
                    return;
                }
                Util user1 = new Util(username.getText().toString(), email.getText().toString(), mdp.getText().toString());

                String user = gson.toJson(user1);
                System.out.println(user);

                MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(user, JSON);

                OkHttpClient client = new OkHttpClient();


                Request request = new Request.Builder()
                        .url("http://192.168.1.45/projet/sendAccountJSON.php")
                        .post(body)
                        .build();
                httpclient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        e.printStackTrace();
                        Log.i("Erreur 1", "Erreur requête sendAccount");
                        RegisterActivity.this.runOnUiThread(()->{
                            Toast.makeText(RegisterActivity.this, "erreur dans la requête ", Toast.LENGTH_SHORT).show();

                        });
                    }


                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        System.out.println(response.code());
                        RegisterActivity.this.runOnUiThread(()->{
                            Toast.makeText(RegisterActivity.this, "Ton Compte a été crée !  " , Toast.LENGTH_SHORT).show();
                            Intent intent3 = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent3);
                        });

                    }
                });

            }


        });


    }
}


