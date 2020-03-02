package com.beginner.userinformationmanagmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.beginner.userinformationmanagmentapp.RecyclerViewClasses.AdapterClass;
import com.beginner.userinformationmanagmentapp.RecyclerViewClasses.ModalClass;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity {
    Button logout;
    RecyclerView objReycyclerView;
    ArrayList<ModalClass> objModalClass;
    DatabaseHelper dbo;
AdapterClass obAdapterClass;
private SharedPreference prf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_activity);
        dbo=new DatabaseHelper(this);
        objModalClass=new ArrayList<>();
        objReycyclerView=findViewById(R.id.rv);
        logout=findViewById(R.id.btnlogout);
        prf=new SharedPreference(this);
        if(!prf.loggedIn()){
            logout();
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });




    }
    private  void logout(){
prf.setLoggedIn(false);
finish();
        Intent intn=new Intent(HomeScreenActivity.this,LoginActivity.class);
        startActivity(intn);



    }
    public void showValuesFromDatabase(View view) {
      try {
            SQLiteDatabase objSqlite = dbo.getReadableDatabase();
            if (objSqlite != null) {
                Cursor cursor = objSqlite.rawQuery("select * from User", null);
                if (cursor.getCount() == 0)
                    Toast.makeText(this, "No data is returned", Toast.LENGTH_SHORT).show();
                else {

                    while ((cursor.moveToNext())) {

                        objModalClass.add(new ModalClass(cursor.getInt(0),
                                cursor.getString(1), cursor.getString(2)
                        ));


                    }
                    obAdapterClass = new AdapterClass(objModalClass,HomeScreenActivity.this);
                    objReycyclerView.hasFixedSize();
                    objReycyclerView.setLayoutManager(new LinearLayoutManager(this));
                    objReycyclerView.setAdapter(obAdapterClass);

                }
            } else
                Toast.makeText(this, "Database is null", Toast.LENGTH_SHORT).show();

        }
       catch (Exception e) {
           Toast.makeText(this, "Show message" + e.getMessage(), Toast.LENGTH_SHORT).show();

       }

    }


        }