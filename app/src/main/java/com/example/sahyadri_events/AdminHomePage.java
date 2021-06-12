package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHomePage extends AppCompatActivity {
Button btn_addEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        btn_addEvent=findViewById(R.id.btn_addEvent);
        btn_addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openAddEvent();
            }
        });
    }
    public void openAddEvent(){
        Intent intent=new Intent(this,Admin_Add_event.class);
        startActivity(intent);
    }
}