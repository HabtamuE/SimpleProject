package com.beginner.userinformationmanagmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button login,register;
    DatabaseHelper db;
    private  SharedPreference sharedPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        db=new DatabaseHelper(this);
        sharedPreference=new SharedPreference(this);
        username=(EditText) findViewById(R.id.idusername);
        password=(EditText) findViewById(R.id.idpassword);
        register=(Button) findViewById(R.id.btnregister);
        login=(Button) findViewById(R.id.btnlogin);

        if(sharedPreference.loggedIn()){
            Intent inty=new Intent(LoginActivity.this,HomeScreenActivity.class);

startActivity(inty);


        }





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username_value=username.getText().toString();
                String password_value=password.getText().toString();

                if(db.isLoginValid(username_value,password_value))
               {
                   sharedPreference.setLoggedIn(true);
                    Intent itnt=new Intent(LoginActivity.this, HomeScreenActivity.class);
                    startActivity(itnt);
                    Toast.makeText(LoginActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                }
                else
                Toast.makeText(LoginActivity.this,"password and username is incorrect",Toast.LENGTH_SHORT).show();

            }
        });
register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);

    }
});



}
}