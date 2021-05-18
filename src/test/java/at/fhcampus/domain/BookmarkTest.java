package at.fhcampus.domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

class BookmarkTest {

    @Test
    public void ensureUrlIsSecure() {
        // Arrange
        String url = "https://test.com/Test";
        // Act
        boolean actualResult = new Bookmark(url).isSecure();
        // Assert
        assertTrue(actualResult);
    }

    @Test
    public void ensureUrlIsInSecure() {
        // Arrange
        String url = "http://test.com/Test";
        // Act
        boolean actualResult = new Bookmark(url).isSecure();
        // Assert
        assertFalse(actualResult);
    }


    @Test
    public void testThatTowBookmarksAreEquals() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        Bookmark expectedValue = new Bookmark();

        String url = "https://test.com/Test";
        ArrayList<String> tags = new ArrayList<>();
        tags.add("test");
        LinkedHashSet<Bookmark> associates = new LinkedHashSet<>();
        associates.add(new Bookmark("https://test.com/Test/tests", "test"));
        int rating = 0;
        boolean secure = true;


        actualValue.setRating(rating);
        actualValue.setAssociates(associates);
        actualValue.setSecure(secure);
        actualValue.setUrl(url);
        actualValue.setTags(tags);

        expectedValue.setRating(rating);
        expectedValue.setAssociates(associates);
        expectedValue.setSecure(secure);
        expectedValue.setUrl(url);
        expectedValue.setTags(tags);

