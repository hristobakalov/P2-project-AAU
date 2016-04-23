/*package com.bignerdranch.android.done;

import android.content.Context;
import android.media.Image;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


public class UserTest {
    private int birthYear;
    private String fullName;

    public UserTest() {}

    public UserTest(String fullName, int birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public long getBirthYear() {
        return birthYear;
    }

    public String getFullName() {
        return fullName;
    }
}*/

package com.bignerdranch.android.done;

import java.util.UUID;

public class UserTest {

    /*private static final String TAG = "DoneActivity";
    private String userName;
    private String password;
    private String email;
    private static UserTest sUser;

    public UserTest() {
        userName = "John";                     // Test userName;
        password = "dfghdfgh";                 // Test password;
        email = "johnDD@cvb.com";
    }

    public static UserTest get() {                     // creates list as a Singleton= only 1 User object possible
        if (sUser == null) {
            sUser = new UserTest();    // AppContext gives longer lifetime than Activities
        }
        return sUser;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }
    */
    //IMPORTANT!!! the name of the fields should be the same as the one in the database!
    private String userId;
    private String userName;
    private String password;
    private String email;
    //private Image mPhoto;
    private static UserTest sUser;

    public UserTest(){
        // empty default constructor, necessary for Firebase
    }
    public UserTest(String name) {
        UUID id = (UUID.randomUUID());
        userId = id.toString();
        //mUserLists = new ArrayList<List>();
        userName = "John";                     // Test userName;
        password = "dfghdfgh";                 // Test password;
        email = "johnDD@cvb.com";              // Test email;


    }

    public static UserTest get() {                     // creates list as a Singleton= only 1 User object possible
        if (sUser == null) {
            sUser = new UserTest("test");    // AppContext gives longer lifetime than Activities
        }
        return sUser;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

