package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StudentLandingPage extends AppCompatActivity {
    Button btn_logout,btn_register_event,btn_student_registrations;
    ImageView img_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");

        setContentView(R.layout.activity_student_landing_page);
        btn_logout=findViewById(R.id.btn_logout);
        btn_register_event=findViewById(R.id.btn_register_event);
        btn_student_registrations=findViewById(R.id.btn_student_registrations);
        img_profile=findViewById(R.id.img_profile);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                logout();
            }
        });
        btn_register_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openStudentRegisterEvent(str);
            }
        });
        btn_student_registrations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openStudent_registrations(str);
            }
        });
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openStudentProfile(str);
            }
        });
    }
    public void logout(){
        Intent intent1=new Intent(this,StudentLoginPage.class);
        startActivity(intent1);
        finish();
    }
    public void openStudentRegisterEvent(String str){
        Intent intent2=new Intent(getApplicationContext(), StudentRegisterEvent.class);
        intent2.putExtra("message_key", str);
        startActivity(intent2);
        finish();
    }
    public void openStudent_registrations(String str){
        Intent intent3=new Intent(getApplicationContext(), Student_Registrations.class);
        intent3.putExtra("message_key", str);
        startActivity(intent3);
        finish();
    }
    public void openStudentProfile(String str){
        Intent intent4=new Intent(getApplicationContext(), StudentProfile.class);
        intent4.putExtra("message_key", str);
        startActivity(intent4);
        finish();
    }
}