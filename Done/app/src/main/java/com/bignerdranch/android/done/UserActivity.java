package com.bignerdranch.android.done;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;                     // from support library
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

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
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("My " + User.get().getUserLists().size() + " To-Do Lists");
    }

    @Override
    public void onResume() {
        super.onResume();
        getSupportActionBar().setTitle("My " + User.get().getUserLists().size() + " To-Do Lists");
    }

    @Override
    protected void onStart() {
        super.onStart();
        currUser = User.get();
        Firebase mRefLists = new Firebase("https://doneaau.firebaseio.com/lists/");
        mRefLists.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {

                //Object snapShot = snapshot.getValue();
                //com.bignerdranch.android.done.List currList = new com.bignerdranch.android.done.List(snapshot.child("creatorId").getValue().toString());
                //currList.setListName(snapshot.child("listName").getValue().toString());
                //currList.setListId(snapshot.child("listId").getValue().toString());
               // snapshot.child("tasks").getValue(DataBaseTasks.class);
                DataBaseLists list = snapshot.getValue(DataBaseLists.class);
                mUserLists.add(list);
                System.out.println(list.getListName());
                //System.out.println(user.getEmail());
                //userList.add(user);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
        Firebase mRefTasks = new Firebase("https://doneaau.firebaseio.com/tasks/");
        mRefTasks.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {

                //Object snapShot = snapshot.getValue();
                //com.bignerdranch.android.done.List currList = new com.bignerdranch.android.done.List(snapshot.child("creatorId").getValue().toString());
                //currList.setListName(snapshot.child("listName").getValue().toString());
                //currList.setListId(snapshot.child("listId").getValue().toString());
                // snapshot.child("tasks").getValue(DataBaseTasks.class);
                DataBaseTasks task = snapshot.getValue(DataBaseTasks.class);
                mUserTasks.add(task);
                System.out.println(task.getTaskName());
                //System.out.println(user.getEmail());
                //userList.add(user);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }
}


