package com.example.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setUpRecycleview();
    }



    private void init()
    {
        recyclerView=this.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
    }

    private void setUpRecycleview()
    {
        recyclerView.setLayoutManager(layoutManager);
    }
}
