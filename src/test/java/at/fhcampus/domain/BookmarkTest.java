package at.fhcampus.domain;

import org.junit.jupiter.api.*;

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

}