package com.example.sahyadri_events;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context){
        super(context,"SahyadrieventsData.db",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student_details(name TEXT ,mail TEXT primary key,password TEXT,usn TEXT,sem NUMBER,branch TEXT)");
        db.execSQL("create table admin_details(admin_password TEXT,admin_id TEXT primary key)");
        db.execSQL("create table event_details(event_name TEXT ,event_description TEXT,event_id TEXT primary key,event_link TEXT,admin_id TEXT,FOREIGN KEY(admin_id) REFERENCES admin_details(admin_id) on delete cascade)");
        db.execSQL("create table registered_students(ID INTEGER PRIMARY KEY AUTOINCREMENT,mail TEXT ,event_id TEXT,FOREIGN KEY(mail) REFERENCES student_details(mail) on delete cascade,FOREIGN KEY(event_id) REFERENCES event_details(event_id) on delete cascade)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student_details");
        db.execSQL("drop table if exists admin_details");
        db.execSQL("drop table if exists event_details");
        db.execSQL("drop table if exists registered_students");
    }

    public Boolean insertStudentDetails(String mail,String name,String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentvalue=new ContentValues();
        contentvalue.put("mail",mail);
        contentvalue.put("name",name);
        contentvalue.put("password",password);
        long result=DB.insert("student_details",null,contentvalue);
        if(result==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean insertEventDetails(String event_name,String event_description,String event_id,String event_link,String admin_id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentvalue=new ContentValues();
        contentvalue.put("event_name",event_name);
        contentvalue.put("event_description",event_description);
        contentvalue.put("event_id",event_id);
        contentvalue.put("event_link",event_link);
        contentvalue.put("admin_id",admin_id);
        long result=DB.insert("event_details",null,contentvalue);
        if(result==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean insertRegisterDetails(String student_mail,String event_id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentvalue=new ContentValues();
        contentvalue.put("mail",student_mail);
        contentvalue.put("event_id",event_id);
        long result=DB.insert("registered_students",null,contentvalue);
        if(result==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean insertAdminDetails(String id,String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentvalue=new ContentValues();
        contentvalue.put("admin_id",id);
        contentvalue.put("admin_password",password);
        long result=DB.insert("admin_details",null,contentvalue);
        if(result==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }



    public Boolean updateStudentDetails(String mail,String name,String usn,Number sem,String branch)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentvalue=new ContentValues();
        contentvalue.put("mail",mail);
        contentvalue.put("name",name);
        contentvalue.put("usn",usn);
        contentvalue.put("sem", (Integer) sem);
        contentvalue.put("branch",branch);
        Cursor cursor=DB.rawQuery("Select * from student_details where mail=?",new String[]{mail});
        if(cursor.getCount()>0) {
            long result=DB.update("student_details",contentvalue,"mail=?", new String[]{mail});
            if(result==-1)
            {
                return false;
            }
            else{
                return true;
            }
        }
        else
        {
            return false;
        }

    }
    public Boolean checkMail(String mail)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from student_details where mail=?",new String[]{mail});
        if(cursor.getCount()>0) {
                return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean checkEvent_id(String event_id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from event_details where event_id=?",new String[]{event_id});
        if(cursor.getCount()>0) {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean checkAuthentication(String mail,String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from student_details where mail=? and password=?",new String[]{mail,password});
        if(cursor.getCount()>0) {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean checkAdminAuthentication(String admin_id,String admin_password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from admin_details where admin_id=? and admin_password=?",new String[]{admin_id,admin_password});
        if(cursor.getCount()>0) {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Cursor getData(String mail)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from student_details where mail=?",new String[]{mail});
        return cursor;
    }
    public ArrayList<String> getEventId(String admin_id)
    {
        ArrayList<String> event_ids=new ArrayList<>();
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select event_id from event_details where admin_id=?",new String[]{admin_id});
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            event_ids.add(cursor.getString(cursor.getColumnIndex("event_id")));
            cursor.moveToNext();
        }
        cursor.close();
        return event_ids;
    }
    public ArrayList<String> getAllEventId()
    {
        ArrayList<String> event_ids=new ArrayList<>();
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.query("event_details",null,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            event_ids.add(cursor.getString(cursor.getColumnIndex("event_id")));
            cursor.moveToNext();
        }
        cursor.close();
        return event_ids;
    }
}
