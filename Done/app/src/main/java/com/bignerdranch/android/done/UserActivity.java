package com.bignerdranch.android.done;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;                     // from support library
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.*;
import java.util.List;


/**
 * Created by michalisgratsias on 03/04/16.
 */
public class UserActivity extends ActivityParent {
    User currUser;
    ArrayList<DataBaseLists> mUserLists = new ArrayList<>();
    ArrayList<DataBaseTasks> mUserTasks = new ArrayList<>();
    @Override
    protected Fragment createFragment() {
        return new UserListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Intent databaseService = new Intent(this, FireBaseDataRetrieve.class); //HERE WE START THE SERVICE WHICH PULLS DATA!!!
        startService(databaseService);
        Toast.makeText(getApplicationContext(), "on Create", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("My To-Do Lists (" + User.get().getUserLists().size() + ")");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "on Resume", Toast.LENGTH_SHORT).show();
        getSupportActionBar().setTitle("My To-Do Lists (" + User.get().getUserLists().size() + ")");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "on Start", Toast.LENGTH_SHORT).show();

    }
}


