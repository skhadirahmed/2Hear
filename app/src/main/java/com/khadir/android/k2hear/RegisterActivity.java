package com.khadir.android.k2hear;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.khadir.android.k2hear.data.UserContract.UserEntry;
import com.khadir.android.k2hear.data.UserDbHelper;

public class RegisterActivity extends AppCompatActivity {

    private Button mRegisterButton;
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;

    private long createUser() {
        ContentValues values = new ContentValues();

        String mUsername = mUsernameEditText.getText().toString().trim();
        String mPassword = mPasswordEditText.getText().toString().trim();

        if (mUsername.isEmpty() || mPassword.isEmpty()) {
            return -2;
        }

        values.put(UserEntry.COLUMN_USERNAME, mUsername);
        values.put(UserEntry.COLUMN_PASSWORD, mPassword);

        UserDbHelper mDbHelper = new UserDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        long newRowId = db.insert(UserEntry.TABLE_NAME, null, values);
        Toast.makeText(this, "Row Id of Entered user is " + newRowId, Toast.LENGTH_LONG).show();

        return newRowId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mRegisterButton = findViewById(R.id.register);
        mUsernameEditText = findViewById(R.id.username_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long i = createUser();
                if (i > 0) {
                    Toast.makeText(RegisterActivity.this, "Succesfully created new user ", Toast.LENGTH_LONG).show();
                    finish();
                } else if (i == -2) {
                    Toast.makeText(RegisterActivity.this, "Username or Password can not be empty ", Toast.LENGTH_LONG).show();
                } else if (i == -1) {
                    Toast.makeText(RegisterActivity.this, "Unable to create a user ", Toast.LENGTH_LONG).show();
                    Log.e("RegisterActivity", "error while inserting new user");
                }
            }
        });
    }
}
