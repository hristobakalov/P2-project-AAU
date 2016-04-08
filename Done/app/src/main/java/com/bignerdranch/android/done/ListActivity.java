package com.bignerdranch.android.done;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;                 // from support library
import android.support.v7.widget.Toolbar;

import java.util.UUID;

/**
 * Created by michalisgratsias on 03/04/16.
 */
public class ListActivity extends SingleFragmentActivity {

    private static final String EXTRA_LIST_ID = "com.bignerdranch.android.done.list_id";

    public static Intent newIntent(Context packageContext, UUID listID) {      // PASSES the listId as an Intent Extra
        Intent intent = new Intent(packageContext, ListActivity.class);         // for the ListFragment
        intent.putExtra(EXTRA_LIST_ID, listID);
        return intent;
    }


    @Override
    protected Fragment createFragment() {
        UUID listId = (UUID) getIntent().getSerializableExtra(EXTRA_LIST_ID);
        return ListTaskFragment.newInstance(listId);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // attaching layout to the Toolbar object
        UUID listId = (UUID) getIntent().getSerializableExtra(EXTRA_LIST_ID);
        toolbar.setTitle(User.get(this).getList(listId).getListName());
    }
}
