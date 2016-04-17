package com.bignerdranch.android.done;

import android.content.Context;
import android.media.Image;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by michalisgratsias on 27/03/16.
 */
public class User {

    private static final String TAG = "DoneActivity";
    private UUID mUserId;
    private String mUserName;
    private String mPassword;
    private String mEmail;
    private Image mPhoto;
    private ArrayList<List> mUserLists;
    private Context mAppContext;
    private static User sUser;

    public User(Context appContext) {
        mAppContext = appContext;
        mUserId = UUID.randomUUID();
        mUserLists = new ArrayList<List>();
        mUserName = "John";                     // Test userName;
        mPassword = "dfghdfgh";                 // Test password;
        mEmail = "johnDD@cvb.com";              // Test email;
        for (int i = 1; i <= 5+(int)(Math.random()*20); i++) {       // random list number
            List l = new List();
            l.setListName("List Title # " + i + "- Chores");
            l.addListUser(mUserId);
            for (int j = 1; j <= 5+(int)(Math.random()*10); j++) {    // random task number
                Task t = new Task(l.getListId());
                t.setTaskName("Task # " + j);
                t.setCreatedDate(new Date());
                t.setCompleted(j % 2 == 0); // Every other one
                l.getListTasks().add(t);
            }
            mUserLists.add(l);
        }
        //for (List l: mUserLists){                      //  TESTING THE DATA
        //for (Task t: l.getListTasks()) {
        //Log.d(TAG, " " + l.getListTasks().size());// + " " + t.getTaskName());
        //}
        //}
    }

    public static User get(Context c) {                     // creates list as a Singleton= only 1 User object possible
        if (sUser == null) {
            sUser = new User(c.getApplicationContext());    // AppContext gives longer lifetime than Activities
        }
        return sUser;
    }

    public ArrayList<List> getUserLists() {                         // get all User Lists
        return mUserLists;
    }

    public List getList(UUID id) {                                  // get a User-List by ID
        for (List l : mUserLists) {
            if (l.getListId().equals(id))
                return l;
        }
        return null;
    }

    public UUID getUserId() {
        return mUserId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Image getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Image photo) {
        mPhoto = photo;
    }
}
