package com.christian.togstudyapp;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class DuolingoApp extends Application {

    private static final String TAG = "DuolingoApp";

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseApp.initializeApp(this);
    }
}
