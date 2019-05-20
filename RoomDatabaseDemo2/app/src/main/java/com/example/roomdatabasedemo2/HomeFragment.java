package com.example.roomdatabasedemo2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    public Button btnAdd,btnDelete,btnView,btnUpdate;
    public View v;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_home, container, false);
        init();
        xuLuSuKien();
        return v;
    }

    private void xuLuSuKien()
    {
        btnAdd.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    private void init()
    {

        btnAdd =v.findViewById(R.id.btnadduser);
        btnView=v.findViewById(R.id.btnviewuser);
        btnDelete=v.findViewById(R.id.btndeleteuser);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case  R.id.btnadduser :
                FragmentManager fragmentManager =MainActivity.fragmentManager;
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container,new Add_User());
                transaction.addToBackStack(HomeFragment.class.getSimpleName());
                transaction.commit();
                break;
            case R.id.btnviewuser :

                FragmentTransaction transaction1 =MainActivity.fragmentManager.beginTransaction();
                transaction1.replace(R.id.fragment_container,new View_User());
                transaction1.addToBackStack(HomeFragment.class.getSimpleName());
                transaction1.commit();
                break;

            case R.id.btndeleteuser :
                FragmentTransaction transaction2 =MainActivity.fragmentManager.beginTransaction();
                transaction2.replace(R.id.fragment_container,new Delete_User());
                transaction2.addToBackStack(null);
                transaction2.commit();
                break;


        }
    }
}
