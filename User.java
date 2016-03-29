package com.bignerdranch.android.done;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by michalisgratsias on 27/03/16.
 */
public class User {

    private String mUserName;
    private String mPassword;
    private String mEmail;
    private Image mPhoto;
    private ArrayList<List> mUserLists;

    public User(String userName, String password, String email) {
        mUserName = userName;
        mPassword = password;
        mEmail = email;
        mUserLists = new ArrayList<List>();
    }

    public User(String userName, String password, String email, Image photo) {
        this(userName, password, email);
        mPhoto = photo;
        mUserLists = new ArrayList<List>();
    }

    public User() {
        mUserLists = new ArrayList<List>();
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
