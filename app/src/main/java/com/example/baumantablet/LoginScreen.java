package com.example.baumantablet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class LoginScreen extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        nextBtn = findViewById(R.id.nextBtn);

        String[] groups = getResources().getStringArray(R.array.groups);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.dropdown_item, groups);

        autoCompleteTextView.setAdapter(arrayAdapter);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, TabletActivity.class);
                startActivity(intent);
            }
        });
    }
}