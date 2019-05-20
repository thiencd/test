package com.example.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
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
public class AddContact extends Fragment {

     public Button btnSave;
     public EditText txtId,txtName,txtEmail;


    public AddContact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_add_contact, container, false);
        btnSave =v.findViewById(R.id.btnsavecontact);
        txtId=v.findViewById(R.id.txtid);
        txtName=v.findViewById(R.id.txtname);
        txtEmail =v.findViewById(R.id.txtEmail);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id =txtId.getText().toString();
                String name =txtName.getText().toString();
                String email =txtEmail.getText().toString();
                ContactDbHelper dbHelper =new ContactDbHelper(getActivity() );
                SQLiteDatabase database =dbHelper.getWritableDatabase();
                dbHelper.addContact(id,name,email,database);
                dbHelper.close();
                txtId.setText("");
                txtEmail.setText("");
                txtName.setText("");
                Toast.makeText(getActivity(),"Add COntact Success ....", Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }



}
