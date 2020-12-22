package com.example.activitychallenge2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);

                intent.putExtra("text", "Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One Text One ");
                //intent.putExtra("text", "lalala1");

                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        findViewById(R.id.text_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);

                intent.putExtra("text", "Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two Text Two ");
                //intent.putExtra("text", "lalala2");

                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        findViewById(R.id.text_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);

                intent.putExtra("text", "Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three Text Three ");
                //intent.putExtra("text", "lalala3");

                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {

        }
    }
}