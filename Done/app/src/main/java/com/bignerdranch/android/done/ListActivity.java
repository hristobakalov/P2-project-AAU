package com.bignerdranch.android.done;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;                 // from support library

import java.util.UUID;

/**
 * Created by michalisgratsias on 03/04/16.
 */
public class ListActivity extends SingleFragmentActivity {

    private static final String EXTRA_LIST_ID = "com.bignerdranch.android.done.list_id";

    public static Intent newIntent(Context packageContext, UUID listID) {      // passing the taskId as an Intent Extra
        Intent intent = new Intent(packageContext, ListActivity.class);         // for the TaskFragment
        intent.putExtra(EXTRA_LIST_ID, listID);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new ListTaskFragment();
    }

}
