package com.example.roomdatabasedemo2;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class User
{
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "user_name")
    private String mane;
    @ColumnInfo(name="user_email")
    private String email;

    public User(int id, String mane, String email) {
        this.id = id;
        this.mane = mane;
        this.email = email;

    }

    public User(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMane() {
        return mane;
    }

    public void setMane(String mane) {
        this.mane = mane;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
