package at.fhcampus.domain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class User {
private BookmarkManager bookmarkManager =new BookmarkManager();

    public BookmarkManager getBookmarkManager() {
        return bookmarkManager;
    }

    public void setBookmarkManager(BookmarkManager bookmarkManager) {
        this.bookmarkManager = bookmarkManager;
    }

    public void saveBookmarkManager(String fileName)  throws IOException, ClassNotFoundException,Exception{

        FileOutputStream fileOutputStream
                = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this.bookmarkManager);
        objectOutputStream.flush();
        objectOutputStream.close();
        return;
        //throw new IOException("no File saved");
    }

    public BookmarkManager loadBookmarkManager(String fileName) throws IOException, ClassNotFoundException,Exception {
        throw new IOException();
    }
}
