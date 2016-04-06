package com.bignerdranch.android.done;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;                 // from support library
import android.view.Menu;
import android.view.MenuItem;

import java.util.UUID;

public class TaskActivity extends SingleFragmentActivity {

    private static final String EXTRA_TASK_ID = "com.bignerdranch.android.done.task_id";

    public static Intent newIntent(Context packageContext, UUID taskID) {      // passing the taskId as an Intent Extra
        Intent intent = new Intent(packageContext, TaskActivity.class);         // for the TaskFragment
        intent.putExtra(EXTRA_TASK_ID, taskID);
        return intent;
    }

    @Override
    protected Fragment createFragment() {               // overrides the abstract method for hosting a specific fragment
        UUID taskId = (UUID) getIntent().getSerializableExtra(EXTRA_TASK_ID);   //  retrieves Task ID from Intent
        return TaskFragment.newInstance(taskId);        // calls the newInstance method to create TaskFragment and pass the ID
    }

}
