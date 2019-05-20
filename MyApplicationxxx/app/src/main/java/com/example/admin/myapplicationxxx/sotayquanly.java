package com.example.admin.myapplicationxxx;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sotayquanly extends AppCompatActivity implements View.OnClickListener {

    private static Button btnThu, btnChi,btnThongKe;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThu = this.findViewById(R.id.btn_tienthu);
        btnChi = this.findViewById(R.id.btn_tienchi);
        btnThongKe=this.findViewById(R.id.btnThongKe);

        btnChi.setOnClickListener(this);
        btnThu.setOnClickListener(this);
        btnThongKe.setOnClickListener(this);

        }

    // bắt sự kiện cho button
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tienchi:
            xuLyChi();
            break;

            case R.id.btn_tienthu :
            xuLyThu();
            break;

        }
    }

    private void xuLyThu() {
        Intent t =new Intent(this,Activity_Thu.class);
        this.startActivity(t);
    }

    private void xuLyChi() {
        Intent t =new Intent(this,Activity_Chi.class);
        this.startActivity(t);
    }



}










