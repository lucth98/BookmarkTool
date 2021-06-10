package at.fhcampus.domain;


import java.io.*;
import java.util.Objects;



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

    public void setBookmarkManager(BookmarkManager bookmarkManager) {
        this.bookmarkManager = bookmarkManager;
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
        objectOutputStream.writeObject(this.bookmarkManager);
        objectOutputStream.flush();
        objectOutputStream.close();


    }

    public BookmarkManager loadBookmarkManager(String fileName) throws IOException, ClassNotFoundException, Exception {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        BookmarkManager bookmarkManager = (BookmarkManager) objectInputStream.readObject();
        objectInputStream.close();
        return bookmarkManager;
    }

    public void restoreBookmarks(String fileName) throws IOException, ClassNotFoundException, Exception {

            this.bookmarkManager = loadBookmarkManager(fileName);

    }

    public void generateBackUp() throws IOException, ClassNotFoundException, Exception {
            if(username!=null && !username.equals("")) {
                saveBookmarkManager(username + "Backup_NR:" + backUpNr);
                backUpNr++;
            }
            else {
                throw new NullPointerException("username does not exist");
            }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getBackUpNr() == user.getBackUpNr() && Objects.equals(username, user.username) && Objects.equals(getBookmarkManager(), user.getBookmarkManager());
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, getBookmarkManager(), getBackUpNr());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", bookmarkManager=" + bookmarkManager +
                ", backUpNr=" + backUpNr +
                '}';
    }
}
