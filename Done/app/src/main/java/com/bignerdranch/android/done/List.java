package com.bignerdranch.android.done;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by michalisgratsias on 27/03/16.
 */
public class List {

    private UUID mListId;
    private String mListName;
    private ArrayList<User> mListUsers; // not needed
    private ArrayList<Task> mListTasks;
    private static List sList;
    private Context mAppContext;

    public List(Context appContext) {
        mAppContext = appContext;
        mListId = UUID.randomUUID();
        mListUsers = new ArrayList<User>(); //not needed
        mListTasks = new ArrayList<Task>();
        for (int i = 0; i < 25; i++) {
            Task t = new Task();
            t.setTaskName("Task # " + i);
            t.setCompleted(i % 2 == 0); // Every other one
            mListTasks.add(t);
        }
    }

    public List() {
    }

    public static List get(Context c) {                     // creates list as a Singleton= only 1 object possible
        if (sList == null) {
            sList = new List(c.getApplicationContext());    // AppContext gives longer lifetime than Activities
        }
        return sList;
    }

    public ArrayList<Task> getListTasks() {
        return mListTasks;
    }

    public Task getTask(UUID id) {
        for (Task t : mListTasks) {
            if (t.getTaskId().equals(id))
                return t;
        }
        return null;
    }

    public UUID getListId() {
        return mListId;
    }

    public String getListName() {
        return mListName;
    }

    public void setListName(String listName) {
        mListName = listName;
    }

    public void addListUser(String mUserName) {
        // to be implemented
    }

    public void removeListUser(String mUserName) {
        // to be implemented
    }

    public void addListTask(String mTaskName) {
        // to be implemented
    }

    public void removeListTask(String mTaskName) {
        // to be implemented
    }
}
