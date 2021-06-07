package at.fhcampus.domain;

import java.io.IOException;

public class User {
private BookmarkManager bookmarkManager =new BookmarkManager();

    public BookmarkManager getBookmarkManager() {
        return bookmarkManager;
    }

    public void setBookmarkManager(BookmarkManager bookmarkManager) {
        this.bookmarkManager = bookmarkManager;
    }

    public void saveBookmarkManager(String fileName)  throws IOException, ClassNotFoundException{
        throw new IOException("no File saved");

    }
}
