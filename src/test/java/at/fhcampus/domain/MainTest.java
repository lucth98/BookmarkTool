package at.fhcampus.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class MainTest {


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
        String data = scannerInput+"\r\n";
        InputStream inputStream = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            // Act
            actualResult =main.generateUser();

            //Assert

            assertEquals(scannerInput,actualResult);

        } catch (Exception e){
            System.setIn(inputStream);
            System.out.println(e);
        }
        finally {
            System.setIn(inputStream);
            System.out.println(actualResult);
        }



    }







}