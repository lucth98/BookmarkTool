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
            System.out.println(user.getBookmarkManager().getBookmarkArrayList());
            return user.getBookmarkManager().getBookmark(input);
    }

    private String readLine(String message) {
        Scanner scanner =new Scanner(System.in);
        String input;
        do {
            System.out.println(message);
            input=scanner.nextLine();
            System.out.println(input);

        }while (input.equals(""));
        return input;
    }
}
