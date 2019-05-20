package com.example.thuchanh_fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_1 extends Fragment {

    private EditText txtNhapTenCauThu;
    private Button btnSend;
    private XuLyListerner listerner;


    public Fragment_1() {
        // Required empty public constructor
    }

    public interface XuLyListerner {

        public void xuLyHienThi(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_1, container, false);
        txtNhapTenCauThu = v.findViewById(R.id.txtnhaptencauthu);
        btnSend = v.findViewById(R.id.btnsend);
        String message =txtNhapTenCauThu.getText().toString();
        listerner.xuLyHienThi(message);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        txtNhapTenCauThu.setText("");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        try {
            listerner = (XuLyListerner) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }
    }

}
