package at.fhcampus.domain;

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

    }

    public void addTagToBookmark(){

    }

    public int getNumbersOfSecureURL(){
        return 0;
    }

    static public boolean validateURL(String url){
        return  false;
    }

    public List<Bookmark> filterByTags(List<String> tags){

        return null;
    }









}
