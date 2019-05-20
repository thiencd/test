package com.example.recycleview_test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewContactAdapter extends RecyclerView.Adapter<RecyclerViewContactAdapter.ViewHolderContact> {
    @NonNull

    private List<Contact> listContact;

    public RecyclerViewContactAdapter(@NonNull List<Contact> contact) {
        this.listContact = contact;
    }

    @Override
     public ViewHolderContact onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        Context context = parent.getContext();
        LayoutInflater inflater =LayoutInflater.from(context);
        View contactView =inflater.inflate(R.layout.layout_recyclerview,parent,false);
        ViewHolderContact viewHolder =new ViewHolderContact(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderContact viewHolder, int i)
    {
        Contact contact =listContact.get(i);
        TextView textView =viewHolder.txtName;
        textView.setText(contact.getmName());
        Button button =viewHolder.messageButton;


    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    public class ViewHolderContact extends RecyclerView.ViewHolder {

        public TextView txtName;
        public Button messageButton;

        public ViewHolderContact(@NonNull View itemView) {
            super(itemView);
            txtName= itemView.findViewById(R.id.txtcontact_name);
            messageButton =itemView.findViewById(R.id.btnmessage);
        }
    }
}
