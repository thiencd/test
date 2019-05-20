package com.example.fragmentcommunicationfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null) {

            if(savedInstanceState!=null){
                return;
            }

            MessageFragment messageFragment = new MessageFragment();

            FragmentManager fragmentManager =this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container,messageFragment,null);
            fragmentTransaction.commit();


        }
    }

    @Override
    public void onMessageRead(String message) {
        DisplayFregment displayFregment = new DisplayFregment();
        Bundle bundle = new Bundle();
        bundle.putString("message",message);
        displayFregment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,displayFregment,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
