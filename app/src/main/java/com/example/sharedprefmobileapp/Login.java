package com.example.sharedprefmobileapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button login, register;
    EditText username, password;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.fieldUser);
        password = findViewById(R.id.fieldPassword);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pw = password.getText().toString();

                String registerUser = sharedPreferences.getString(KEY_USERNAME, null);
                String registerPass = sharedPreferences.getString(KEY_PASSWORD, null);

                if (user.equals(registerUser) && pw.equals(registerPass)) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}