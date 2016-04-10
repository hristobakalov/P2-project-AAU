package com.bignerdranch.android.done;

import android.os.Bundle;
import android.support.v4.app.Fragment;                 // from support library
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

    private static final String TAG = "DoneActivity";
    private static final String ARG_TASK_ID = "task_id";
    private static final String ARG_LIST_ID = "list_id";
    private Task mTask;
    private Task[] taskfrags = new Task[9];

    // Fragment-Arguments work just like Intent-Extras for an Activity
    public static TaskFragment newInstance(UUID taskId, UUID listId) {   // we use a method to create Fragment instead of using Constructor
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

    private RecyclerView mTaskRecyclerView;         // RecyclerView creates only enough views to fill the screen and scrolls them
    private TaskAdapter mAdapter;                  // Adapter controls the data to be displayed by RecyclerView

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        mTaskRecyclerView = (RecyclerView)view.findViewById(R.id.single_task_recycler_view);
        mTaskRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));    // handles the
        updateUI();     // sets up the UI                     // positioning of items and defines the scrolling behaviour
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        for (int i = 0; i<taskfrags.length; i++) {taskfrags[i] = mTask;}
        if (mAdapter == null) {
            mAdapter = new TaskAdapter(taskfrags);
            mTaskRecyclerView.setAdapter(mAdapter);}
        else {mAdapter.notifyDataSetChanged();}
    }

    private class TaskHolder0 extends RecyclerView.ViewHolder {  // viewholder class holds reference to the entire view passed to super(view)

        private EditText mTitleField;

        public TaskHolder0(View itemView) {     // constructor - stashes the views
            super(itemView);
            mTitleField = (EditText) itemView.findViewById(R.id.task_title);
        }

        public void bindTask(Task task) {
            mTask = task;
            mTitleField.setText(mTask.getTaskName());
            mTitleField.addTextChangedListener(new TextWatcher() {
                public void onTextChanged(CharSequence c, int start, int before, int count) { // CharSequence is user input
                    mTask.setTaskName(c.toString());
                }

                public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                    // This space intentionally left blank
                }

                public void afterTextChanged(Editable c) {
                    // This one too
                }
            });
        }
    }

    private class TaskHolder1 extends RecyclerView.ViewHolder {  // viewholder class holds reference to the entire view passed to super(view)

        private Button mAssignedTo;

        public TaskHolder1(View itemView) {     // constructor - stashes the views
            super(itemView);
            mAssignedTo = (Button) itemView.findViewById(R.id.assigned_to);
        }

        public void bindTask(Task task) {
            mTask = task;
            mAssignedTo.setText("None");
            mAssignedTo.setEnabled(false);
        }
    }

    private class TaskHolder2 extends RecyclerView.ViewHolder {  // viewholder class holds reference to the entire view passed to super(view)

        private Button mHiddenFrom;

        public TaskHolder2(View itemView) {     // constructor - stashes the views
            super(itemView);
            mHiddenFrom = (Button) itemView.findViewById(R.id.hidden_from);
        }

        public void bindTask(Task task) {
            mTask = task;
            mHiddenFrom.setText("None");
            mHiddenFrom.setEnabled(false);
        }
    }

    private class TaskHolder3 extends RecyclerView.ViewHolder {  // viewholder class holds reference to the entire view passed to super(view)

        private Button mDueDateButton;

        public TaskHolder3(View itemView) {     // constructor - stashes the views
            super(itemView);
            mDueDateButton = (Button) itemView.findViewById(R.id.due_date);
        }

        public void bindTask(Task task) {
            mTask = task;
            mDueDateButton.setText(mTask.getDueDate().toString());
            mDueDateButton.setEnabled(false);
        }
    }

    private class TaskHolder4 extends RecyclerView.ViewHolder {  // viewholder class holds reference to the entire view passed to super(view)

        private Button mReminderDateButton;

        public TaskHolder4(View itemView) {     // constructor - stashes the views
            super(itemView);
            mReminderDateButton = (Button) itemView.findViewById(R.id.reminder_date);
        }

        public void bindTask(Task task) {
            mTask = task;
            mReminderDateButton.setText(mTask.getDueDate().toString());
            mReminderDateButton.setEnabled(false);
        }
    }

    private class TaskHolder5 extends RecyclerView.ViewHolder {  // viewholder class holds reference to the entire view passed to super(view)

        private Button mAddNote;

        public TaskHolder5(View itemView) {     // constructor - stashes the views
            super(itemView);
            mAddNote = (Button) itemView.findViewById(R.id.add_note);
        }

        public void bindTask(Task task) {
            mTask = task;
            mAddNote.setText("None"); mAddNote.setEnabled(false);
        }
    }

    private class TaskHolder6 extends RecyclerView.ViewHolder {  // viewholder class holds reference to the entire view passed to super(view)

        private Button mAddPhoto;

        public TaskHolder6(View itemView) {     // constructor - stashes the views
            super(itemView);
            mAddPhoto = (Button) itemView.findViewById(R.id.add_photo);
        }

        public void bindTask(Task task) {
            mTask = task;
            mAddPhoto.setText("None");
            mAddPhoto.setEnabled(false);
        }
    }

    private class TaskHolder7 extends RecyclerView.ViewHolder {  // viewholder class holds reference to the entire view passed to super(view)

        private CheckBox mCompletedCheckBox;

        public TaskHolder7(View itemView) {     // constructor - stashes the views
            super(itemView);
            mCompletedCheckBox = (CheckBox) itemView.findViewById(R.id.task_completed);
        }

        public void bindTask(Task task) {
            mTask = task;
            mCompletedCheckBox.setChecked(mTask.isCompleted());
            mCompletedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mTask.setCompleted(isChecked);
                }
            });
        }
    }

    private class TaskHolder8 extends RecyclerView.ViewHolder {  // viewholder class holds reference to the entire view passed to super(view)

        private CheckBox mVerifiedCheckBox;

        public TaskHolder8(View itemView) {     // constructor - stashes the views
            super(itemView);
            mVerifiedCheckBox = (CheckBox) itemView.findViewById(R.id.task_verified);
        }

        public void bindTask(Task task) {
            mTask = task;
            mVerifiedCheckBox.setChecked(mTask.isCompleted());
            mVerifiedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mTask.setCompleted(isChecked);
                }
            });
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {  // adapter class
        // creates needed viewholders, binds them to the data
        private Task[] mTasks;

        public TaskAdapter(Task[] taskfrags) {        // constructor
            mTasks = taskfrags;
        }

        @Override
        public int getItemViewType(int position){
            return position;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {              // needs new view
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            switch (viewType) {
                case 0: {View view = layoutInflater.inflate(R.layout.detailed_task_item_0, parent, false); return new TaskHolder0(view);}
                case 1: {View view = layoutInflater.inflate(R.layout.detailed_task_item_1, parent, false); return new TaskHolder1(view);}
                case 2: {View view = layoutInflater.inflate(R.layout.detailed_task_item_2, parent, false); return new TaskHolder2(view);}
                case 3: {View view = layoutInflater.inflate(R.layout.detailed_task_item_3, parent, false); return new TaskHolder3(view);}
                case 4: {View view = layoutInflater.inflate(R.layout.detailed_task_item_4, parent, false); return new TaskHolder4(view);}
                case 5: {View view = layoutInflater.inflate(R.layout.detailed_task_item_5, parent, false); return new TaskHolder5(view);}
                case 6: {View view = layoutInflater.inflate(R.layout.detailed_task_item_6, parent, false); return new TaskHolder6(view);}
                case 7: {View view = layoutInflater.inflate(R.layout.detailed_task_item_7, parent, false); return new TaskHolder7(view);}
                case 8: {View view = layoutInflater.inflate(R.layout.detailed_task_item_8, parent, false); return new TaskHolder8(view);}
                default: return new TaskHolder0(layoutInflater.inflate(R.layout.detailed_task_item_0, parent, false));
            }
            // creates view and wraps it in a viewholder
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) { // binds viewholder's view to a model object
            Task task = mTasks[position];
            switch (getItemViewType(position)){
                case 0: TaskHolder0 h0 = (TaskHolder0)holder; h0.bindTask(task); break;
                case 1: TaskHolder1 h1 = (TaskHolder1)holder; h1.bindTask(task); break;
                case 2: TaskHolder2 h2 = (TaskHolder2)holder; h2.bindTask(task); break;
                case 3: TaskHolder3 h3 = (TaskHolder3)holder; h3.bindTask(task); break;
                case 4: TaskHolder4 h4 = (TaskHolder4)holder; h4.bindTask(task); break;
                case 5: TaskHolder5 h5 = (TaskHolder5)holder; h5.bindTask(task); break;
                case 6: TaskHolder6 h6 = (TaskHolder6)holder; h6.bindTask(task); break;
                case 7: TaskHolder7 h7 = (TaskHolder7)holder; h7.bindTask(task); break;
                case 8: TaskHolder8 h8 = (TaskHolder8)holder; h8.bindTask(task); break;
            }
        }

        @Override
        public int getItemCount() {
            return mTasks.length;
        }
    }
}



