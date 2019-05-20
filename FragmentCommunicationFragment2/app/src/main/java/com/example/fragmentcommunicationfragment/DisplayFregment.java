package com.example.fragmentcommunicationfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class  DisplayFregment extends Fragment {


    private TextView txtview;
    public DisplayFregment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_display_fregment, container, false);
        txtview= v.findViewById(R.id.txtmessageappearhere);
        Bundle bundle =this.getArguments();
        String mess = bundle.get("message").toString();
        txtview.setText(mess);

        return v;
    }

}
