package com.khadir.android.k2hear;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.internal.zzdym;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.UserInfo;
import com.khadir.android.k2hear.data.UserContract.UserEntry;
import com.khadir.android.k2hear.data.UserDbHelper;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mLoginButton;
    private Button mRegisterButton;
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;


    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private final int RC_SIGN_IN = 1;

    private boolean validUser() {
        String mUsername = mUsernameEditText.getText().toString().trim();
        String mPassword = mPasswordEditText.getText().toString().trim();

        String username, password;

        UserDbHelper mDbHelper = new UserDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        Cursor cursor = db.query(UserEntry.TABLE_NAME, null, null, null, null, null, null);
        try {
            while (cursor.moveToNext()) {
                username = cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_USERNAME));
                password = cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_PASSWORD));
                if (mUsername.equals(username) && mPassword.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            Log.e("MainActivity", "Error in validUser()", e);
        } finally {
            cursor.close();
        }

//        if(mUsername.equals("khadir") && mPassword.equals("klop9")){
//            return true;
//        }
//        else{
//            return false;
//        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//        SqlScoutServer.create(this, getPackageName());

        //initialize Firebase variables
//        mFirebaseAuth = FirebaseAuth.getInstance();
//
//        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    //user is signed in
//                    Toast.makeText(MainActivity.this, "You are now signed in, Welcome to FriendlyChat!", Toast.LENGTH_SHORT).show();
//                    //onSignedInInitialize(user.getDisplayName());
//                } else {
//                    //user is not signed in
//                    //onSignedOutCleanup();
//                    startActivityForResult(
//                            AuthUI.getInstance()
//                                    .createSignInIntentBuilder()
//                                    .setIsSmartLockEnabled(false)
//                                    .setAvailableProviders(Arrays.asList(
//                                            new AuthUI.IdpConfig.EmailBuilder().build(),
//                                            new AuthUI.IdpConfig.GoogleBuilder().build())
//                                    ).build(), RC_SIGN_IN);
//                }
//            }
//        };

        mLoginButton = findViewById(R.id.login);
        mRegisterButton = findViewById(R.id.register);
        mUsernameEditText = findViewById(R.id.username_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validUser()) {
//                    Intent loginIntent = new Intent(MainActivity.this, MusicActivity.class);
//                    startActivity(loginIntent);
                    Intent mIntent = new Intent(MainActivity.this, MusicMainActivity.class);
                    startActivity(mIntent);
                } else {
                    Toast.makeText(MainActivity.this, "not valid user please Register", Toast.LENGTH_LONG).show();
                }

//                Intent intent = new Intent(MainActivity.this, NavDrawTest.class);
//                startActivity(intent);
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isRememberMe()) {
            SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
            mUsernameEditText.setText(sharedPref.getString("username", ""));
            mPasswordEditText.setText(sharedPref.getString("password", ""));
        } else {
            mUsernameEditText.setText(null);
            mPasswordEditText.setText(null);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
        if (isRememberMe()) {
            SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
            mUsernameEditText.setText(sharedPref.getString("username", ""));
            mPasswordEditText.setText(sharedPref.getString("password", ""));
        } else {
            mUsernameEditText.setText(null);
            mPasswordEditText.setText(null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (mAuthStateListener != null) {
//            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
//        }
    }

    public void rememberMe(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            String mUsername = mUsernameEditText.getText().toString().trim();
            String mPassword = mPasswordEditText.getText().toString().trim();
            SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", mUsername);
            editor.putString("password", mPassword);
            editor.commit();
        }
    }

    public boolean isRememberMe() {
        CheckBox c = (CheckBox) findViewById(R.id.checkBox);
        boolean checked = c.isChecked();
        return checked;
    }

}
