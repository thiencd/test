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
public class Add_User extends Fragment implements View.OnClickListener {

    public EditText txtuserid,txtusername,txtuseremail;
    public Button btnUserSave;
    public View v;
    public String name,email;
    public int id;
    public Add_User() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_add__user, container, false);
        init();
        handleEvent();
        return v;

    }

    private void handleEvent()
    {
        btnUserSave.setOnClickListener(this);
    }

    private void init()
    {
        txtuserid =v.findViewById(R.id.txtuserid);
        txtuseremail=v.findViewById(R.id.txtuseremail);
        txtusername =v.findViewById(R.id.txtusername);
        btnUserSave=v.findViewById(R.id.btnusersave);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnusersave :
                id =Integer.parseInt(txtuserid.getText().toString());
                name =txtusername.getText().toString();
                email =txtuseremail.getText().toString();
                User user = new User(id,name,email);
                MainActivity.myAppDatabase.myDAO().addUser(user);
                Toast.makeText(getActivity(),"Add User Successfully....",Toast.LENGTH_SHORT).show();
                txtusername.setText("");
                txtuseremail.setText("");
                txtuserid.setText("");
                break;

        }
    }
}
