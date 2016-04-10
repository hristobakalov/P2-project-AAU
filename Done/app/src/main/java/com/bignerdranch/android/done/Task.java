package com.bignerdranch.android.done;

import android.media.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by michalisgratsias on 27/03/16.
 */
public class Task {

    private UUID mTaskId;
    private UUID mListId;
    private String mTaskName;
<<<<<<< HEAD:Done/app/src/main/java/com/bignerdranch/android/done/Task.java
    private ArrayList<String> mAssignees;
    private ArrayList<String> mViewers = new ArrayList<>();
=======
    private ArrayList<User> mAssignees;
    private ArrayList<User> mViewers;
>>>>>>> refs/remotes/origin/master:Done/app/src/main/java/com/bignerdranch/android/done/Task.java
    private Date mDueDate;
    private Date mReminderDate;
    private ArrayList<String> mNotes;
    private ArrayList<Image> mPhotos;
    private boolean mCompleted;
    private boolean mVerified;

<<<<<<< HEAD:Done/app/src/main/java/com/bignerdranch/android/done/Task.java
    public Task(String taskName, ArrayList<String> assignees,
                ArrayList<String> viewers, Date dueDate, Date reminderDate,
=======
    public Task(String taskName, ArrayList<User> assignees, // not needed
                ArrayList<User> viewers, Date dueDate, Date reminderDate,
>>>>>>> refs/remotes/origin/master:Done/app/src/main/java/com/bignerdranch/android/done/Task.java
                ArrayList<String> notes, ArrayList<Image> photos,
                boolean completed, boolean verified) {
        mTaskName = taskName;
        mAssignees = assignees;
        mViewers = viewers;
        mDueDate = dueDate;
        mReminderDate = reminderDate;
        mNotes = notes;
        mPhotos = photos;
        mCompleted = completed;
        mVerified = verified;
    }

    public Task(UUID listId) {                  // constructor with Task ID, List ID
        mTaskId = UUID.randomUUID();
        mListId = listId;
<<<<<<< HEAD:Done/app/src/main/java/com/bignerdranch/android/done/Task.java
        mAssignees = new ArrayList<>();
        mViewers= new ArrayList<>();
        mDueDate = new Date();
        mReminderDate = new Date();
        mNotes = new ArrayList<>();
        mPhotos = new ArrayList<>();
=======
    }

    public UUID getTaskId() {
        return mTaskId;
>>>>>>> refs/remotes/origin/master:Done/app/src/main/java/com/bignerdranch/android/done/Task.java
    }

    public UUID getListId() {
        return mListId;
    }

    public UUID getTaskId() {
        return mTaskId;
    }

    public UUID getListId() {
        return mListId;
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

    public void addAssignee(String mUserName) {
        // to be implemented
    }

    public void removeAssignee(String mUserName) {
        // to be implemented
    }

    public ArrayList<String> getViewers() {
        return mViewers;
    }

    public void addViewer(String mUserName) {
        // to be implemented
    }

    public void removeViewer(String mUserName) {
        // to be implemented
    }

    public Date getDueDate() {
        return mDueDate;
    }

    public void setDueDate(Date dueDate) {
        mDueDate = dueDate;
    }

    public Date getReminderDate() {
        return mReminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        mReminderDate = reminderDate;
    }

    public ArrayList<String> getNotes() {
        return mNotes;
    }

    public void setNotes(ArrayList<String> notes) {
        mNotes = notes;
    }

    public void addNote(String mNote) {
        // to be implemented
    }

    public void removeNote(String mNote) {
        // to be implemented
    }

    public ArrayList<Image> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(ArrayList<Image> photos) {
        mPhotos = photos;
    }

    public void addPhoto(Image mPhoto) {
        // to be implemented
    }

    public void removePhoto(Image mPhoto) {
        // to be implemented
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
