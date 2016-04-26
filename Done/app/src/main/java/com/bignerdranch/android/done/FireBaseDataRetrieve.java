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
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {

                DataBaseLists list = snapshot.getValue(DataBaseLists.class);
                mUserLists.add(list);
                boolean listAlreadyAdded = currUser.getList(UUID.fromString(list.getListId()))!= null;
                if (currUser.getUserId().equals(list.getCreatorId()) && !listAlreadyAdded) { //DATA CHECK TO ENSURE THERE IS NO REPETION ON DATA
                    com.bignerdranch.android.done.List currList = new com.bignerdranch.android.done.List(list.getCreatorId());
                    currList.setListId(list.getListId());
                    currList.setListName(list.getListName());
                    currUser.addUserList(currList);
                    //Toast.makeText(getBaseContext(), list.getListName(), Toast.LENGTH_SHORT).show();
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
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {

                //Object snapShot = snapshot.getValue();
                //com.bignerdranch.android.done.List currList = new com.bignerdranch.android.done.List(snapshot.child("creatorId").getValue().toString());
                //currList.setListName(snapshot.child("listName").getValue().toString());
                //currList.setListId(snapshot.child("listId").getValue().toString());
                // snapshot.child("tasks").getValue(DataBaseTasks.class);
                DataBaseTasks task = snapshot.getValue(DataBaseTasks.class);
                mUserTasks.add(task);

                Task userTask = new Task(UUID.fromString(task.getListId()));
                userTask.setCompleted(task.isCompleted());
                //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                //Date date = dateFormat.parse(strDate);
                //userTask.setCreatedDate(Date.valueOf(task.getCreatedDate()));
                //userTask.setDueDate(Date.valueOf(task.getDueDate()));
                userTask.setTaskId(UUID.fromString(task.getTaskId()));
                userTask.setVerified(task.isVerified());
                userTask.setTaskName(task.getTaskName());

                List listForTask = currUser.getList(userTask.getListId());

                if (listForTask != null) { //DATA CHECK TO ENSURE THERE IS NO REPETION ON DATA
                    boolean taskAlreadyExists = listForTask.getTask(userTask.getTaskId()) != null;
                    if(!taskAlreadyExists){
                        listForTask = currUser.getList(userTask.getListId());
                        listForTask.addListTask(userTask);
                    }

                }

                //System.out.println(task.getTaskName());
                //System.out.println(user.getEmail());
                //userList.add(user);
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
