package at.fhcampus.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookmarkManagerTest {

    @Test
    public void ensureThatUserCanAddBookmark() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        ArrayList<Bookmark> expectedResult = new ArrayList<>();
        String url = "http://test.com/Test";
        expectedResult.add(new Bookmark(url));
        // Act
        bookmarkManager.addBookmark(url);
        ArrayList<Bookmark> actualResult = bookmarkManager.getBookmarkArrayList();

        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureThatUserCanAddOneTagToBookmark() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        String tag = "test";
        ArrayList<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url);
        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        ArrayList<Bookmark> expectedResult = new ArrayList<>();
        ArrayList<Bookmark> actualResult = new ArrayList<>();

        expectedResult.add(new Bookmark(url, tag));

        // Act
        bookmarkManager.addTagToBookmark(url, tag);
        actualResult = bookmarkManager.getBookmarkArrayList();

        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }


}