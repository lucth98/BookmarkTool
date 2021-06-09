package at.fhcampus.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

//import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
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


    }

    @Test
    public void ensureThatBookmarkMangerCanNotBeSaved2() {
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

        String fileName="";
        // Act &  Assert
         IOException ioException =assertThrows(IOException.class,()-> {user.saveBookmarkManager(fileName);});

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



    @Test
    public void ensureThatBookmarkMangerCanNotBeLoaded1() {
        // Arrange
        User user =new User();
        String fileName="NoFile.txt";
        // Act & Assert

        FileNotFoundException fileNotFoundException=assertThrows(FileNotFoundException.class,()-> {user.loadBookmarkManager(fileName);});
    }

    @Test
    public void ensureThatBookmarkMangerCanNotBeLoaded2() {
        // Arrange
        User user =new User();
        String fileName="";
        // Act & Assert

        FileNotFoundException fileNotFoundException=assertThrows(FileNotFoundException.class,()-> {user.loadBookmarkManager(fileName);});
    }

    @Test
    public void ensureThatBookmarkMangerCanNotBeLoaded3() {
        // Arrange
        User user =new User();
        String fileName=null;

        // Act & Assert

        NullPointerException nullPointerException=assertThrows(NullPointerException.class,()-> {user.loadBookmarkManager(fileName);});
    }

    @Test
    public void ensureThatBookmarkMangerCanBeRestored() {
        // Arrange
        User user =new User();
        User newuser =new User();

        BookmarkManager expectedResult =user.getBookmarkManager();
        BookmarkManager actualResult ;


        String url1 = "http://test.com/Test";
        String url2 = "http://tester.com/Test";
        String tag1 = "test";
        String tag2 = "tester";

        Bookmark bookmark1 =new Bookmark(url1,tag1);
        Bookmark bookmark2 =new Bookmark(url2,tag2);

        expectedResult.getBookmarkArrayList().add(bookmark1);
        expectedResult.getBookmarkArrayList().add(bookmark2);

        String fileName="backUpFile.txt";
        // Act

        try {
            user.saveBookmarkManager(fileName);
            newuser.restoreBookmarks(fileName);
            actualResult=newuser.getBookmarkManager();
            //Assert
            assertEquals(expectedResult,actualResult);

        }catch (Exception e){
            System.out.println(e);
            fail();
        }

    }



//
//
//    @Test
//    public void testThatStreamClosesSaveing() {
//        User user =new User();
//
//
//        BookmarkManager bookmarkManager =user.getBookmarkManager();
//
//        String url1 = "http://test.com/Test";
//        String url2 = "http://tester.com/Test";
//        String tag1 = "test";
//        String tag2 = "tester";
//
//
//        Bookmark bookmark1 =new Bookmark(url1,tag1);
//        Bookmark bookmark2 =new Bookmark(url2,tag2);
//
//        bookmarkManager.getBookmarkArrayList().add(bookmark1);
//        bookmarkManager.getBookmarkArrayList().add(bookmark2);
//
//        String fileName="newfile.txt";
//        // Act &  Assert
//
//        try {
//
//
//            user.saveBookmarkManager(fileName);
//            ObjectOutputStream result =user.getSpyedObjectOutputStream();
//
//         verify(user.spyedObjectOutputStream,times(1)).close();
//
//        }catch (Exception e){
//            System.out.println(e);
//            fail();
//        }
//    }










}