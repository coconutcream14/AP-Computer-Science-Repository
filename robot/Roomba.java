package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    // Main method to make this self-contained
    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        //String worldName = "robot/basicRoom.wld";
        String worldName = "robot/testWorld1.wld";

        Roomba cleaner = new Roomba();
        //int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
        int totalBeepers = cleaner.cleanRoom(worldName, 25, 11);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

    }

    // declared here so it is visible in all the methods!
    private Robot roomba;

    // You will need to add many variables!!

    public int cleanRoom(String worldName, int startX, int startY) {

        // A new Robot should be constructed and assigned to the global (instance)
        // variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

        World.readWorld(worldName);
        World.setVisible(true);
        World.setDelay(0);
        roomba = new Robot(startX, startY, East, 0);

        /**
         * This section will have all the logic that takes the Robot to every location
         * and cleans up all piles of beepers. Think about ways you can break this
         * large, complex task into smaller, easier to solve problems.
         */

        // the line below causes a null pointer exception
        // what is that and why are we getting it?
        int totalBeepers = 0;
        int i = 0;
        int max = 0;
        int numOfBeepers = 0;
        int numOfPiles = 0;
        int numOfSpaces = 1;
        while (true) {
            numOfBeepers = 0;
            if (!roomba.nextToABeeper()) {
                roomba.move();
                numOfSpaces++;
            }
            while (roomba.nextToABeeper()) {
                roomba.pickBeeper();
                numOfBeepers++;
                if(numOfBeepers > max){
                    max = numOfBeepers;
                }
                totalBeepers++;
            }
            if (numOfBeepers > 0) {
                numOfPiles++;
            }
            if (!roomba.frontIsClear()) {
                i++;
                if (i % 2 == 1) {
                    roomba.turnLeft();
                    if (!roomba.frontIsClear()) {
                        break;
                    }
                    roomba.move();
                    numOfSpaces++;
                    roomba.turnLeft();
                } else {
                    roomba.turnLeft();
                    roomba.turnLeft();
                    roomba.turnLeft();
                    if (!roomba.frontIsClear()) {
                        break;
                    }

                    roomba.move();
                    numOfSpaces++;
                    roomba.turnLeft();
                    roomba.turnLeft();
                    roomba.turnLeft();
                }
            }                
        }
        /*
         * roomba.move();
         * roomba.move();
         * while (roomba.nextToABeeper()){
         * 
         * roomba.pickBeeper();
         * totalBeepers++;
         * }
         * 
         * roomba.move();
         * 
         * while (roomba.nextToABeeper()){
         * 
         * roomba.pickBeeper();
         * totalBeepers++;
         * }
         */

        // This method should return the total number of beepers cleaned up.
        System.out.println("The total number of spaces is " + numOfSpaces);
        System.out.println("The number of piles is " + numOfPiles);
        System.out.println("The max beepers is " + max);
        return totalBeepers;
    }
}
