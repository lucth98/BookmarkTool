package at.fhcampus.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public void ensureThatUserCantAddBookmarkWithNullURL() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();

        String url = null;

        // Act & Assert

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            bookmarkManager.addBookmark(url);
        });
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
    public void ensureThatUserCanAddOneTagToBookmark2() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        String url2 = "http://TEST.com/TEST";
        String tag = "test";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url);
        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<Bookmark> expectedResult = new ArrayList<>();
        expectedResult.add(new Bookmark(url, tag));

        // Act
        bookmarkManager.addTagToBookmark(url2, tag);
        List<Bookmark> actualResult = bookmarkManager.getBookmarkArrayList();

        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }



    @Test
    public void ensureThatUserCanAddOneTagToBookmark3() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        String url2 = "HTTP://TEST.COM/TEST";
        String tag = "test";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url);
        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<Bookmark> expectedResult = new ArrayList<>();
        expectedResult.add(new Bookmark(url, tag));

        // Act
        bookmarkManager.addTagToBookmark(url2, tag);
        List<Bookmark> actualResult = bookmarkManager.getBookmarkArrayList();

        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureThatUserCanAddOneTagToBookmark4() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url2 = "http://test.com/Test";
        String url = "HTTP://TEST.COM/TEST";
        String tag = "test";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url);
        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<Bookmark> expectedResult = new ArrayList<>();
        expectedResult.add(new Bookmark(url, tag));

        // Act
        bookmarkManager.addTagToBookmark(url2, tag);
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
        List<String> tags = Arrays.asList("test", "java", "sport");
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
    public void ensureDomainCanNotBeExtracted() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url1 = "BlaBla";
        // Act
        String actualResult = bookmarkManager.getDomainName(url1);
        // Assert
        assertNull(actualResult);
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
        Bookmark bookmark1 = new Bookmark(url1);
        Bookmark bookmark2 = new Bookmark(url2);
        Bookmark bookmark3 = new Bookmark(url3);
        Bookmark bookmark4 = new Bookmark(url4);
        Bookmark bookmark5 = new Bookmark(url5);
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
    public void ensureBookmarkHasnotAssociates() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url1 = "http://test.com/Test/java";
        String url2 = "https://test.com/Test/programming";
        String url3 = "https://test.com/Test";
        String url4 = "https://test1test.com/Test";
        String url5 = "https://test998.com/Test";
        List<Bookmark> list = new ArrayList<>();
        Bookmark bookmark1 = new Bookmark();
        bookmark1.setUrl(null);
        Bookmark bookmark2 = new Bookmark(url2);
        Bookmark bookmark3 = new Bookmark(url3);
        Bookmark bookmark4 = new Bookmark(url4);
        Bookmark bookmark5 = new Bookmark(url5);
        list.add(bookmark1);
        list.add(bookmark2);
        list.add(bookmark3);
        list.add(bookmark4);
        list.add(bookmark5);
        bookmarkManager.setBookmarkArrayList(list);

        Set<Bookmark> expectedResult = new LinkedHashSet<>();

        // Act
        bookmarkManager.addAssociates(bookmark1);
        Set<Bookmark> actualResult = bookmark1.getAssociates();

        System.out.println(expectedResult);
        System.out.println(actualResult);
        // Assert
        assertNull(actualResult);

    }

    @Test
    public void ensureAddingMultipleBookmarksWithAssociates() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();

        String url1 = "http://test.com/Test/java";
        String url2 = "https://test.com/Test/programming";

        Bookmark bookmark1 = new Bookmark(url1);
        Bookmark bookmark2 = new Bookmark(url2);

        bookmarkManager.getBookmarkArrayList().add(bookmark1);
        bookmarkManager.getBookmarkArrayList().add(bookmark2);

        Set<Bookmark> expectedResult = new LinkedHashSet<>();
        Set<Bookmark> actualResult = new LinkedHashSet<>();

        expectedResult.add(bookmark2);

        //Act
        bookmarkManager.addAssociates(bookmark1);

        actualResult = bookmark1.getAssociates();

        // Assert

        assertIterableEquals(expectedResult, actualResult);
    }




    @Test
    public void ensureAddingMultipleBookmarksWithAssociatesinAddBookmark() {
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();

        String url1 = "http://test.com/Test/java";
        String url2 = "https://test.com/Test/programming";

        Bookmark bookmark1 = new Bookmark(url1);
        //Bookmark bookmark2 = new Bookmark(url2);

        bookmarkManager.getBookmarkArrayList().add(bookmark1);
      //  bookmarkManager.getBookmarkArrayList().add(bookmark2);

        Set<Bookmark> expectedResult = new LinkedHashSet<>();
        Set<Bookmark> actualResult = new LinkedHashSet<>();



        //Act
       bookmarkManager.addBookmark(url2);
        expectedResult.add(bookmarkManager.getBookmarkArrayList().get(1));



        actualResult = bookmark1.getAssociates();

        // Assert

        assertIterableEquals(expectedResult, actualResult);
    }


    @Test
    public void ensureThatCurrentDateIsAdded(){
        // Arrange
        BookmarkManager bookmarkManager=new BookmarkManager();
        String url1 = "http://test.com/Test/java";
        LocalDateTime expectedResult=LocalDateTime.now();
        LocalDateTime actualResult;
       int expectedMo=expectedResult.getMonthValue();
       int expectedD=expectedResult.getDayOfMonth();
       int expecteY=expectedResult.getYear();

       int expectedH=expectedResult.getHour();
       int expectedMi=expectedResult.getMinute();


        int actualMo;
        int actualD;
        int actualY;

        int actualH;
        int actualMi;
        //Act
        bookmarkManager.addBookmark(url1);
        actualResult=bookmarkManager.getBookmarkArrayList().get(0).getAddingTime();


         actualMo=actualResult.getMonthValue();
         actualD=actualResult.getDayOfMonth();
         actualY=actualResult.getYear();

         actualH=actualResult.getHour();
         actualMi=actualResult.getMinute();




        // Assert
        assertEquals(expectedD,actualD);
        assertEquals(expectedH,actualH);
        assertEquals(expectedMi,actualMi);
        assertEquals(expectedMo,actualMo);
        assertEquals(expecteY,actualY);

    }


    @Test
    public void ensureThatTakCanBeRemoved(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        String tag = "test";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url,tag);

        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<String> expectedResult = new ArrayList<>();
        // Act
        bookmarkManager.removeTagFromBookmark(url,tag);
        List<String> actualResult = bookmarkManager.getBookmarkArrayList().get(0).getTags();
        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }


    @Test
    public void ensureThatTakCanBeRemoved2(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        String url2 = "http://TEST.com/TEST";
        String tag = "test";
        String tag2 = "TEST";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url,tag);

        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<String> expectedResult = new ArrayList<>();
        // Act
        bookmarkManager.removeTagFromBookmark(url2,tag2);
        List<String> actualResult = bookmarkManager.getBookmarkArrayList().get(0).getTags();
        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }
    @Test
    public void ensureThatTakCanBeRemoved3(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        String url2 = "http://TEST.com/TEST";
        String tag = "test";
        String tag2 = "TEST";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url,tag);

        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<String> expectedResult = new ArrayList<>();
        // Act
        bookmarkManager.removeTagFromBookmark(url,tag2);
        List<String> actualResult = bookmarkManager.getBookmarkArrayList().get(0).getTags();
        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureThatTakCanBeRemoved4(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        String url2 = "http://TEST.com/TEST";
        String tag = "test";
        String tag2 = "TEST";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url,tag);

        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<String> expectedResult = new ArrayList<>();
        // Act
        bookmarkManager.removeTagFromBookmark(url2,tag);
        List<String> actualResult = bookmarkManager.getBookmarkArrayList().get(0).getTags();
        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureThatTakCanBeRemoved5(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        String url2 = "HTTP://TEST.COM/TEST";
        String tag = "test";
        String tag2 = "TEST";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url,tag);

        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<String> expectedResult = new ArrayList<>();
        // Act
        bookmarkManager.removeTagFromBookmark(url2,tag);
        List<String> actualResult = bookmarkManager.getBookmarkArrayList().get(0).getTags();
        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }
    @Test
    public void ensureThatTakCanBeRemoved6(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url2 = "http://test.com/Test";
        String url = "HTTP://TEST.COM/TEST";
        String tag = "test";
        String tag2 = "TEST";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url,tag);

        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<String> expectedResult = new ArrayList<>();
        // Act
        bookmarkManager.removeTagFromBookmark(url2,tag);
        List<String> actualResult = bookmarkManager.getBookmarkArrayList().get(0).getTags();
        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureThatTakCanTBeRemoved(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";

        String tag = "test";
        String tag2 = "tst";
        String tag3 = "tet";
        String tag4 = "tes";
        String tag5 = "est";
        String tag6 = "es";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url);


        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);
        bookmark.getTags().add(tag2);
        bookmark.getTags().add(tag3);
        bookmark.getTags().add(tag4);
        bookmark.getTags().add(tag5);
        bookmark.getTags().add(tag6);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(tag2);
        expectedResult.add(tag3);
        expectedResult.add(tag4);
        expectedResult.add(tag5);
        expectedResult.add(tag6);
        // Act
        bookmarkManager.removeTagFromBookmark(url,tag);
        List<String> actualResult = bookmarkManager.getBookmarkArrayList().get(0).getTags();
        // Assert
        System.out.println(actualResult);
        System.out.println(expectedResult);
        assertIterableEquals(expectedResult, actualResult);
    }




    @Test
    public void ensureThatBookmarkCanBeRemoved(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url);
        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<Bookmark> expectedResult = new ArrayList<>();
        // Act
        bookmarkManager.removeBookmark(url);

        List<Bookmark> actualResult = bookmarkManager.getBookmarkArrayList();
        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureThatBookmarkCanBeRemoved2(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        String url2 = "http://TEST.com/TEST";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url);
        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<Bookmark> expectedResult = new ArrayList<>();
        // Act
        bookmarkManager.removeBookmark(url2);

        List<Bookmark> actualResult = bookmarkManager.getBookmarkArrayList();
        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }


    @Test
    public void ensureThatBookmarkCanTBeRemoved(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/Test";
        String url2 = "http://test.com/Test 2";
        List<Bookmark> bookmarkArrayList = bookmarkManager.getBookmarkArrayList();
        Bookmark bookmark = new Bookmark(url);
        bookmarkArrayList.add(bookmark);
        bookmarkManager.setBookmarkArrayList(bookmarkArrayList);

        List<Bookmark> expectedResult = new ArrayList<>();
        expectedResult.add(bookmark);
        // Act
        bookmarkManager.removeBookmark(url2);

        List<Bookmark> actualResult = bookmarkManager.getBookmarkArrayList();
        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureThatBookmarkAreSortedByRating(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/test";
        String url2 = "http://java.com";
        String url3 = "http://testing.at";

        Bookmark bookmark1 = new Bookmark(url);
        bookmark1.setRating(3);

        Bookmark bookmark2 = new Bookmark(url2);
        bookmark2.setRating(2);

        Bookmark bookmark3 = new Bookmark(url3);
        bookmark3.setRating(1);

        bookmarkManager.addBookmark(url);
        bookmarkManager.addBookmark(url);
        bookmarkManager.addBookmark(url);

        bookmarkManager.addBookmark(url2);
        bookmarkManager.addBookmark(url2);

        bookmarkManager.addBookmark(url3);

        // Act
        List<Bookmark> actualResult = bookmarkManager.getSortedBookmarksByRating();
        List<Bookmark> expectedResult = Arrays.asList(bookmark1, bookmark2, bookmark3);

        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureThatBookmarkAreSortedByRating2(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/test";
        String url2 = "http://java.com";
        String url3 = "http://testing.at";

        Bookmark bookmark1 = new Bookmark(url);
        bookmark1.setRating(5);

        Bookmark bookmark2 = new Bookmark(url2);
        bookmark2.setRating(1);

        Bookmark bookmark3 = new Bookmark(url3);
        bookmark3.setRating(1);

        bookmarkManager.addBookmark(url);
        bookmarkManager.addBookmark(url);
        bookmarkManager.addBookmark(url);
        bookmarkManager.addBookmark(url);
        bookmarkManager.addBookmark(url);

        bookmarkManager.addBookmark(url2);

        bookmarkManager.addBookmark(url3);

        // Act
        List<Bookmark> actualResult = bookmarkManager.getSortedBookmarksByRating();
        List<Bookmark> expectedResult = Arrays.asList(bookmark1, bookmark2, bookmark3);

        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureThatBookmarkAreSortedByRating3(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/test";
        String url2 = "http://java.com";
        String url3 = "http://testing.at";

        Bookmark bookmark1 = new Bookmark(url);
        bookmark1.setRating(1);

        Bookmark bookmark2 = new Bookmark(url2);
        bookmark2.setRating(1);

        Bookmark bookmark3 = new Bookmark(url3);
        bookmark3.setRating(1);

        bookmarkManager.addBookmark(url);

        bookmarkManager.addBookmark(url2);

        bookmarkManager.addBookmark(url3);

        // Act
        List<Bookmark> actualResult = bookmarkManager.getSortedBookmarksByRating();
        List<Bookmark> expectedResult = Arrays.asList(bookmark1, bookmark2, bookmark3);

        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    public void ensureThatBookmarkAreSortedByDate(){
        // Arrange
        BookmarkManager bookmarkManager = new BookmarkManager();
        String url = "http://test.com/test";
        String url2 = "http://java.com";
        String url3 = "http://testing.at";

        Bookmark bookmark1 = new Bookmark(url);
        Bookmark bookmark2 = new Bookmark(url2);
        Bookmark bookmark3 = new Bookmark(url3);

        bookmarkManager.addBookmark(url);
        bookmarkManager.addBookmark(url2);
        bookmarkManager.addBookmark(url3);

        // Act
        List<Bookmark> actualResult = bookmarkManager.getSortedBookmarksByDate();
        List<Bookmark> expectedResult = Arrays.asList(bookmark3, bookmark2, bookmark1);

        // Assert
        assertIterableEquals(expectedResult, actualResult);
    }

}