package com.example.roomdatabasedemo2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {User.class},version = 1)
public abstract class MyAppDatabase extends RoomDatabase
{

        public abstract MyDAO myDAO();





}
