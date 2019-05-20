package com.example.fragmentcommunicationfragment;


import android.app.Activity;
import android.content.Context;
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
public class MessageFragment extends Fragment {

    private Button btn;
    private EditText txtmessage;
    OnMessageSendListener onMessageSendListener;

    public interface OnMessageSendListener{

        public void onMessageRead(String message);
    }


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_message, container, false);

        btn=v.findViewById(R.id.btnsend);
        txtmessage=v.findViewById(R.id.txtmessage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s =txtmessage.getText().toString();
                onMessageSendListener.onMessageRead(s);

            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity =(Activity) context;
        try {
            onMessageSendListener = (OnMessageSendListener) activity;

        } catch(ClassCastException e) {
            throw new ClassCastException(activity.toString()+ "must implement .. ");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        txtmessage.setText("");
    }
}
