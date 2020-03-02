package com.beginner.userinformationmanagmentapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    SharedPreferences sharedPreference;
    SharedPreferences.Editor editor;
    Context context;



    public SharedPreference(Context ctx){
        this.context=ctx;
        sharedPreference=ctx.getSharedPreferences("MyApp",Context.MODE_PRIVATE);
        editor=sharedPreference.edit();


    }


    public void setLoggedIn(boolean loggedIn){

        editor.putBoolean("loggedInMode",loggedIn);
        editor.commit();
    }

public boolean loggedIn(){
        return  sharedPreference.getBoolean("loggedInMode",false);
}



}
