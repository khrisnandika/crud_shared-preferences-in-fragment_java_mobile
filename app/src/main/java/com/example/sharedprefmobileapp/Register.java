package com.example.sharedprefmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText nama, username, email, alamat;
    Button register, login;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ALAMAT = "alamat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nama = findViewById(R.id.fieldNama);
        username = findViewById(R.id.fieldUser);
        email = findViewById(R.id.fieldEmail);
        alamat = findViewById(R.id.fieldAlamat);
        register = findViewById(R.id.btnRegister);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);

        if (name != null) {
            Intent i = new Intent(Register.this, MainActivity.class);
            startActivity(i);
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, nama.getText().toString());
                editor.putString(KEY_USERNAME, username.getText().toString());
                editor.putString(KEY_EMAIL, email.getText().toString());
                editor.putString(KEY_ALAMAT, alamat.getText().toString());
                editor.apply();

                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(Register.this, "Login sukses", Toast.LENGTH_LONG).show();
            }
        });
    }
}