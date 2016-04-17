package com.bignerdranch.android.done;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by michalisgratsias on 27/03/16.
 */
public class List {

    private UUID mListId;
    private UUID mUserId;
    private String mListName;
    private ArrayList<UUID> mListUsers;
    private ArrayList<Task> mListTasks;

    public List(UUID userId) {
        mListId = UUID.randomUUID();
        mListUsers = new ArrayList<UUID>();                                 // the Users of the list
        mListUsers.add(userId);
        mListTasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getListTasks() {                                 // get all List Tasks
        return mListTasks;
    }

    public Task getTask(UUID id) {                                          // get a List Task by ID
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

    public ArrayList<UUID> getListUsers() {
        return mListUsers;
    }

    public void addListUser(UUID id) {
        mListUsers.add(id);
    }

    public void removeListUser(UUID id) {
        mListUsers.remove(id);
    }

    public void addListTask(Task task) {
        mListTasks.add(task);
    }

    public void removeListTask(Task task) {
        mListTasks.remove(task);
    }
}
