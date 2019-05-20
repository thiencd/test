package com.example.sharedpreferencesdemo;

import android.content.Context;

public class SharedPreferences_LogIn {

    private SharedPreferences_LogIn preferences_logIn;
    private Context context;

    public SharedPreferences_LogIn(Context con) {
        this.context =con;
        preferences_logIn = con.getSharedPreferences()
    }
}
