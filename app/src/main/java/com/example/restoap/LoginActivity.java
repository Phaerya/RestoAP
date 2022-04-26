package com.example.restoap;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button_withoutlog = findViewById(R.id.button_withoutlog);
        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        MaterialButton loginbtn = findViewById(R.id.loginbtn);

        //admin and admin
        Util Utilisateur1 =new Util("admin", "test@","admin");
        loginbtn.setOnClickListener((view)-> {

                if(username.getText().toString().equals(Utilisateur1.getUtil()) && password.getText().toString().equals(Utilisateur1.getMdp())){
                    //correct
                    Toast.makeText(LoginActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    //Ouverture de l'activité Resto
                    Intent intent= new Intent(this, MainActivity.class);
                    startActivity(intent);

                }else
                    //incorrect
                    Toast.makeText(LoginActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            });

        button_withoutlog.setOnClickListener(view -> {
            Intent intent= new Intent(this, MainActivity.class);
            startActivity(intent);
        });


    }
}