package com.bignerdranch.android.done;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private Firebase mRef;
    private EditText mEditTextName;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private EditText mEditTextRepeatPassword;
    private Button mButtonRegister;
    private String fireBaseUrl;
    private UserTest userNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
    }

    @Override
    protected void onStart() {
        super.onStart();

        mButtonRegister = (Button) findViewById(R.id.buttonRegister);
        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mEditTextPassword = (EditText) findViewById(R.id.editTextPassword);
        mEditTextRepeatPassword = (EditText) findViewById(R.id.editTextRepeatPassword);
        fireBaseUrl = "https://doneaau.firebaseio.com/users/";
        mRef = new Firebase(fireBaseUrl);


        /*mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String text = dataSnapshot.getValue(String.class);
                // mTextFieldCondition.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        */
        //final UserTest test = new UserTest("Just Test", 1995);
        userNew = UserTest.get();

        //final UserTest testTwo = new UserTest(); //test user
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //there shouldn't be any strange symbols here in order to work
                //mRef.child(testTwo.getUserName()).setValue(testTwo);
                //userNew = new User(mEditTextName.getText(), mEditTextPassword.getText(), mEditTextEmail.getText());
                String email = mEditTextEmail.getText().toString();
                String name = mEditTextName.getText().toString();
                String password = mEditTextPassword.getText().toString();
                String repeatPass = mEditTextRepeatPassword.getText().toString();
                if (email.isEmpty() || name.isEmpty() || password.isEmpty() || repeatPass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "There can't be any empty fields!", Toast.LENGTH_LONG).show();
                }
                else if (!password.equals(repeatPass)) {
                    Toast.makeText(getApplicationContext(), "The passwords must match!", Toast.LENGTH_LONG).show();
                }
                else if(!isValidEmail(email)){
                    Toast.makeText(getApplicationContext(), "The email is not valid!", Toast.LENGTH_LONG).show();
                }
                else if(password.length() < 6){
                    Toast.makeText(getApplicationContext(), "This password is too short", Toast.LENGTH_LONG).show();
                }
                else if(password.length() > 12){
                    Toast.makeText(getApplicationContext(), "This password is too long", Toast.LENGTH_LONG).show();
                }
                else {

                    userNew.setEmail(email);
                    userNew.setUserName(name);
                    userNew.setPassword(password);
                    mRef.child(userNew.getUserId()).setValue(userNew);
                    Toast.makeText(getApplicationContext(), "User registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}