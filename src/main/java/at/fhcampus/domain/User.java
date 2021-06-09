package at.fhcampus.domain;

import org.mockito.Spy;

import java.io.*;

public class User {
    private String username = "";

    private BookmarkManager bookmarkManager = new BookmarkManager();

    private int backUpNr = 1;


    public void setBackUpNr(int backUpNr) {
        this.backUpNr = backUpNr;
    }

    public BookmarkManager getBookmarkManager() {
        return bookmarkManager;
    }

    public int getBackUpNr() {
        return backUpNr;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void saveBookmarkManager(String fileName) throws IOException, ClassNotFoundException, Exception {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        // spyedObjectOutputStream =(objectOutputStream);
        objectOutputStream.writeObject(this.bookmarkManager);
        objectOutputStream.flush();
        objectOutputStream.close();


    }

    public BookmarkManager loadBookmarkManager(String fileName) throws IOException, ClassNotFoundException, Exception {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        // spyedObjectInputStream=(objectInputStream);
        BookmarkManager bookmarkManager = (BookmarkManager) objectInputStream.readObject();
        objectInputStream.close();
        return bookmarkManager;
    }

    public void restoreBookmarks(String fileName) {
        try {
            this.bookmarkManager = loadBookmarkManager(fileName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void generateBackUp() {
        try {
            saveBookmarkManager(username + "Backup_NR:" + backUpNr);
            backUpNr++;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
