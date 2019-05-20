package com.example.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnDbOpListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (this.findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null)
                return;
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment).commit();

        }

    }

    @Override
    public void dBOpPerformed(int method) {
        switch(method) {
            case 0 :
            AddContact addContact = new AddContact();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, addContact).commit();
        }


    }
}

