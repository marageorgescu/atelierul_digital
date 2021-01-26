package com.example.journaltheworld;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyEntireJournalActivity extends AppCompatActivity {

    private SQLiteDatabaseHandler db;

    private String[] titlesList;
    private String[] imagesList;
    private String[] datesList;
    private String[] locationsList;
    private String[] storiesList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myentirejournal_activity);

        db = new SQLiteDatabaseHandler(this);
        List<JournalStory> journalStories = db.allJournalStories();

        if (journalStories != null) {
            String[] itemsNames = new String[journalStories.size()];

            for (int i = 0; i < journalStories.size(); i++) {
                itemsNames[i] = journalStories.get(i).toString();
            }

            titlesList = new String[journalStories.size()];
            imagesList = new String[journalStories.size()];
            datesList = new String[journalStories.size()];
            locationsList = new String[journalStories.size()];
            storiesList = new String[journalStories.size()];

            for (int i = 0; i < journalStories.size(); i++) {
                //pentru titlu
                int titleBeginIndex = itemsNames[i].indexOf("title=") + 7;
                int titleEndIndex = itemsNames[i].indexOf("image=") - 3;
                String title = itemsNames[i].substring(titleBeginIndex, titleEndIndex);
                titlesList[i] = title;

                //pentru imagine
                int imageBeginIndex = itemsNames[i].indexOf("image=") + 7;
                int imageEndIndex = itemsNames[i].indexOf("date=") - 3;
                String imageURI = itemsNames[i].substring(imageBeginIndex, imageEndIndex);
                imagesList[i] = imageURI;

                //pentru data
                int dateBeginIndex = itemsNames[i].indexOf("date=") + 6;
                int dateEndIndex = itemsNames[i].indexOf("location=") - 3;
                String date = itemsNames[i].substring(dateBeginIndex, dateEndIndex);
                datesList[i] = date;

                //pentru locatie
                int locationBeginIndex = itemsNames[i].indexOf("location=") + 10;
                int locationEndIndex = itemsNames[i].indexOf("story=") - 3;
                String location = itemsNames[i].substring(locationBeginIndex, locationEndIndex);
                locationsList[i] = location;

                //pentru poveste
                int storyBeginIndex = itemsNames[i].indexOf("story=") + 7;
                int storyEndIndex = itemsNames[i].indexOf("}") - 1;
                String story = itemsNames[i].substring(storyBeginIndex, storyEndIndex);
                storiesList[i] = story;

            }

            TextView header = new TextView(this);
            Typeface face = ResourcesCompat.getFont(this, R.font.sweetandsassy);
            header.setTypeface(face);
            header.setTextSize(40.f);
            header.setText("My Travel Journal");

            ListView list = (ListView) findViewById(R.id.list);

            list.addHeaderView(header);

            MyEntireJournalActivityAdapter myEntireJournalActivityAdapter = new MyEntireJournalActivityAdapter(this, titlesList, imagesList, datesList, locationsList, storiesList);
            list.setAdapter(myEntireJournalActivityAdapter);

            
            /*ListView list = (ListView) findViewById(R.id.list);
            list.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, itemsNames));*/

            //Log.i("tag", String.valueOf(itemsNames[journalStories.size() - 1].indexOf("image=") + 7));
            //Log.i("tag", String.valueOf(itemsNames[journalStories.size() - 1].indexOf("story=") - 4));
            //int storyBeginIndex = itemsNames[journalStories.size() - 1].indexOf("story=") + 7;
            //int storyEndIndex = itemsNames[journalStories.size() - 1].indexOf("}") - 1;
            //String story = itemsNames[journalStories.size() - 1].substring(storyBeginIndex, storyEndIndex);
            //Log.i("tag", story);
            //Log.i("tag", itemsNames[journalStories.size() - 1].substring(beginIndex, endIndex));
            //Log.i("tag", itemsNames[journalStories.size() - 1]);

            //ImageView imageView = findViewById(R.id.myEntireJournalActivityImageView);
            //Picasso.get().load(imageURI).into(imageView);

        }




    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
