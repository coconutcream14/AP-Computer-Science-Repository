package PLTW;
import java.util.*;
/*
Activity 1.2.7
*/

public class Concatenator
{
  public static void main(String [] args){
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    String concatenatedString = "";
    int lengthOfs1 = s1.length();
    int lengthOfs2 = s2.length();

    String part1 = s1.substring(0, lengthOfs1/2);
    String part2 = s2.substring(lengthOfs2/2);
    
    concatenatedString = part1 + part2;

    System.out.println(concatenatedString);
  } 
}