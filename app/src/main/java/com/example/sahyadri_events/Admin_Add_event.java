package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Add_event extends AppCompatActivity {
    Button btn_event_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_event);
        btn_event_back=findViewById(R.id.btn_event_back);
        btn_event_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openAdminHome();
            }
        });
    }
    public void openAdminHome(){
        Intent intent=new Intent(this, AdminHomePage.class);
        startActivity(intent);
    }
}