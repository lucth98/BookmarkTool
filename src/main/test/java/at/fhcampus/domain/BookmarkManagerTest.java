package at.fhcampus.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BookmarkManagerTest {

    @Test
    public void ensureThatUserCanAddBookmark() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        List<Bookmark> expectedResult = new ArrayList<>();
        String url = "http://test.com/Test";
        expectedResult.add(new Bookmark(url));
        // Act
        bookmarkManager.addBookmark(url);
        List<Bookmark> actualResult = bookmarkManager.getBookmarkArrayList();

        System.out.println(expectedResult);
        System.out.println(actualResult);
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
        List<Bookmark> actualResult = bookmarkManager.getBookmarkArrayList();

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
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url);
        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<Bookmark> expectedResult = new ArrayList<>();
        expectedResult.add(new Bookmark(url, tag));

        // Act
        bookmarkManager.addTagToBookmark(url, tag);
        List<Bookmark> actualResult = bookmarkManager.getBookmarkArrayList();

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

    @Test
    public void ensureFilteringByKeyword() {
        //Arrange
        List<String> tags  = Arrays.asList("test", "java", "sport");
        String url1 = "https://url1test.com";
        String url2 = "https://url2health.com";
        String url3 = "https://url3sport.com";
        String url4 = "https://url4java.com";
        String url5 = "https://url5prog.com";
        Bookmark bookmark1 = new Bookmark(url1, "test");
        Bookmark bookmark2 = new Bookmark(url2, "health");
        Bookmark bookmark3 = new Bookmark(url3, "sport");
        Bookmark bookmark4 = new Bookmark(url4, "java");
        Bookmark bookmark5 = new Bookmark(url5, "prog");

        BookmarkManager bookmarkManager = new BookmarkManager();
        List<Bookmark> bookmarks = bookmarkManager.getBookmarkArrayList();
        bookmarks.add(bookmark1);
        bookmarks.add(bookmark2);
        bookmarks.add(bookmark3);
        bookmarks.add(bookmark4);
        bookmarks.add(bookmark5);

        List<Bookmark> expectedResult = Arrays.asList(bookmark1, bookmark4, bookmark3);

        //Act
        List<Bookmark> actualResult = bookmarkManager.filterByTags(tags);
        //ignore order
        actualResult.sort(Comparator.comparing(Bookmark::getUrl));
        expectedResult.sort(Comparator.comparing(Bookmark::getUrl));

        //Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureDomainCanBeExtracted() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url1 = "http://test.com/Test";

        String expectedResult = "test.com";
        // Act
        String actualResult = bookmarkManager.getDomainName(url1);

        // Assert
        assertEquals(expectedResult, actualResult);

    }


    @Test
    public void ensureSecureUrlsCountIsFour() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url1 = "http://test.com/Test";
        String url2 = "https://test1.com/Test";
        String url3 = "https://test1.com/Test";
        String url4 = "https://test1.com/Test";
        String url5 = "https://test1.com/Test";
        List<Bookmark> list = new ArrayList<>();
        list.add(new Bookmark(url1));
        list.add(new Bookmark(url2));
        list.add(new Bookmark(url3));
        list.add(new Bookmark(url4));
        list.add(new Bookmark(url5));
        bookmarkManager.setBookmarkArrayList(list);
        int expectedResult = 4;
        // Act
        int actualResult = bookmarkManager.getNumbersOfSecureURL();

        // Assert
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void ensureBookmarkHasAssociates() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url1 = "http://test.com/Test/java";
        String url2 = "https://test.com/Test/programming";
        String url3 = "https://test.com/Test";
        String url4 = "https://test1test.com/Test";
        String url5 = "https://test998.com/Test";
        List<Bookmark> list = new ArrayList<>();
        Bookmark bookmark1 =new Bookmark(url1);
        Bookmark bookmark2 =new Bookmark(url2);
        Bookmark bookmark3 =new Bookmark(url3);
        Bookmark bookmark4 =new Bookmark(url4);
        Bookmark bookmark5 =new Bookmark(url5);
        list.add(bookmark1);
        list.add(bookmark2);
        list.add(bookmark3);
        list.add(bookmark4);
        list.add(bookmark5);
        bookmarkManager.setBookmarkArrayList(list);

        Set<Bookmark> expectedResult = new LinkedHashSet<>();
        expectedResult.add(bookmark2);
        expectedResult.add(bookmark3);
        // Act
        bookmarkManager.addAssociates(bookmark1);
        Set<Bookmark> actualResult = bookmark1.getAssociates();

        System.out.println(expectedResult);
        System.out.println(actualResult);
        // Assert
        assertIterableEquals(expectedResult, actualResult);

    }

    @Test
    public void ensureAddingMultipleBookmarksWithAssociates() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url1 = "http://test.com/Test/java";
        String url2 = "https://test.com/Test/programming";
        String url3 = "https://test.com/Test";
        String url4 = "https://test1test.com/Test";
        String url5 = "https://test998.com/Test";

        //Act
        bookmarkManager.addBookmark(url1);
        bookmarkManager.addBookmark(url2);
        bookmarkManager.addBookmark(url3);
        bookmarkManager.addBookmark(url4);
        bookmarkManager.addBookmark(url5);

        List<Bookmark> bookmarks = bookmarkManager.getBookmarkArrayList();



        bookmarks.forEach(element -> System.out.println(element +"\n"+  element.getAssociates() + "\n\n\n"));
        // Assert

    }

}