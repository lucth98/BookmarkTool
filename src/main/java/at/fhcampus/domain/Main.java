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
        Scanner scanner =new Scanner(System.in);
        User user=new User();
        String input="";
        do {
            System.out.println("Please Type username:");
            input=scanner.nextLine();

            System.out.println(input);
        }while (input.equals(""));

        user.setUsername(input);
        return user;

    }


    public Bookmark generateBookmark(User user)throws NoSuchElementException {

            Scanner scanner =new Scanner(System.in);

            String input="";
            do {
                System.out.println("Please Type url for Bookmark:");
                input=scanner.nextLine();
                System.out.println(input);

            }while (input.equals(""));
            user.getBookmarkManager().addBookmark(input);
            System.out.println(user.getBookmarkManager().getBookmarkArrayList());


            return user.getBookmarkManager().getBookmark(input);


    }
}
