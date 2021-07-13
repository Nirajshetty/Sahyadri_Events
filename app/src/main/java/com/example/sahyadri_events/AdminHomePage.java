package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminHomePage extends AppCompatActivity {
Button btn_addEvent,btn_logout,btn_admin_registrations;
    int i=1;
    RecyclerView admin_home_recycler;
    ArrayList<String> id,event_name,event_id_recycler,event_description,event_link;
    AdminHomeAdapter adminhomeAdapter;
    DBHelper db=new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");

        setContentView(R.layout.activity_admin_home_page);
        btn_addEvent=findViewById(R.id.btn_register);
        btn_addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openAddEvent(str);
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
                openAdmin_registrations(str);
            }
        });


        admin_home_recycler=findViewById(R.id.admin_home_recycler);

        event_name = new ArrayList<>();
        event_id_recycler = new ArrayList<>();
        event_description= new ArrayList<>();
        event_link= new ArrayList<>();
        id=new ArrayList<>();
        storeDataInArrays(str);

        adminhomeAdapter = new AdminHomeAdapter(AdminHomePage.this,this,id,event_name,event_id_recycler,event_description,event_link);
        admin_home_recycler.setHasFixedSize(true);
        admin_home_recycler.setLayoutManager(new LinearLayoutManager(this));
        admin_home_recycler.setAdapter(adminhomeAdapter);

    }
    void storeDataInArrays(String str){
        Cursor cursor = db.readAdminEventDetails(str);
        if(cursor.getCount() == 0){
            Toast.makeText(AdminHomePage.this,"No Events found",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()) {
                id.add(String.valueOf(i++));
                event_name.add(cursor.getString(0));
                event_id_recycler.add(cursor.getString(2));
                event_description.add(cursor.getString(1));
                event_link.add(cursor.getString(3));
            }
        }
    }
    public void openAddEvent(String str){
        Intent intent3=new Intent(getApplicationContext(), Admin_Add_event.class);
        intent3.putExtra("message_key", str);
        startActivity(intent3);
        finish();
    }
    public void logout(){
        Intent intent=new Intent(this,AdminLogin.class);
        startActivity(intent);
        finish();
    }
    public void openAdmin_registrations(String str){
        Intent intent3=new Intent(getApplicationContext(), Admin_Registrations.class);
        intent3.putExtra("message_key", str);
        startActivity(intent3);
        finish();
    }
}