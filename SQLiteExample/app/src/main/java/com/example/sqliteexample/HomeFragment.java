package com.example.sqliteexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements OnClickListener {

    public Button btnAdd,btnDelete,btnView,btnUpdate;
    public OnDbOpListener listener;


    public HomeFragment() {
        // Required empty public constructor
    }


    public interface OnDbOpListener
    {
        public void dBOpPerformed(int method);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_home, container, false);
        btnAdd = view.findViewById(R.id.btnadd);
        btnAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity =(Activity) context;
        listener =(OnDbOpListener) activity;

    }
    @Override
    public void onClick(View v) {
        int id =v.getId();
        switch (id)
        {
            case R.id.btnadd :listener.dBOpPerformed(0);
        }
    }

}
