package com.bignerdranch.android.done;

import android.os.Bundle;
import android.support.v4.app.Fragment;                     // from support library
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
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
        getSupportActionBar().setTitle("My " + User.get(getApplicationContext()).getUserLists().size() + " To-Do Lists");
    }

    @Override
    public void onResume() {
        super.onResume();
        getSupportActionBar().setTitle("My " + User.get(getApplicationContext()).getUserLists().size() + " To-Do Lists");
    }
}


