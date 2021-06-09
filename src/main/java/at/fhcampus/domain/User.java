package at.fhcampus.domain;

import org.mockito.Spy;

import java.io.*;

public class User {
    private String username="";

    private BookmarkManager bookmarkManager =new BookmarkManager();

    public BookmarkManager getBookmarkManager() {
        return bookmarkManager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        try {
            this.bookmarkManager = loadBookmarkManager(fileName);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void generateBackUp() {
    }
}
