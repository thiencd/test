package com.example.thuchanh_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_2 extends Fragment {

    TextView txtHienThiNhe;
    public Fragment_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_3, container, false);
        txtHienThiNhe =v.findViewById(R.id.txtketqua);
        Bundle b =this.getArguments();
       String m = b.get("tn").toString();
        txtHienThiNhe.setText(m);


        return v;
    }

}
