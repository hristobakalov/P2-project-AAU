package com.bignerdranch.android.done;

import android.os.Bundle;
import android.support.v4.app.Fragment;                         // from support library
import android.support.v4.app.FragmentActivity;                 // from support library
import android.support.v4.app.FragmentManager;                  // from support library

/**
 * Created by michalisgratsias on 03/04/16.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();               // abstract method not implemented here

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_container);             // view inflated from xml layout
        FragmentManager fm = getSupportFragmentManager();       // FM responsible for managing Fragments and adding their Views
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);   // using Support Library - give frmt to mgr.
        if (fragment == null) {                                 // Because maybe this ID is saved on rotation by fr.mgr, and is not null
            fragment = createFragment();                        // abstract method called
            fm.beginTransaction()                               // create a new Fragment Object hosted by the Activity
                    .add(R.id.fragment_container, fragment)     // include an ADD operation on it (identified by resource ID of container view)
                    .commit(); }                                // and commit the fragment transaction to the list of the mgr
    }


}
