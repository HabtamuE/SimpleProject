package com.beginner.userinformationmanagmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.beginner.userinformationmanagmentapp.RecyclerViewClasses.ModalClass;

public class DetailActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7;
    Button showit,backit;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        backit=findViewById(R.id.back);
        t1=findViewById(R.id.fn);
        t2=findViewById(R.id.ln);
        t3=findViewById(R.id.us);
        t4=findViewById(R.id.pss);
        t5=findViewById(R.id.eml);
        t6=findViewById(R.id.phone);
        t7=findViewById(R.id.sex);

        ModalClass model=( ModalClass) getIntent().getSerializableExtra("myapp");
        if(model!=null){
            t1.setText(model.getFirstname());
            t2.setText(model.getLastname());
            t3.setText(model.getUsername());
            t4.setText(model.getPassword());
            t5.setText(model.getEmail());
            t6.setText(model.getPhone());
            t7.setText(model.getGender());


        }



    }
}
