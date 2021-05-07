package at.fhcampus.domain;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BookmarkManager {

 private ArrayList<Bookmark> bookmarkArrayList=new ArrayList<>();

    public ArrayList<Bookmark> getBookmarkArrayList() {
        return bookmarkArrayList;
    }

    public void setBookmarkArrayList(ArrayList<Bookmark> bookmarkArrayList) {
        this.bookmarkArrayList = bookmarkArrayList;
    }

    public void addBookmark(String url){
        if (validateURL(url)) {
            for (Bookmark bookmark : bookmarkArrayList) {
                if (bookmark.getUrl().equalsIgnoreCase(url)) {
                    bookmark.setRating(bookmark.getRating() + 1);
                    return;
                }
            }
            bookmarkArrayList.add(new Bookmark(url));
        }
        else
            throw new IllegalArgumentException("URL is not valid!");
    }

    public void addTagToBookmark(String url ,String tag){
        for (Bookmark bookmark:bookmarkArrayList) {
            if(bookmark.getUrl().equalsIgnoreCase(url)){
                bookmark.getTags().add(tag);
            }
        }
    }

    static public boolean validateURL(String url){
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    public int getNumbersOfSecureURL(){
        return 0;
    }

    public List<Bookmark> filterByTags(List<String> tags){

        return null;
    }









}
