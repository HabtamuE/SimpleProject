package com.beginner.userinformationmanagmentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper  {
    static  String Database_Name="Register.dbo";
    static  String Table_Name="User";
    static  String Column_1="ID";
    static  String Column_2="First_Name";
    static  String Column_3="Last_Name";
    static  String Column_4="User_Name";
    static  String Column_5="Password";
    static  String Column_6="Email";
    static  String Column_7="Phone_Number";
    static  String Column_8="Gender";


          public DatabaseHelper(@Nullable Context context) {
        super(context, Database_Name, null, 1);
           }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+Table_Name+"(ID INTEGER PRIMARY KEY AUTOINCREMENT ,First_Name TEXT ,Last_Name TEXT ,User_Name TEXT ,Password TEXT ,Email TEXT ,Phone_Number TEXT ,Gender TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertUser(String firestname,String lastname,String username,String password,String email,String phone,String gender){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_2, firestname);
        contentValues.put(Column_3, lastname);
        contentValues.put(Column_4, username);
        contentValues.put(Column_5, password);
        contentValues.put(Column_6, email);
        contentValues.put(Column_7, phone);
        contentValues.put(Column_8, gender);
       long resultt=  db.insert(Table_Name,null,contentValues);
       if(resultt==-1)return  false;
       else return  true;

    }

   public  boolean isLoginValid(String username,String password){
        String sql="select count(*) from  User where User_Name='"+username+"' and Password='"+password+"'";
       SQLiteStatement statement=getReadableDatabase().compileStatement(sql);
       long l=statement.simpleQueryForLong();
      statement.close();

      if(l==1){
          return true;
      }
      else
      {
          return false;
      }

   }




}