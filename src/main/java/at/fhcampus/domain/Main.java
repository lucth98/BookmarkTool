package at.fhcampus.domain;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    //test if scanner cann be set
    public String read(){
        Scanner scanner =new Scanner(System.in);
        return scanner.nextLine();
    }

    public User generateUser() {
        User user=new User();
        String input=readLine("Please Type username:");
        user.setUsername(input);
        return user;

    }


    public Bookmark generateBookmark(User user)throws NoSuchElementException {
            String input="";
            input = readLine("Please Type url for Bookmark:");
            user.getBookmarkManager().addBookmark(input);
       //     System.out.println(user.getBookmarkManager().getBookmarkArrayList());
            return user.getBookmarkManager().getBookmark(input);
    }

    public String readLine(String message) {
        Scanner scanner =new Scanner(System.in);
        String input;
        do {
            System.out.println(message);
            input=scanner.nextLine();
        //  System.out.println(input);

        }while (!input.equals(""));
        return input;
    }

//    public String menu(User user) {
//        String input =readLine("1:save Url ;2:delete Url;3;$");
//        String arguments=readLine("please write URL");;
//        switch (input){
//            case "1":
//                 //arguments =readLine("please write URL");
//                user.getBookmarkManager().addBookmark(arguments);
//
//                break;
//            case "2":
//               //  arguments =readLine("please write URL");
//                user.getBookmarkManager().removeBookmark(arguments);
//                break;
//
//
//        }
//
//
//
//        return input;
//    }
}
