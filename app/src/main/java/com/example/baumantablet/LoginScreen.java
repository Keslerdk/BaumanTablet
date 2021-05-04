package com.example.baumantablet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class LoginScreen extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        String[] groups = getResources().getStringArray(R.array.groups);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.dropdown_item, groups);

        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}