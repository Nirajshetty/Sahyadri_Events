package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentHomePage extends AppCompatActivity {
Button btn_logout,btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home_page);
        btn_logout=findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                logout();
            }
        });
        btn_register=findViewById(R.id.btn_logout);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openStudentRegisterEvent();
            }
        });
    }
    public void logout(){
        Intent intent=new Intent(this,StudentLogin.class);
        startActivity(intent);
    }
    public void openStudentRegisterEvent(){
        Intent intent=new Intent(this,StudentRegisterEvent.class);
        startActivity(intent);
    }
}