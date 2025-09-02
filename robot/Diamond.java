package robot;
import kareltherobot.*;
import java.util.*;


public class Diamond implements Directions{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        World.setVisible(true);// allows us to see the run output
        // the bigger the street, the farther north
        World.setSize(20,20);
        World.setDelay(10);

        // The line below creates a Robot that we will refer to as rob
        // Find out what the numbers and direction do!
        // Put rob in a better location for your initials.
        Robot rob = new Robot(15,2,South,100);

        // Want a second robot?  No prob.  They are cheap :)
        //Robot dude = new Robot(7,5,West,9);
        // examples of commands you can invoke on a Robot
        System.out.println("Enter the length of the diamond: ");
        int length = Integer.parseInt(scanner.nextLine());
        if(length > 8){
            System.out.println("The number you entered won't work. Pleaase enter a new number less than or equal to 8: ");
            length = Integer.parseInt(scanner.nextLine());
        }
        int i = 0;
        for(i = 0; i  < 4; i++){
            rob.move();
        }
        rob.putBeeper(); //1
        for(i = 0; i < length; i++){
            rob.move();
            rob.turnLeft();
            rob.move();            
            rob.putBeeper(); //2
            turnRight(rob);
        }
        
        turnRight(rob);
        turnRight(rob);

        for(i = 0; i < length; i++){
            rob.move();
            turnRight(rob);
            rob.move();
            rob.putBeeper();
            rob.turnLeft();
        }
        for(i = 0; i < length; i++){
            rob.move();
            rob.turnLeft();
            rob.move();
            rob.putBeeper();
            turnRight(rob);
        }
        rob.turnLeft();
        for(i = 0; i < length; i++){
            rob.move();
            rob.turnLeft();
            rob.move();
            rob.putBeeper();
            turnRight(rob);
        } 
        rob.move();   
    }       
    public static void turnRight(Robot rob){
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
    }
}
