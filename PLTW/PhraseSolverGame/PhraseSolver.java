package PLTW.PhraseSolverGame;

import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */

  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved;

  /* your code here - constructor(s) */ 
  public PhraseSolver (){
    player1 = null;
    player2 = null;
    board = new Board();
    solved = false;
  }

  public void play()
  {
    boolean solved = false;
    Scanner scanner = new Scanner(System.in);
    
    boolean correct = true;

    System.out.println("Enter player 1's name: ");
    String name1 = scanner.nextLine();
    System.out.println("Enter player 2's name: ");
    String name2 = scanner.nextLine();
    player1 = new Player(name1);
    player2 = new Player(name2);

    Player currentPlayer = player1;


    while (!solved) 
    {
      
      /* your code here - game logic */
      
      System.out.println("Current player " + currentPlayer.getPlayerName());
      System.out.println("Your phrase to solve is " + board.getPhraseToSolve());
      System.out.println("Enter your guess: ");
      String guess = scanner.nextLine();
      boolean isSolved = board.isSolved(guess);
      boolean correctGuess = board.guessLetter(guess);

      if(isSolved){
        System.out.println("You have solved the phrase. Good job! Bye bye.");
        break;
      }

      System.out.println("Your phrase right now is " + board.getPhraseToSolve());
      
      if(currentPlayer == player1){
        currentPlayer = player2;
      } else {
        currentPlayer = player1;
      }
      
      /* your code here - determine how game ends */
      if(board.getPhraseToSolve().indexOf("_") == -1){
        System.out.println("You have solved the phrase. Good job! Bye bye.");
        solved = true;;
      }
    } 
   
  }
}