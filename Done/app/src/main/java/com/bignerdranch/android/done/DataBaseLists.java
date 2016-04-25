package com.bignerdranch.android.done;

import java.util.ArrayList;

/**
 * Created by michalisgratsias on 25/04/16.
 */
public class DataBaseLists {

    private String mListId;
    private String CreatorId;
    private String mListName;
    private ArrayList<String> mListUsers;
    private ArrayList<DataBaseTasks> mListTasks;

    DataBaseLists () {
    }

    public String getListId() {
        return mListId;
    }

    public void setListId(String listId) {
        mListId = listId;
    }

    public String getCreatorId() {
        return CreatorId;
    }

    public void setCreatorId(String creatorId) {
        CreatorId = creatorId;
    }

    public String getListName() {
        return mListName;
    }

    public void setListName(String listName) {
        mListName = listName;
    }

    public ArrayList<String> getListUsers() {
        return mListUsers;
    }

    public void addListUser(String id) {
        mListUsers.add(id);
    }

    public void removeListUser(String id) {
        mListUsers.remove(id);
    }

    public void addListTask(DataBaseTasks task) {
        mListTasks.add(task);
    }

    public void removeListTask(DataBaseTasks task) {
        mListTasks.remove(task);
    }
}
