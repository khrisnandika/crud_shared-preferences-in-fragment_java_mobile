package com.example.sharedprefmobileapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EditDataFragment extends Fragment {

    EditText namaField, usernameField, emailField, alamatField;
    Button simpan;
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
        View view = inflater.inflate(R.layout.fragment_edit_data, container, false);

        namaField = view.findViewById(R.id.fieldNama);
        usernameField = view.findViewById(R.id.fieldUser);
        emailField = view.findViewById(R.id.fieldEmail);
        alamatField = view.findViewById(R.id.fieldAlamat);
        simpan = view.findViewById(R.id.btnSimpan);

        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String nama = sharedPreferences.getString(KEY_NAME, null);
        String username = sharedPreferences.getString(KEY_USERNAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);
        String alamat = sharedPreferences.getString(KEY_ALAMAT, null);

        if (nama != null || username != null || email != null || alamat != null) {
            namaField.setText("Fullname : " +nama);
            usernameField.setText("Username : " +username);
            emailField.setText("Email : " +email);
            alamatField.setText("Alamat : " +alamat);
        }

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg1 = namaField.getText().toString();
                String msg2 = usernameField.getText().toString();
                String msg3 = emailField.getText().toString();
                String msg4 = alamatField.getText().toString();
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, msg1);
                editor.putString(KEY_USERNAME, msg2);
                editor.putString(KEY_EMAIL, msg3);
                editor.putString(KEY_ALAMAT, msg4);
                editor.apply();
                Toast.makeText(getActivity(), "Berhasil Disimpan", Toast.LENGTH_LONG).show();
            }
        });

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String editNama = sharedPreferences.getString(KEY_NAME, nama);
        String editUsername = sharedPreferences.getString(KEY_USERNAME, username);
        String editEmail = sharedPreferences.getString(KEY_EMAIL, email);
        String editAlamat = sharedPreferences.getString(KEY_ALAMAT, alamat);
        namaField.setText(editNama);
        usernameField.setText(editUsername);
        emailField.setText(editEmail);
        alamatField.setText(editAlamat);

        return view;
    }
}