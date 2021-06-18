package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHomePage extends AppCompatActivity {
Button btn_addEvent,btn_logout,btn_admin_registrations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        btn_addEvent=findViewById(R.id.btn_register);
        btn_addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openAddEvent();
            }
        });
        btn_logout=findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                logout();
            }
        });
        btn_admin_registrations=findViewById(R.id.btn_admin_registrations);
        btn_admin_registrations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openAdmin_registrations();
            }
        });
    }
    public void openAddEvent(){
        Intent intent=new Intent(this,Admin_Add_event.class);
        startActivity(intent);
    }
    public void logout(){
        Intent intent=new Intent(this,AdminLogin.class);
        startActivity(intent);
        finish();
    }
    public void openAdmin_registrations(){
        Intent intent=new Intent(this,Admin_Registrations.class);
        startActivity(intent);
    }
}