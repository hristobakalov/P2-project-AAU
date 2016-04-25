package com.bignerdranch.android.done;

import java.util.ArrayList;

/**
 * Created by michalisgratsias on 26/04/16.
 */
public class DataBaseTasks {

    private String mTaskId;
    private String mListId;
    private String mCreatedDate;
    private String mTaskName;
    private ArrayList<String> mAssignees;
    private ArrayList<String> mViewers;
    private String mDueDate;
    private String mReminderDate;
    private ArrayList<String> mNotes;
    private ArrayList<String> mPhotos;
    private boolean mCompleted;
    private boolean mVerified;

    DataBaseTasks () {
    }

    public String getTaskId() {
        return mTaskId;
    }

    public void setTaskId(String taskId) {
        mTaskId = taskId;
    }

    public String getListId() {
        return mListId;
    }

    public void setListId(String listId) {
        mListId = listId;
    }

    public String getCreatedDate() {
        return mCreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        mCreatedDate = createdDate;
    }

    public String getTaskName() {
        return mTaskName;
    }

    public void setTaskName(String taskName) {
        mTaskName = taskName;
    }

    public ArrayList<String> getAssignees() {
        return mAssignees;
    }

    public void setAssignees(ArrayList<String> assignees) {
        mAssignees = assignees;
    }

    public ArrayList<String> getViewers() {
        return mViewers;
    }

    public void setViewers(ArrayList<String> viewers) {
        mViewers = viewers;
    }

    public String getDueDate() {
        return mDueDate;
    }

    public void setDueDate(String dueDate) {
        mDueDate = dueDate;
    }

    public String getReminderDate() {
        return mReminderDate;
    }

    public void setReminderDate(String reminderDate) {
        mReminderDate = reminderDate;
    }

    public ArrayList<String> getNotes() {
        return mNotes;
    }

    public void setNotes(ArrayList<String> notes) {
        mNotes = notes;
    }

    public ArrayList<String> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(ArrayList<String> photos) {
        mPhotos = photos;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean completed) {
        mCompleted = completed;
    }

    public boolean isVerified() {
        return mVerified;
    }

    public void setVerified(boolean verified) {
        mVerified = verified;
    }
}
