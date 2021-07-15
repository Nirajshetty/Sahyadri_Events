package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Admin_Registrations extends AppCompatActivity {
    Button btn_back3,btn_search;
    RecyclerView admin_recycler;
    AutoCompleteTextView Event_autoComplete;
    String event_id_auto;
    DBHelper db=new DBHelper(this);
    ArrayList<String>  name,usn,mailID,branch;
    ArrayList<Integer> sem;
    private ArrayList<String> event_ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registrations);
        Event_autoComplete=findViewById(R.id.Event_autoComplete);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");


        event_ids=db.getEventId(str);
        ArrayAdapter<String> array=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,event_ids);
        Event_autoComplete.setAdapter(array);
        btn_back3 = findViewById(R.id.btn_back3);
        btn_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminHome(str);
            }
        });

        admin_recycler=findViewById(R.id.admin_recycler);
        btn_search=findViewById(R.id.btn_search);
    }
    void storeDataInArrays(String admin,String event_id_auto){
        Cursor cursor = db.readAdminRegistrationData(admin,event_id_auto);
        ImageView reg_img=findViewById(R.id.reg_img);
        if(cursor.getCount() == 0){
            Toast.makeText(Admin_Registrations.this,"No Registrations found",Toast.LENGTH_SHORT).show();
        }else{
            TextView txt_total=findViewById(R.id.txt_total);
            txt_total.setText("Total Registrations -");
            int count=cursor.getCount();
            TextView txt_reg=findViewById(R.id.txt_reg);
            txt_reg.setText(Integer.toString(count));

            reg_img.setVisibility(View.GONE);
            while (cursor.moveToNext()) {
                name.add(cursor.getString(0));
                mailID.add(cursor.getString(1));
                usn.add(cursor.getString(4));
                sem.add(cursor.getInt(2));
                branch.add(cursor.getString(3));
            }
        }
    }
    public void openAdminHome(String str) {
        Intent intent3=new Intent(getApplicationContext(), AdminHomePage.class);
        intent3.putExtra("message_key", str);
        startActivity(intent3);
        finish();
    }

    public void search(View view) {
        name=new ArrayList<>();
        mailID=new ArrayList<>();
        usn=new ArrayList<>();
        sem=new ArrayList<>();
        branch=new ArrayList<>();
        ImageView reg_img=findViewById(R.id.reg_img);
        event_id_auto=Event_autoComplete.getText().toString();
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        if(event_id_auto.equals("")){
            Toast.makeText(Admin_Registrations.this,"Please Enter the Event-ID",Toast.LENGTH_SHORT).show();
            reg_img.setVisibility(View.VISIBLE);
            admin_recycler.setAlpha(0);
            TextView txt_total=findViewById(R.id.txt_total);
            txt_total.setVisibility(View.GONE);
            TextView txt_reg=findViewById(R.id.txt_reg);
            txt_reg.setVisibility(View.GONE);
        }
        else {
            admin_recycler.setAlpha(1);
            TextView txt_total=findViewById(R.id.txt_total);
            txt_total.setVisibility(View.VISIBLE);
            TextView txt_reg=findViewById(R.id.txt_reg);
            txt_reg.setVisibility(View.VISIBLE);
            storeDataInArrays(str, event_id_auto);
            AdminRegistrationsAdapter adminRegistrationAdapter = new AdminRegistrationsAdapter(Admin_Registrations.this, this, name, mailID, usn, sem, branch);
            admin_recycler.setHasFixedSize(true);
            admin_recycler.setLayoutManager(new LinearLayoutManager(this));
            admin_recycler.setAdapter(adminRegistrationAdapter);
        }
    }
}