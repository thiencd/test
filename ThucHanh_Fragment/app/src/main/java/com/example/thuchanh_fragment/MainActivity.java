package com.example.thuchanh_fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Fragment_1.XuLyListerner {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hienThiFragment1();
    }

    private void hienThiFragment1() {
        Fragment_1 fragment_1 =new Fragment_1();
        FragmentManager manager =this.getSupportFragmentManager();
        FragmentTransaction transaction =manager.beginTransaction();
        transaction.add(R.id.fragment1,fragment_1,null);
        transaction.commit();
    }

    @Override
    public void xuLyHienThi(String message) {

        Fragment_2 fragmentso2 = new Fragment_2();
        Bundle bundle =new Bundle();
        bundle.putString("tn",message);
        fragmentso2.setArguments(bundle);
        hienThiFragment2();

    }

    private void hienThiFragment2() {
        Fragment_2 fragmentso2 = new Fragment_2();
        FragmentManager manager =this.getSupportFragmentManager();
        FragmentTransaction transaction =manager.beginTransaction();
        transaction.add(R.id.fragment2,fragmentso2,null);
        transaction.commit();
    }
}
