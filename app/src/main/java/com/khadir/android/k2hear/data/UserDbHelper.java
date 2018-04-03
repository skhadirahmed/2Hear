package com.khadir.android.k2hear.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.khadir.android.k2hear.data.UserContract.UserEntry;
/**
 * Created by lenovo on 20-Jan-18.
 */

public class UserDbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;

    public UserDbHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USER_TABLE ="CREATE TABLE " + UserEntry.TABLE_NAME + "("
                + UserEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + UserEntry.COLUMN_USERNAME + " TEXT NOT NULL, "
                + UserEntry.COLUMN_PASSWORD + " TEXT NOT NULL )";

        db.execSQL(SQL_CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
