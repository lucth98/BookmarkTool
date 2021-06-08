package at.fhcampus.domain;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void ensureThatBookmarkMangerCanBeSaved() {
        // Arrange
        User user =new User();

        BookmarkManager bookmarkManager =user.getBookmarkManager();

        String url1 = "http://test.com/Test";
        String url2 = "http://tester.com/Test";
        String tag1 = "test";
        String tag2 = "tester";

        Bookmark bookmark1 =new Bookmark(url1,tag1);
        Bookmark bookmark2 =new Bookmark(url2,tag2);

        bookmarkManager.getBookmarkArrayList().add(bookmark1);
        bookmarkManager.getBookmarkArrayList().add(bookmark2);

        String fileName="file.txt";
        // Act &  Assert

        try {
            user.saveBookmarkManager(fileName);
        }catch (Exception e){
            System.out.println(e);
            fail();
        }
    }


    @Test
    public void ensureThatBookmarkMangerCanNotBeSaved1() {
        // Arrange
        User user =new User();

        BookmarkManager bookmarkManager =user.getBookmarkManager();

        String url1 = "http://test.com/Test";
        String url2 = "http://tester.com/Test";
        String tag1 = "test";
        String tag2 = "tester";

        Bookmark bookmark1 =new Bookmark(url1,tag1);
        Bookmark bookmark2 =new Bookmark(url2,tag2);

        bookmarkManager.getBookmarkArrayList().add(bookmark1);
        bookmarkManager.getBookmarkArrayList().add(bookmark2);

        String fileName=null;
        // Act &  Assert
        NullPointerException nullPointerException=assertThrows(NullPointerException.class,()-> {user.saveBookmarkManager(fileName);});
       // IOException ioException =assertThrows(IOException.class,()-> {user.saveBookmarkManager(fileName);});
//        try {
//            user.saveBookmarkManager(fileName);
//        }catch (Exception e){
//            System.out.println(e);
//            fail();
//        }
    }

    @Test
    public void ensureThatBookmarkMangerCanBeLoaded() {
        // Arrange
        User user =new User();

        BookmarkManager expectedResult =user.getBookmarkManager();
        BookmarkManager actualResult =user.getBookmarkManager();


        String url1 = "http://test.com/Test";
        String url2 = "http://tester.com/Test";
        String tag1 = "test";
        String tag2 = "tester";

        Bookmark bookmark1 =new Bookmark(url1,tag1);
        Bookmark bookmark2 =new Bookmark(url2,tag2);

        expectedResult.getBookmarkArrayList().add(bookmark1);
        expectedResult.getBookmarkArrayList().add(bookmark2);

        String fileName="testfile.txt";
        // Act

        try {
            user.saveBookmarkManager(fileName);
            actualResult=user.loadBookmarkManager(fileName);
        }catch (Exception e){
            System.out.println(e);
            fail();
        }
        //Assert
    assertEquals(expectedResult,actualResult);
    }








}