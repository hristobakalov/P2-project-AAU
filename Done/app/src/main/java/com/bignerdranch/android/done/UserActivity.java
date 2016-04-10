package com.bignerdranch.android.done;

import android.os.Bundle;
import android.support.v4.app.Fragment;                     // from support library
import android.support.v7.widget.Toolbar;


/**
 * Created by michalisgratsias on 03/04/16.
 */
<<<<<<< HEAD
public class UserActivity extends ActivityParent {
=======
public class UserActivity extends SingleFragmentActivity {
>>>>>>> refs/remotes/origin/master

    @Override
    protected Fragment createFragment() {
        return new UserListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // attaching layout to the Toolbar object
<<<<<<< HEAD
        toolbar.setTitle("My " + User.get(getApplicationContext()).getUserLists().size() + " To-Do Lists");
=======
        toolbar.setTitle("My Lists");
>>>>>>> refs/remotes/origin/master
    }
}


