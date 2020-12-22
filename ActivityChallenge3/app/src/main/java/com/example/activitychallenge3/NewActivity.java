package com.example.activitychallenge3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    private String messageFromActivity1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_activity);

        Log.i("Lifecycle", "onCreate");

        if (getIntent().getExtras() != null) {
            messageFromActivity1 = getIntent().getStringExtra("messageFromActivity1");
        }

        TextView textView2 = findViewById(R.id.te22);
        textView2.setText(messageFromActivity1);

        TextView textView1 = findViewById(R.id.te21);
        textView1.setText("Message received");

        findViewById(R.id.send2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    EditText edit2 = findViewById(R.id.ed2);

                    String messageFromActivity2 = edit2.getText().toString();

                    Intent intent = new Intent();
                    intent.putExtra("messageFromActivity2", messageFromActivity2);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                } catch (NumberFormatException e) {
                    setResult(Activity.RESULT_CANCELED);
                    finish();
                }

            }
        });

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
