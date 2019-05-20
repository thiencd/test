package com.example.admin.quanlynhanvien;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    public TextView txtDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDangKy=this.findViewById(R.id.txtDangKy);
    }


    @Override
    public void onClick(View v) {
        int id =v.getId();
        switch(id) {
            case R.id.txtDangKy : xuLyDangKy();
        }
    }

    private void xuLyDangKy() {
        Dialog log =new Dialog(this);
        log.setContentView(R.layout.layout_dangki);
        log.setTitle("Xử Lý Đăng Ký");
        log.show();
    }
}



