package com.bignerdranch.android.done;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;                 // from support library
import android.support.v7.widget.LinearLayoutManager;   // from support library
import android.support.v7.widget.RecyclerView;          // from support library
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by michalisgratsias on 03/04/16.
 */
public class ListTaskFragment extends Fragment{

    private RecyclerView mTaskRecyclerView;         // RecyclerView creates only enough views to fill the screen and scrolls them
    private TaskAdapter mAdapter;                  // Adapter controls the data to be displayed by RecyclerView

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_task, container, false);
        mTaskRecyclerView = (RecyclerView)view.findViewById(R.id.tasks_recycler_view);
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
        List list = List.get(getActivity());
        ArrayList<Task> tasks = list.getListTasks();
        if (mAdapter == null) {
            mAdapter = new TaskAdapter(tasks);
            mTaskRecyclerView.setAdapter(mAdapter);}
        else {mAdapter.notifyDataSetChanged();}
    }

    private class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener { // viewholder class
                                                        // holds reference to the entire view passed to super(view)
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mCompletedCheckBox;
        private Task mTask;

        public TaskHolder(View itemView) {     // constructor - stashes the views
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_task_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_task_due_date_text_view);
            mCompletedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_task_completed_check_box);
        }

        public void bindTask(Task task) {
            mTask = task;
            mTitleTextView.setText(mTask.getTaskName());
            mDateTextView.setText(mTask.getDueDate().toString());
            mCompletedCheckBox.setChecked(mTask.isCompleted());
        }

        @Override
        public void onClick(View v) {
            Intent intent = TaskActivity.newIntent(getActivity(), mTask.getTaskId());
            startActivity(intent);
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {  // adapter class
                                                    // creates needed viewholders, binds them to the data
        private ArrayList<Task> mTasks;

        public TaskAdapter(ArrayList<Task> tasks) {        // constructor
            mTasks = tasks;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {              // needs new view
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.tasks_item, parent, false);         // creates view
            return new TaskHolder(view);                                                   // wraps it in a viewholder
        }

        @Override
        public void onBindViewHolder(TaskHolder holder, int position) { // binds viewholder's view to a model object
            Task task = mTasks.get(position);
            holder.bindTask(task);
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }

}
