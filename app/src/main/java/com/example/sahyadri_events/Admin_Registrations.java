package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.ArrayList;

public class Admin_Registrations extends AppCompatActivity {
    Button btn_back3;
    RecyclerView admin_recycler;
    private AutoCompleteTextView Event_autoComplete;
    private ArrayList<String> event_ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registrations);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        DBHelper db=new DBHelper(this);
        Event_autoComplete=findViewById(R.id.Event_autoComplete);
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
    }

    public void openAdminHome(String str) {
        Intent intent3=new Intent(getApplicationContext(), AdminHomePage.class);
        intent3.putExtra("message_key", str);
        startActivity(intent3);
        finish();
    }
}