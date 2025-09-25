package PLTW;

/*
Activity 1.3.2
*/

import java.util.Scanner;
 
public class GuessChecker
{
  static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
    /* Add any variables you will need throughout the program here. */
    
    // Generate a random number
    int targetNumber = getRandomNumber();
    //System.out.println(targetNumber);  // uncomment for debugging
    
    // Break the random number into four variables.
    int r1 = targetNumber / 1000;
    int r2 = targetNumber / 100 % 10;
    int r3 = targetNumber / 10 % 10;
    int r4 = targetNumber % 10;
    
    boolean isCorrect = true;
    boolean firstDigit = false;
    boolean secondDigit = false;
    boolean thirdDigit = false;
    boolean fourthDigit = false;
    while(isCorrect){
      // Get the user's guess
      int guess = getGuess();
      //System.out.println(guess);   // uncomment for debugging
      
      // Break the user's guess into four variables.
      int g1 = guess / 1000;
      int g2 = guess / 100 % 10;
      int g3 = guess / 10 % 10;
      int g4 = guess % 10;

      /*your code here*/
      if(r1 == g1){
          System.out.println("Yay! The first digit you guessed is correct.");
          firstDigit = true;
      } else {
          System.out.println("Oh no! The first digit you guessed is incorrect.");
      }
      if(r2 == g2){
          System.out.println("Yay! The second digit you guessed is correct.");
          secondDigit = true;
      } else {
          System.out.println("Oh no! The second digit you guessed is incorrect.");
      }
      if(r3 == g3){
          System.out.println("Yay! The third digit you guessed is correct.");
          thirdDigit = true;
      } else {
          System.out.println("Oh no! The third digit you guessed is incorrect.");
      }
      if(r4 == g4){
          System.out.println("Yay! The fourth digit you guessed is correct.");
          fourthDigit = true;
      } else {
          System.out.println("Oh no! The fourth digit you guessed is incorrect.");
      }
      if(firstDigit && secondDigit && thirdDigit && fourthDigit){
        isCorrect = false;
      }
    }
    System.out.println("Congratulations, you guessed the number correct!");
  }

 
  // Checks to ensure no duplicate digits in a int.
	public static boolean hasDupes(int num)
	{ 
		boolean[] digs = new boolean[10];
		while (num > 0)
		{
			if (digs[num % 10])
			  return true;
			digs[num % 10] = true;
			num /= 10;
		}
		return false;
	}

  // Creates a new random 4 digit code 1000-9999 with no duplicates.
  public static int getRandomNumber() 
  { 
		int target = (int) (Math.random() * 9000 + 1000);
		while (hasDupes(target))
		  target = (int) (Math.random() * 9000 + 1000);
    return target;
  }

  // Prompts the user for a guess and repeats until valid guess is made.
  public static int getGuess()
  { 

    int userGuess = 0;
    boolean validGuess = false;
    
    while (!validGuess)
    {
      System.out.print("Guess a 4-digit number from 1000 to 9999 with no duplicate digits: ");
      userGuess = sc.nextInt();
      if (!(hasDupes(userGuess) || (userGuess < 1000))) 
        validGuess = true;
    }
    return userGuess;
  }
}
