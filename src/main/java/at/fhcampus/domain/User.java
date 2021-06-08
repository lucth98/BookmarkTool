package at.fhcampus.domain;

import java.io.*;

public class User {
private BookmarkManager bookmarkManager =new BookmarkManager();

    public BookmarkManager getBookmarkManager() {
        return bookmarkManager;
    }


    public void saveBookmarkManager(String fileName)  throws IOException, ClassNotFoundException,Exception{

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this.bookmarkManager);
        objectOutputStream.flush();
        objectOutputStream.close();
        return;
        //throw new IOException("no File saved");
    }

    public BookmarkManager loadBookmarkManager(String fileName) throws IOException, ClassNotFoundException,Exception {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream  = new ObjectInputStream(fileInputStream);
        BookmarkManager bookmarkManager = (BookmarkManager) objectInputStream.readObject();
        objectInputStream.close();
        return bookmarkManager;
    }
}
