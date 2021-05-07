package at.fhcampus.domain;

import java.util.ArrayList;

public class Bookmark {

    private String url;

    private ArrayList<String> tags=new ArrayList<String>();

    private int rating;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Bookmark(String url) {
        this.url = url;
    }

    public Bookmark(String url, String tag) {
        this.url = url;
        this.tags.add(tag);


    }
}
