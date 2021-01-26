package com.example.journaltheworld;

import java.nio.charset.StandardCharsets;

public class JournalStory {

    private String title;
    private String image;
    private String date;
    private String location;
    private String story;

    public JournalStory()
    {

    }

    public JournalStory (String title, String image, String date, String location, String story)
    {
        this.title = title;
        this.image = image;
        this.date = date;
        this.location = location;
        this.story = story;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    @Override
    public String toString() {
        return "JournalStory{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", story='" + story + '\'' +
                '}';
    }
}
