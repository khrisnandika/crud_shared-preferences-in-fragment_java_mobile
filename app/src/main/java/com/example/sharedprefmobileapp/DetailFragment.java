package com.example.sharedprefmobileapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class DetailFragment extends Fragment {

    TextView namaView, usernameView, emailView, alamatView;
    Button keluar;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ALAMAT = "alamat";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        namaView = view.findViewById(R.id.txtNama);
        usernameView = view.findViewById(R.id.txtUser);
        emailView = view.findViewById(R.id.txtEmail);
        alamatView = view.findViewById(R.id.txtAlamat);
        keluar = view.findViewById(R.id.buttonLogout);

        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String nama = sharedPreferences.getString(KEY_NAME, null);
        String username = sharedPreferences.getString(KEY_USERNAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);
        String alamat = sharedPreferences.getString(KEY_ALAMAT, null);

        if (nama != null || username != null || email != null || alamat != null) {
            namaView.setText("Fullname : " +nama);
            usernameView.setText("Username : " +username);
            emailView.setText("Email : " +email);
            alamatView.setText("Alamat : " +alamat);
        }
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent i = new Intent(getActivity(), Login.class);
                startActivity(i);
                Toast.makeText(getActivity(), "Berhasil Keluar", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}