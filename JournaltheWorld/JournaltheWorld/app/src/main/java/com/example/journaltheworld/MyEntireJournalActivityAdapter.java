package com.example.journaltheworld;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyEntireJournalActivityAdapter  extends ArrayAdapter<String> {

    private Activity context;
    private String[] titlesList;
    private String[] imagesList;
    private String[] datesList;
    private String[] locationsList;
    private String[] storiesList;

    public MyEntireJournalActivityAdapter (Activity context, String[] titlesList, String[] imagesList, String[] datesList, String[] locationsList, String[] storiesList)
    {
        super(context, R.layout.row_item, titlesList);
        this.context = context;
        this.titlesList = titlesList;
        this.imagesList = imagesList;
        this.datesList = datesList;
        this.locationsList = locationsList;
        this.storiesList = storiesList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView == null)
            row = inflater.inflate(R.layout.row_item, null, true);
        TextView textViewTitle = (TextView) row.findViewById(R.id.textViewTitle);
        TextView textViewDate = (TextView) row.findViewById(R.id.textViewDate);
        TextView textViewLocation = (TextView) row.findViewById(R.id.textViewLocation);
        TextView textViewStory = (TextView) row.findViewById(R.id.textViewStory);
        ImageView imageView = (ImageView) row.findViewById(R.id.imageViewPicture);

        textViewTitle.setText(titlesList[position]);
        textViewDate.setText(datesList[position]);
        textViewLocation.setText(locationsList[position]);
        textViewStory.setText(storiesList[position]);
        Picasso.get().load(imagesList[position]).rotate(90).into(imageView);
        return row;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

}
