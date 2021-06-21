package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_Add_event extends AppCompatActivity {
    Button btn_back,btn_add_event;
    EditText event_name,event_description,event_id,event_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_event);
        btn_back = findViewById(R.id.btn_back);
        btn_add_event = findViewById(R.id.btn_add_event);
        event_name=findViewById(R.id.event_name);
        event_description=findViewById(R.id.event_description);
        event_id=findViewById(R.id.event_id);
        event_link=findViewById(R.id.event_link);
        DBHelper db =new DBHelper(this);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminHome();
            }
        });
        btn_add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eName=event_name.getText().toString();
                String eDescription=event_description.getText().toString();
                String eId=event_id.getText().toString();
                String eLink=event_link.getText().toString();
                if(eName.equals("") || eDescription.equals("") || eId.equals("") || eLink.equals("") )
                {
                    Toast.makeText(Admin_Add_event.this,"Please Enter all the Details",Toast.LENGTH_SHORT).show();
                }
                else{
                        Boolean checkInserted =db.insertEventDetails(eName,eDescription,eId,eLink);
                        if(checkInserted==true)
                        {
                            Toast.makeText(Admin_Add_event.this,"Event Added Successfully!",Toast.LENGTH_SHORT).show();
                            openAdminHome();
                        }
                        else
                        {
                            Toast.makeText(Admin_Add_event.this,"Failed",Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });
    }
    public void openAdminHome(){
        Intent intent=new Intent(this, AdminHomePage.class);
        startActivity(intent);
        finish();
    }
}