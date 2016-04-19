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

        import android.content.Context;
        import android.media.Image;
        import android.util.Log;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.UUID;

public class UserTest {

    private static final String TAG = "DoneActivity";
    private String mUserName;
    private String mPassword;
    private String mEmail;
    private static UserTest sUser;

    public UserTest() {
        mUserName = "John";                     // Test userName;
        mPassword = "dfghdfgh";                 // Test password;
        mEmail = "johnDD@cvb.com";
    }

    public static UserTest get() {                     // creates list as a Singleton= only 1 User object possible
        if (sUser == null) {
            sUser = new UserTest();    // AppContext gives longer lifetime than Activities
        }
        return sUser;
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
}

