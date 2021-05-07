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
    public void ensureThatUserCanAddBookmarkWithValidURL() {
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
    public void ensureThatUserCantAddBookmarkWithInValidURL() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://t est.com/Test";
        // Act
        assertThrows(IllegalArgumentException.class, () -> bookmarkManager.addBookmark(url));
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

    @Test
    public void ensureUrlIsValid() {
        // Arrange
        String url = "http://test.com/Test";
        // Act
        boolean actualResult = BookmarkManager.validateURL(url);

        // Assert
        assertTrue(actualResult);
    }

    @Test
    public void ensureUrlIsInValid() {
        // Arrange
        String url = "http/test.com/Test";
        // Act
        boolean actualResult = BookmarkManager.validateURL(url);

        // Assert
        assertFalse(actualResult);
    }

    @Test
    public void ensureRatingIsIncreased() {
        // Arrange
        int expectedResult = 2;
        BookmarkManager bookmarkManager = new BookmarkManager();
        ArrayList<Bookmark> list = new ArrayList<>();
        String url = "http://test.com/Test";
        list.add(new Bookmark(url));
        bookmarkManager.setBookmarkArrayList(list);
        // Act
        bookmarkManager.addBookmark(url);
        int actualResult = bookmarkManager.getBookmarkArrayList().get(0).getRating();

        // Assert
        assertEquals(expectedResult, actualResult);

    }





}