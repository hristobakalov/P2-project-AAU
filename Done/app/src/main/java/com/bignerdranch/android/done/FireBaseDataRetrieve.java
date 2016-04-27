package com.bignerdranch.android.done;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

public class FireBaseDataRetrieve extends Service {
    User currUser;
    ArrayList<DataBaseLists> mUserLists = new ArrayList<>();
    ArrayList<DataBaseTasks> mUserTasks = new ArrayList<>();

    public FireBaseDataRetrieve() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service started", Toast.LENGTH_SHORT).show();
        currUser = User.get();
        Firebase mRefLists = new Firebase("https://doneaau.firebaseio.com/lists/");
        mRefLists.addChildEventListener(new ChildEventListener() {
            // Retrieve new lists as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {

                DataBaseLists list = snapshot.getValue(DataBaseLists.class);
                if (currUser.getUserId().equals(list.getCreatorId())) { //ONLY SHOWS LISTS OF THIS USER
                    List currList = new List(list.getCreatorId());
                    currList.setListId(list.getListId());
                    currList.setListName(list.getListName());
                    currList.setCreatorId(list.getCreatorId());
                    currUser.addUserList(currList);                     // ADDS DATABASE LIST TO USER LISTS-ARRAY
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        Firebase mRefTasks = new Firebase("https://doneaau.firebaseio.com/tasks/");
        mRefTasks.addChildEventListener(new ChildEventListener() {
            // Retrieve new tasks as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {

                DataBaseTasks task = snapshot.getValue(DataBaseTasks.class);

                List listForTask = currUser.getList(task.getListId());

                if (listForTask != null) { //ONLY SHOWS TASKS OF THIS USER

                    Task userTask = new Task(task.getListId());
                    userTask.setTaskId(task.getTaskId());
                    userTask.setListId(task.getListId());
                    userTask.setTaskName(task.getTaskName());
                    userTask.setCreatedDate(Date.valueOf(task.getCreatedDate()));
                    userTask.setCompleted(task.isCompleted());
                    userTask.setVerified(task.isVerified());

                    listForTask.addListTask(userTask); // ADDS TASK TO THE CORRECT LIST

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
