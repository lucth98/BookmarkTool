package at.fhcampus.domain;

import org.mockito.Spy;

import java.io.*;

public class User {


private BookmarkManager bookmarkManager =new BookmarkManager();

    public BookmarkManager getBookmarkManager() {
        return bookmarkManager;
    }


    public void saveBookmarkManager(String fileName)  throws IOException, ClassNotFoundException,Exception{

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
       // spyedObjectOutputStream =(objectOutputStream);
        objectOutputStream.writeObject(this.bookmarkManager);
        objectOutputStream.flush();
        objectOutputStream.close();



    }

    public BookmarkManager loadBookmarkManager(String fileName) throws IOException, ClassNotFoundException,Exception {
        FileInputStream fileInputStream = new FileInputStream(fileName);
       ObjectInputStream objectInputStream  = new ObjectInputStream(fileInputStream);
      // spyedObjectInputStream=(objectInputStream);
        BookmarkManager bookmarkManager = (BookmarkManager) objectInputStream.readObject();
        objectInputStream.close();
        return bookmarkManager;
    }

    public void restoreBookmarks(String fileName) {
    }
}
