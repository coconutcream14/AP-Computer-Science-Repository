package PLTW.PhraseSolverGame;

import java.util.Scanner;

public class Player
{
  /* your code here - attributes */

    private String playerName;
    private int points;


  /* your code here - constructor(s) */ 

  public Player(){
    Scanner scanner = new Scanner(System.in);
    String playerName = scanner.nextLine();
    this.playerName = playerName;
    points = 0;
    System.out.println("Welcome " + playerName + " to the game.");
    scanner.close();
  }

  public Player(String inputName){
    playerName = inputName;
    points = 0;
    System.out.println("Welcome " + playerName + " to the game.");
  }
  
  /* your code here - accessor(s) */ 

  public String getPlayerName(){
    return playerName;
  }
  public int getPoints(){
    return points;
  }

  /* your code here - mutator(s) */ 

  public void setPoints(int points){
    this.points = points;
  }
  
  public void setPlayerName(String name){
    playerName = name;
  }

}
