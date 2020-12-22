package com.example.activitychallenge3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edit = findViewById(R.id.ed1);

        findViewById(R.id.send1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                intent.putExtra("messageFromActivity1", edit.getText().toString());
                edit.setText("");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                String result = data.getStringExtra("messageFromActivity2");

                TextView textView2 = findViewById(R.id.te2);
                textView2.setText(result);

                TextView textView1 = findViewById(R.id.te1);
                textView1.setText("Reply received");

            } else if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }

}