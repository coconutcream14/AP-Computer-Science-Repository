package PLTW;

import java.io.InputStream;
import java.util.*;
public class Scanner {
    public Scanner(InputStream in) {
        //TODO Auto-generated constructor stub
    }

    public static void main (String [] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter player 1's name here: ");
        String name1 =  scanner.nextLine();
        System.out.println("Enter player 2's name here: ");
        String name2 = scanner.nextLine();
        System.out.println("Enter player 1's age here: ");
        int age1 = scanner.nextInt();
        System.out.println("Enter player 2's age here: ");
        int age2 = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        System.out.println("Welcome " + name1 + " to the game! " + "We are delighted to have someone who is " + age1 + " years old.");
        System.out.println("Welcome " + name2 + " to the game! " + "We are delighted to have someone who is " + age2 + " years old.");
    }

    public String nextLine() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextLine'");
    }
}