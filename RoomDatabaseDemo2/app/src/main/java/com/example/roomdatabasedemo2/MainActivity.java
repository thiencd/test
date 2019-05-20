package com.example.roomdatabasedemo2;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;
    public Button btnAdd,btnView,btnDelete,btnUpdate;
    public View_User view_user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getInstanceDatabase();

        //clickListener();
        fragmentManager=getSupportFragmentManager();

        if(this.findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null) return;
            fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
        }

    }

    private void getInstanceDatabase()
    {
        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();
    }

    public void init()
    {
        btnAdd =findViewById(R.id.btnadduser);

    }

    /*public void clickListener()
    {
        btnAdd.setOnClickListener(this);
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnadduser :
                fragmentManager.beginTransaction().replace(R.id.fragment_container,new Add_User()).commit();break;
            case R.id.btnviewuser :
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container,view_user).commit();
                break;


        }
    }
}
