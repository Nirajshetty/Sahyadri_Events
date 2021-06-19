package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;

import android.database.Cursor;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentProfile extends AppCompatActivity {
EditText student_name,student_mail,student_usn,student_sem,student_branch;
Button btn_profile_update,btn_back9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        student_mail = findViewById(R.id.student_mail);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        student_mail.setText(str);

        student_name = findViewById(R.id.student_name);
        student_usn = findViewById(R.id.student_usn);
        student_sem = findViewById(R.id.student_sem);
        student_branch = findViewById(R.id.student_branch);
        btn_profile_update=findViewById(R.id.btn_profile_update);
        btn_back9=findViewById(R.id.btn_back9);
        DBHelper db =new DBHelper(this);
        Cursor c=db.getData(str);
        if(c.moveToFirst()){
            do {
                student_name.setText(c.getString(c.getColumnIndex("name")));
                student_usn.setText(c.getString(c.getColumnIndex("usn")));
                student_sem.setText(c.getString(c.getColumnIndex("sem")));
                student_branch.setText(c.getString(c.getColumnIndex("branch")));
            }while(c.moveToNext());
        }
        c.close();

        btn_profile_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_name=student_name.getText().toString();
                String s_mail=student_mail.getText().toString();
                String s_usn=student_usn.getText().toString();
                int  s_sem=Integer.parseInt(student_sem.getText().toString());
                String s_branch=student_branch.getText().toString();
                Boolean updateed=db.updateStudentDetails(s_mail,s_name,s_usn,s_sem,s_branch);
                if (updateed) {
                    Toast.makeText(StudentProfile.this, "Successfully Updated!", Toast.LENGTH_SHORT).show();
                    openStudentHomepage();
                } else {
                    Toast.makeText(StudentProfile.this, "Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn_back9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudentHome(str);
            }
        });
    }
    public void openStudentHomepage(){

        String mailTXT=student_mail.getText().toString();
        Intent intent3=new Intent(getApplicationContext(), StudentLandingPage.class);
        intent3.putExtra("message_key", mailTXT);
        startActivity(intent3);
        finish();
    }
    public void openStudentHome(String str){
        Intent intent4=new Intent(getApplicationContext(), StudentLandingPage.class);
        intent4.putExtra("message_key", str);
        startActivity(intent4);
        finish();
    }
}