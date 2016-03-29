package com.bignerdranch.android.done;

import java.util.ArrayList;

/**
 * Created by michalisgratsias on 27/03/16.
 */
public class List {

    private String mListName;
    private ArrayList<User> mListUsers;
    private ArrayList<Task> mListTasks;

    public List(String listName) {
        mListName = listName;
        mListUsers = new ArrayList<User>();
        mListTasks = new ArrayList<Task>();
    }

    public List() {
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
