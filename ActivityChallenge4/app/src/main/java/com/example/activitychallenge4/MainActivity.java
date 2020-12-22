package com.example.activitychallenge4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.website_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText websiteEditText = findViewById(R.id.website_edittext);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteEditText.getText().toString()));
                startActivity(browserIntent);

            }
        });


        findViewById(R.id.location_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText locationEditText = findViewById(R.id.location_edittext);
                Intent locationIntent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.co.in/maps?q=" + locationEditText.getText().toString()));
                startActivity(locationIntent);

            }
        });


        findViewById(R.id.text_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText textEditText = findViewById(R.id.text_edittext);
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, textEditText.getText().toString());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });


        findViewById(R.id.phone_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText phoneEditText = findViewById(R.id.phone_edittext);
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneEditText.getText().toString()));
                startActivity(intent);

            }
        });
        

    }
}