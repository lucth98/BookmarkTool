package at.fhcampus.domain;

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
            input=scanner.nextLine();
            System.out.println(input);

        }while (input.equals(""));

        user.setUsername(input);
        return user;

    }
}
