package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Registrations extends AppCompatActivity {
    Button btn_back3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registrations);
        btn_back3 = findViewById(R.id.btn_back3);
        btn_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminHome();
            }
        });
    }

    public void openAdminHome() {
        Intent intent = new Intent(this, AdminHomePage.class);
        startActivity(intent);
        finish();
    }
}