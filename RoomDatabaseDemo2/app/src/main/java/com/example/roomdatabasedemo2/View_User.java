package com.example.roomdatabasedemo2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class View_User extends Fragment {

    public View view;
    public TextView txtViewUser;

    public View_User() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_view__user, container, false);
        init();
        ViewUser();
        return view;
    }

    private void init()
    {

    }

    private void ViewUser()
    {
        List<User> userList =MainActivity.myAppDatabase.myDAO().getUsers();
        String s="";

        for(User u :userList)
        {

            int id =u.getId();
            String name =u.getMane();
            String email =u.getEmail();
            s+=id+"\t"+name+"\t"+email+"\n\n";

        }
        txtViewUser.setText(s);


    }

}
