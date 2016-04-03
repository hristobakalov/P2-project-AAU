package com.bignerdranch.android.done;

import android.content.Context;
import android.media.Image;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by michalisgratsias on 27/03/16.
 */
public class User {

    private String mUserName;
    private String mPassword;
    private String mEmail;
    private Image mPhoto;
    private ArrayList<List> mUserLists;
    private Context mAppContext;
    private static User sUser;

    public User(Context appContext) {
        mAppContext = appContext;
        mUserName = "John"; // Test userName;
        mPassword = "dfghdfgh"; //Test password;
        mEmail = "johnDD@cvb.com"; // Test email;
        mUserLists = new ArrayList<List>();
        for (int i = 0; i < 30; i++) {
            List l = new List();
            l.setListName("List Title # " + i + "- Chores");
            mUserLists.add(l);
        }
    }

    public User() {
        mUserLists = new ArrayList<List>();
    }

    public static User get(Context c) {                     // creates list as a Singleton= only 1 object possible
        if (sUser == null) {
            sUser = new User(c.getApplicationContext());    // AppContext gives longer lifetime than Activities
        }
        return sUser;
    }

    public ArrayList<List> getUserLists() {
        return mUserLists;
    }

    public List getList(UUID id) {
        for (List l : mUserLists) {
            if (l.getListId().equals(id))
                return l;
        }
        return null;
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
