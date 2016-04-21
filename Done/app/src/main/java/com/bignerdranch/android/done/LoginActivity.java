package com.bignerdranch.android.done;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    Firebase mRef;
    EditText mEditTextName;
    EditText mEditTextEmail;
    EditText mEditTextPassword;
    EditText mEditTextRepeatPassword;
    Button mButtonRegister;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //mEditTextName = (EditText) findViewById(R.id.editTextName);
       // mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
       // mEditTextPassword = (EditText) findViewById(R.id.editTextPassword);
       // mEditTextRepeatPassword = (EditText) findViewById(R.id.editTextRepeatPassword);
       // mButtonRegister = (Button) findViewById(R.id.buttonRegister);

        mRef = new Firebase("https://doneaau.firebaseio.com/");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String text = dataSnapshot.getValue(String.class);
                // mTextFieldCondition.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        //final UserTest test = new UserTest("Just Test", 1995);
        /*final User userOne = User.get(this);
        final UserTest testTwo = new UserTest();
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mRef.child("users").setValue(userOne.getEmail());
                //mRef.child("users").child(userOne.getEmail()).setValue(userOne.getUserName());
                // mRef.child("users").child("mEditTextEmail").setValue(mEditTextName.getText());
                // mRef.child("users").child("mEditTextEmail").setValue(mEditTextPassword.getText());
                // mRef.child("users").child("mEditTextEmail").setValue(mEditTextRepeatPassword.getText());
                //mRef.child("users").push().setValue(testTwo); //WORKSSS!!!
                Firebase newRef = new Firebase("https://doneaau.firebaseio.com/users");
                mRef.child("users").child(testTwo.getEmail()).setValue(testTwo);
                //mRef.child("users").child("johnDD@cvb.com").setValue(testTwo);
                //mRef.child("users").child(testTwo.getEmail()).setValue(testTwo);
            }
        });
*/

    }
}
