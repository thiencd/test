package com.example.roomdatabasedemo2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Delete_User extends Fragment implements View.OnClickListener {

    public Button btnDeleteUser;
    public View view;
    public EditText txtUserId;

    public Delete_User() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =inflater.inflate(R.layout.fragment_delete__user, container, false);
        init();
        handleEvent();
        return view;
    }

    private void init()
    {
        btnDeleteUser = view.findViewById(R.id.btndeleteuser);
        txtUserId =view.findViewById(R.id.txtdeleteid);
    }

    private void handleEvent()
    {
        btnDeleteUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        int id =Integer.parseInt(txtUserId.getText().toString());
        User u = new User();
        u.setId(id);
        MainActivity.myAppDatabase.myDAO().deleteUser(u);
        Toast.makeText(getActivity(),"Delete finish...", Toast.LENGTH_SHORT).show();

    }
}
