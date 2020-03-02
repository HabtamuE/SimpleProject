package com.beginner.userinformationmanagmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText firstname, lastname, username, password, phone, email;
    Button register, back;
    RadioGroup gender;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        firstname = (EditText) findViewById(R.id.idfirstname);
        lastname = (EditText) findViewById(R.id.idlastname);
        username = (EditText) findViewById(R.id.idusername);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.idemail);
        phone = (EditText) findViewById(R.id.idphone);
        gender = (RadioGroup) findViewById(R.id.gender);
        register = (Button) findViewById(R.id.btnregister);
        back = (Button) findViewById(R.id.btnbacktologin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname_value = firstname.getText().toString();
                String lastname_value = lastname.getText().toString();
                String username_value = username.getText().toString();
                String password_value = password.getText().toString();
                String email_value = email.getText().toString();
                String phoneNumber_value = password.getText().toString();
                RadioButton checked_value = findViewById(gender.getCheckedRadioButtonId());
                String gender_value = checked_value.getText().toString();
                if (firstname_value.equals("") || lastname_value.equals("") || username_value.equals("") || password_value.equals("") || email_value.equals("") || phoneNumber_value.equals("") || gender_value.equals("") ) {
                    Toast.makeText(RegisterActivity.this, "all fields must be fieled", Toast.LENGTH_SHORT).show();

                } else {
                    boolean isInserted=db.insertUser(firstname_value,lastname_value,username_value,password_value,email_value,phoneNumber_value,gender_value);
                    if(isInserted==true) {

                        Toast.makeText(RegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent itn=new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(itn);
    }
});

    }

}