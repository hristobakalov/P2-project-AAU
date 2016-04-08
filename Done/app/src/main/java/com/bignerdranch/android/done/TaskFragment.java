package com.bignerdranch.android.done;

import android.os.Bundle;
import android.support.v4.app.Fragment;                 // from support library
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import java.util.UUID;

/**
 * Created by michalisgratsias on 03/04/16.
 */
public class TaskFragment extends Fragment{

    private static final String ARG_TASK_ID = "task_id";
    private static final String ARG_LIST_ID = "list_id";
    private Task mTask;
    private EditText mTitleField;
    private Button mDueDateButton;
    private Button mReminderDateButton;
    private CheckBox mCompletedCheckBox;
    private CheckBox mVerifiedCheckBox;
    // Fragment-Arguments work just like Intent-Extras for an Activity
    public static TaskFragment newInstanceT(UUID taskId, UUID listId) {   // we use a method to create Fragment instead of using Constructor
        Bundle args = new Bundle();                         // creates Bundle for arguments
        args.putSerializable(ARG_TASK_ID, taskId);          // adds task ID to Bundle
        args.putSerializable(ARG_LIST_ID, listId);          // adds list ID to Bundle
        TaskFragment fragment = new TaskFragment();         // creates Fragment instance
        fragment.setArguments(args);                        // sets Arguments
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {       // it is Public because it can be called by various activities hosting it
        super.onCreate(savedInstanceState);
        UUID taskId = (UUID) getArguments().getSerializable(ARG_TASK_ID);   // accessing Fragment arguments for task id
        UUID listId = (UUID) getArguments().getSerializable(ARG_LIST_ID);   //  RETRIEVES List ID from Intent
        mTask = User.get(getActivity()).getList(listId).getTask(taskId);    // using a get method to get Task from ids
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, // here the layout of a fragment's view is inflated
                             Bundle savedInstanceState) {               // view can be re-created from saved state via Bundle data

        View v = inflater.inflate(R.layout.fragment_task, parent, false); // view added to the code of activity, not to view's parent

        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mTitleField.setText(mTask.getTaskName());
        mTitleField.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(
                    CharSequence c, int start, int before, int count) { // CharSequence is user input
                mTask.setTaskName(c.toString());
            }

            public void beforeTextChanged(
                    CharSequence c, int start, int count, int after) {
                // This space intentionally left blank
            }

            public void afterTextChanged(Editable c) {
                // This one too
            }
        });

        mDueDateButton = (Button)v.findViewById(R.id.due_date);
        mDueDateButton.setText(mTask.getDueDate().toString());
        mDueDateButton.setEnabled(false);

        mReminderDateButton = (Button)v.findViewById(R.id.reminder_date);
        mReminderDateButton.setText(mTask.getDueDate().toString());
        mReminderDateButton.setEnabled(false);

        mCompletedCheckBox = (CheckBox)v.findViewById(R.id.task_completed);
        mCompletedCheckBox.setChecked(mTask.isCompleted());
        mCompletedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTask.setCompleted(isChecked);
            }
        });

        mVerifiedCheckBox = (CheckBox)v.findViewById(R.id.task_verified);
        mVerifiedCheckBox.setChecked(mTask.isCompleted());
        mVerifiedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTask.setCompleted(isChecked);
            }
        });

        return v;
    }
}
