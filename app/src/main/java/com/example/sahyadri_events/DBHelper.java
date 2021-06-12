package com.example.sahyadri_events;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context){
        super(context,"Sahyadri_events1.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student_details(name TEXT ,mail TEXT primary key,password TEXT,usn TEXT,sem NUMBER,branch TEXT)");
        db.execSQL("create table admin_details(admin_name TEXT ,admin_mail TEXT,admin_password TEXT,admin_id TEXT primary key,admin_vector BLOB)");
        db.execSQL("create table events(event_id TEXT ,admin_mail TEXT,admin_password TEXT,admin_id TEXT primary key,admin_vector BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student_details");
        db.execSQL("drop table if exists admin_details");
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



    public Boolean updateStudentDetails(String mail,String name,String password,String usn,Number sem,String branch)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentvalue=new ContentValues();
        contentvalue.put("mail",mail);
        contentvalue.put("name",name);
        contentvalue.put("usn",usn);
        contentvalue.put("sem", (Integer) sem);
        contentvalue.put("password",password);
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
}
