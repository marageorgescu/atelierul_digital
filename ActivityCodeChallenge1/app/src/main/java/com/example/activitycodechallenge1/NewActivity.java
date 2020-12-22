package com.example.activitycodechallenge1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_activity);

        Log.i("Lifecycle", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("Lifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Lifecycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecycle", "onDestroy");
    }

}
