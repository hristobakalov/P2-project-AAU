package com.bignerdranch.android.done;

import android.os.Bundle;
import android.support.v4.app.Fragment;                     // from support library
import android.support.v7.widget.Toolbar;


/**
 * Created by michalisgratsias on 03/04/16.
 */
public class UserActivity extends ActivityParent {

    @Override
    protected Fragment createFragment() {
        return new UserListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // attaching layout to the Toolbar object
        toolbar.setTitle("My To-Do Lists");
    }
}


