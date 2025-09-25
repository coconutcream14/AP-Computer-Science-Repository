package PLTW;

/*
Activity 1.3.5
*/

import java.util.Scanner;

public class CompoundBoolean
{
  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in); 
    
    System.out.print("Enter the first number: ");
    int a = scanner.nextInt(); 
    System.out.print("Enter the second number: ");
    int b = scanner.nextInt();
    System.out.print("Enter the third number: ");
    int c = scanner.nextInt();
    
    //Code for (!((a > b) || (b > c))) statement (! operator)
    if(!((a > b) || (b > c))){
        // "If a < b OR b < c, then this statement is TRUE"
        System.out.println("If " + a + " < " + b + " OR " + b " < " + c + ", then this statement is TRUE.");
    } else{
        System.out.println("Sorry, your numbers didn't meet the condition. Your answer is FALSE.");
    }

    // Code for ((a > b) && (b > c)) statement (&& operator)
    if((a > b) && (b > c)){
        // "If a > b AND b > c, then this statement is TRUE"
        System.out.println("If " + a + " > " + b + " AND " + b + " > " + c + ", then this statement is TRUE.");
    } else {
        System.out.println("Sorry, your numbers didn't meet the condition. Your answer is FALSE.");
    }
    
    //Code for ((a > b) || (b > c)) statement (|| operator)
    if((a > b) || (b > c)){
        // "If a > b OR b > c, then this statement is TRUE"
        System.out.println("If " + a + " > " + b + " OR " + b + " > " + c + ", then this statement is TRUE.");
    } else{
        System.out.println("Sorry, your numbers didn't meet the condition. Your answer is FALSE.");
    }
    
    
    // close Scanner when done
    scanner.close();
  }
}
