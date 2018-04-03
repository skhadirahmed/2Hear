package com.khadir.android.k2hear.data;

import android.provider.BaseColumns;

/**
 * Created by lenovo on 20-Jan-18.
 */

public final class UserContract {

    private UserContract(){}

    public class UserEntry implements BaseColumns{
        public static final String TABLE_NAME="users";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
    }
}
