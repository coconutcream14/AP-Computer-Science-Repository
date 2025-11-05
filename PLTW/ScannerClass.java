package PLTW;

import java.util.*;
public class ScannerClass {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player 1's name here: ");
        String name1 =  scanner.nextLine();
        System.out.println("Enter player 2's name here: ");
        String name2 = scanner.nextLine();
        System.out.println("Enter player 1's age here: ");
        int age1 = scanner.nextInt();
        System.out.println("Enter player 2's age here: ");
        int age2 = scanner.nextInt();
        
        System.out.println("Welcome " + name1 + " to the game! " + "We are delighted to have someone who is " + age1 + " years old.");
        System.out.println("Welcome " + name2 + " to the game! " + "We are delighted to have someone who is " + age2 + " years old.");
    }
}