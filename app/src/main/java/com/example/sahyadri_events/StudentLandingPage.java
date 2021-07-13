package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentLandingPage extends AppCompatActivity {
    Button btn_logout,btn_register_event,btn_student_registrations;
    ImageView img_profile;
    int i=1;
    RecyclerView student_home_recycler;
    ArrayList<String> id,event_name,event_id_recycler,event_description,admin_id;
    LandingPageAdapter landingPageAdapter;
    DBHelper db=new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_landing_page);

        Intent intent = getIntent();
        String mail = intent.getStringExtra("message_key");


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
                openStudentRegisterEvent(mail);
            }
        });
        btn_student_registrations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openStudent_registrations(mail);
            }
        });
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openStudentProfile(mail);
            }
        });


        student_home_recycler=findViewById(R.id.student_home_recycler);

        event_name = new ArrayList<>();
        event_id_recycler = new ArrayList<>();
        event_description= new ArrayList<>();
        admin_id= new ArrayList<>();
        id=new ArrayList<>();
        storeDataInArrays();

        landingPageAdapter = new LandingPageAdapter(StudentLandingPage.this,this,id,event_name,event_id_recycler,event_description,admin_id);
        student_home_recycler.setHasFixedSize(true);
        student_home_recycler.setLayoutManager(new LinearLayoutManager(this));
        student_home_recycler.setAdapter(landingPageAdapter);
    }
    void storeDataInArrays(){
        Cursor cursor = db.readEventDetails();
        if(cursor.getCount() == 0){
            Toast.makeText(StudentLandingPage.this,"No Events found",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()) {
                id.add(String.valueOf(i++));
                event_name.add(cursor.getString(0));
                event_id_recycler.add(cursor.getString(2));
                event_description.add(cursor.getString(1));
                admin_id.add(cursor.getString(4));
            }
        }
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