        // Act & Assert
        assertEquals(actualValue, expectedValue);

    }

    @Test
    public void testThatTowBookmarksAreEquals2() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        Bookmark expectedValue = new Bookmark();

        String url = "https://test.com/Test";
        ArrayList<String> tags = new ArrayList<>();
        tags.add("test");
        LinkedHashSet<Bookmark> associates = new LinkedHashSet<>();
        associates.add(new Bookmark("https://test.com/Test/tests", "test"));

        LinkedHashSet<Bookmark> associates2 = new LinkedHashSet<>();
        associates2.add(new Bookmark("https://test.com/Test/tests", "test"));
        int rating = 0;
        boolean secure = true;


        actualValue.setRating(rating);
        actualValue.setAssociates(associates);
        actualValue.setSecure(secure);
        actualValue.setUrl(url);
        actualValue.setTags(tags);

        expectedValue.setRating(rating);
        expectedValue.setAssociates(associates2);
        expectedValue.setSecure(secure);
        expectedValue.setUrl(url);
        expectedValue.setTags(tags);

        // Act & Assert
        assertEquals(actualValue, expectedValue);

    }


    @Test
    public void testThatTowBookmarksAreEquals3() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        Bookmark expectedValue = new Bookmark();

        String url = "https://test.com/Test";
        ArrayList<String> tags = new ArrayList<>();
        tags.add("test");


        ArrayList<String> tags2 = new ArrayList<>();
        tags2.add("test");
        LinkedHashSet<Bookmark> associates = new LinkedHashSet<>();
        associates.add(new Bookmark("https://test.com/Test/tests", "test"));

        int rating = 0;
        boolean secure = true;


        actualValue.setRating(rating);
        actualValue.setAssociates(associates);
        actualValue.setSecure(secure);
        actualValue.setUrl(url);
        actualValue.setTags(tags);

        expectedValue.setRating(rating);
        expectedValue.setAssociates(associates);
        expectedValue.setSecure(secure);
        expectedValue.setUrl(url);
        expectedValue.setTags(tags2);

        // Act & Assert
        assertEquals(actualValue, expectedValue);

    }
    @Test
    public void testThatOneBookmarksAreEquals() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        // Act & Assert
        assertEquals(actualValue, actualValue);

    }

    @Test
    public void testThatTowBookmarksAreNotEquals() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        Bookmark expectedValue = new Bookmark();

        String url = "https://test.com/Test";
        ArrayList<String> tags = new ArrayList<>();
        tags.add("test");
        LinkedHashSet<Bookmark> associates = new LinkedHashSet<>();
        associates.add(new Bookmark("https://test.com/Test/tests", "test"));
        int rating = 0;
        boolean secure = true;


        actualValue.setRating(rating);
        actualValue.setAssociates(associates);
        actualValue.setSecure(secure);
        actualValue.setUrl(url);
        actualValue.setTags(tags);

        expectedValue.setRating(rating);
        expectedValue.setAssociates(associates);
        expectedValue.setSecure(secure);
        expectedValue.setUrl("url");
        expectedValue.setTags(tags);

        // Act & Assert
        assertNotEquals(actualValue, expectedValue);

    }

    @Test
    public void testThatTowBookmarksAreNotEquals2() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        Bookmark expectedValue = new Bookmark();

        String url = "https://test.com/Test";
        ArrayList<String> tags = new ArrayList<>();
        tags.add("test");
        LinkedHashSet<Bookmark> associates = new LinkedHashSet<>();
        associates.add(new Bookmark("https://test.com/Test/tests", "test"));
        int rating = 0;
        boolean secure = true;


        actualValue.setRating(rating);
        actualValue.setAssociates(associates);
        actualValue.setSecure(secure);
        actualValue.setUrl(url);
        actualValue.setTags(tags);

        expectedValue.setRating(rating);
        expectedValue.setAssociates(associates);
        expectedValue.setSecure(secure);
        expectedValue.setUrl(url);
        expectedValue.setTags(new ArrayList<String>());

        // Act & Assert
        assertNotEquals(actualValue, expectedValue);

    }

    @Test
    public void testThatTowBookmarksAreNotEquals3() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        Bookmark expectedValue = new Bookmark();

        String url = "https://test.com/Test";
        ArrayList<String> tags = new ArrayList<>();
        tags.add("test");
        LinkedHashSet<Bookmark> associates = new LinkedHashSet<>();
        associates.add(new Bookmark("https://test.com/Test/tests", "test"));
        int rating = 0;
        boolean secure = true;


        actualValue.setRating(rating);
        actualValue.setAssociates(associates);
        actualValue.setSecure(secure);
        actualValue.setUrl(url);
        actualValue.setTags(tags);

        expectedValue.setRating(rating);
        expectedValue.setAssociates(associates);
        expectedValue.setSecure(false);
        expectedValue.setUrl(url);
        expectedValue.setTags(tags);

        // Act & Assert
        assertNotEquals(actualValue, expectedValue);

    }


    @Test
    public void testThatTowBookmarksAreNotEquals4() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        Bookmark expectedValue = new Bookmark();

        String url = "https://test.com/Test";
        ArrayList<String> tags = new ArrayList<>();
        tags.add("test");
        LinkedHashSet<Bookmark> associates = new LinkedHashSet<>();
        associates.add(new Bookmark("https://test.com/Test/tests", "test"));
        int rating = 0;
        boolean secure = true;


        actualValue.setRating(rating);
        actualValue.setAssociates(associates);
        actualValue.setSecure(secure);
        actualValue.setUrl(url);
        actualValue.setTags(tags);

        expectedValue.setRating(rating);
        expectedValue.setAssociates(new LinkedHashSet<Bookmark>());
        expectedValue.setSecure(secure);
        expectedValue.setUrl(url);
        expectedValue.setTags(tags);

        // Act & Assert
        assertNotEquals(actualValue, expectedValue);

    }


    @Test
    public void testThatTowBookmarksAreNotEqual5() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        Bookmark expectedValue = new Bookmark();

        String url = "https://test.com/Test";
        ArrayList<String> tags = new ArrayList<>();
        tags.add("test");
        LinkedHashSet<Bookmark> associates = new LinkedHashSet<>();
        associates.add(new Bookmark("https://test.com/Test/tests", "test"));
        int rating = 0;
        boolean secure = true;

        actualValue.setRating(rating);
        actualValue.setAssociates(associates);
        actualValue.setSecure(secure);
        actualValue.setUrl(url);
        actualValue.setTags(tags);

        expectedValue.setRating(1000);
        expectedValue.setAssociates(associates);
        expectedValue.setSecure(secure);
        expectedValue.setUrl(url);
        expectedValue.setTags(tags);
        // Act & Assert
        assertNotEquals(actualValue, expectedValue);
    }

    @Test
    public void testThatTowBookmarksAreNotEqual6() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        Bookmark expectedValue = null;
        // Act & Assert
        assertNotEquals(actualValue, expectedValue);
    }

    @Test
    public void testThatTowBookmarksAreNotEqual7() {
        // Arrange
        Bookmark actualValue = new Bookmark();
        String expectedValue = null;
        // Act & Assert
        assertNotEquals(actualValue, expectedValue);

    }

    @Test
    public void testToString() {
        // Arrange
        Bookmark bookmark = new Bookmark();
        String expectedValue = "Bookmark{url='null', tags=null, associates=null, rating=0, secure=false, addingTime=null}";
        // Act
        String actualValue=bookmark.toString();
        System.out.println(bookmark);
        // Assert
        assertEquals(actualValue, expectedValue);
    }


}