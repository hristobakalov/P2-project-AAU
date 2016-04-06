package com.bignerdranch.android.done;

import android.support.v4.app.Fragment;                     // from support library


/**
 * Created by michalisgratsias on 03/04/16.
 */
public class UserActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new UserListFragment();
    }

}


