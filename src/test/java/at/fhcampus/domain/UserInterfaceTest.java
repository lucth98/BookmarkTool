package at.fhcampus.domain;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;



class UserInterfaceTest {


        //test if scanner cann be set
    @Test
    public void testIfScannerCannBeSet() {
        // Arrange

        Main main=new Main();

        String expectedResult="test";
        String actualResult="";

        String data = expectedResult+"\r\n";
        InputStream inputStream = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            // Act
             actualResult =main.read();

            //Assert

            assertEquals(expectedResult,actualResult);

        } catch (Exception e){
            System.setIn(inputStream);
            System.out.println(e);
            fail();
        }
        finally {
            System.setIn(inputStream);
            System.out.println(actualResult);
        }
    }

    @Test
    public void TestReadLine() {
        // Arrange

        Main main=new Main();

        String expectedResult="test";
        String actualResult="";

        String data ="\r\n"+"\r\n"+"\r\n"+ expectedResult+"\r\n";
        InputStream inputStream = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            // Act
            actualResult =main.readLine("testing");

            //Assert

            assertEquals(expectedResult,actualResult);

        } catch (Exception e){
            System.setIn(inputStream);
            System.out.println(e);
            fail();
        }
        finally {
            System.setIn(inputStream);
            System.out.println(actualResult);
        }
    }


    @Test
    public void testUserCreation(){
        // Arrange

        Main main=new Main();

        String scannerInput="testUser";

        User actualResult=null;
        User expectedResult=new User();
        expectedResult.setUsername(scannerInput);


        String data = scannerInput+"\r\n"+"g,gre,ger"+"\n";
        InputStream inputStream = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            // Act
            actualResult =main.generateUser();

            //Assert

            assertEquals(expectedResult,actualResult);

        } catch (Exception e){
            System.setIn(inputStream);
            System.out.println(actualResult);
            System.out.println(e);
            fail();
        }
        finally {
            System.setIn(inputStream);
            System.out.println(actualResult);
        }
    }





    @Test
    public void testBookmarkgeneration(){

        // Arrange
        Main main=new Main();
        User user=new User();
        user.setUsername("test");


        String url = "https://test.com/test";

        String scannerInput=url;

        String actualResult="";
        String expectedResult=url;

        Bookmark bookmark=null;


        String data = scannerInput+"\r\n"+"blablabla"+"\n";
        InputStream inputStream = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            // Act
            bookmark =main.generateBookmark(user);
            actualResult=bookmark.getUrl();
            //Assert

            assertEquals(expectedResult,actualResult);

        } catch (Exception e){
            System.setIn(inputStream);
            System.out.println(actualResult);
            System.out.println(e);
            fail();
        }
        finally {
            System.setIn(inputStream);
            System.out.println(actualResult);
        }
    }





    @Test
    public void TestReadLineOutput() {

        // Arrange
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream originalPrintStream = System.out;

        Main main=new Main();

        String expectedResult="test";
        String actualResult="";

        String data = expectedResult+"\r\n";
        InputStream inputStream = System.in;
        try {

            System.setOut(new PrintStream(byteArrayOutputStream));
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            // Act
            expectedResult= "testing";
            main.readLine(expectedResult);
            actualResult=byteArrayOutputStream.toString().replaceAll("\\s", "");
            expectedResult.replaceAll("\\s", "");
            //Assert
            assertEquals(expectedResult,actualResult);
        } catch (Exception e){
            System.setIn(inputStream);
            System.setOut(originalPrintStream);
            System.out.println(e);
            fail();
        }
        finally {
            System.setIn(inputStream);
            System.setOut(originalPrintStream);
            System.out.println(actualResult);
            System.out.println(expectedResult);
        }
    }


}