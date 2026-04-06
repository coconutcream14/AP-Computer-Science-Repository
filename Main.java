import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Step 1: Parse the input
        Scanner scanner = new Scanner(System.in);
        String[] p1Ary = scanner.nextLine().trim().split(" ");
        String[] p2Ary = scanner.nextLine().trim().split(" ");
        String[] drawAry = scanner.nextLine().trim().split(" ");
        int length = p1Ary.length;
        int i = 0;
        ArrayList<ArrayList<Integer>> p1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> p2 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> drawPile = new ArrayList<ArrayList<Integer>>();
        for (i = 0; i < length; i++) {
            // player 1 arylist building
            ArrayList<Integer> row = new ArrayList<Integer>();
            int num = 0;
            int suit = 0;
            int ascii_1 = (int) p1Ary[i].charAt(0);
            int ascii_2 = (int) p1Ary[i].charAt(1);
            if (ascii_1 < 65) {
                num = Integer.parseInt(p1Ary[i].substring(0, 1));
            } else {
                if (ascii_1 == 65) { // ace
                    num = 1;
                } else if (ascii_1 == 84) { // ten
                    num = 10;
                } else if (ascii_1 == 74) { // jack
                    num = 11;
                } else if (ascii_1 == 81) { // queen
                    num = 12;
                } else if (ascii_1 == 75) { // king
                    num = 13;
                }
            }
            if (ascii_2 == 67) { // clubs
                suit = 2;
            } else if (ascii_2 == 68) { // diamonds
                suit = 1;
            } else if (ascii_2 == 72) { // hearts
                suit = 3;
            } else { // spades
                suit = 4;
            }
            row.add(num);
            row.add(suit);
            p1.add(row);

            // player 2 arylist building
            ArrayList<Integer> row1 = new ArrayList<Integer>();
            num = 0;
            suit = 0;
            ascii_1 = (int) p2Ary[i].charAt(0);
            ascii_2 = (int) p2Ary[i].charAt(1);
            if (ascii_1 < 65) {
                num = Integer.parseInt(p2Ary[i].substring(0, 1));
            } else {
                if (ascii_1 == 65) { // ace
                    num = 1;
                } else if (ascii_1 == 84) { // ten
                    num = 10;
                } else if (ascii_1 == 74) { // jack
                    num = 11;
                } else if (ascii_1 == 81) { // queen
                    num = 12;
                } else if (ascii_1 == 75) { // king
                    num = 13;
                }
            }
            if (ascii_2 == 67) { // clubs
                suit = 2;
            } else if (ascii_2 == 68) { // diamonds
                suit = 1;
            } else if (ascii_2 == 72) { // hearts
                suit = 3;
            } else { // spades
                suit = 4;
            }
            row1.add(num);
            row1.add(suit);
            p2.add(row1);
        }

        // draw pile arylist building
        length = drawAry.length;
        for (i = 0; i < length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            int num = 0;
            int suit = 0;
            int ascii_1 = (int) drawAry[i].charAt(0);
            int ascii_2 = (int) drawAry[i].charAt(1);
            if (ascii_1 < 65) {
                num = Integer.parseInt(drawAry[i].substring(0, 1));
            } else {
                if (ascii_1 == 65) { // ace
                    num = 1;
                } else if (ascii_1 == 84) { // ten
                    num = 10;
                } else if (ascii_1 == 74) { // jack
                    num = 11;
                } else if (ascii_1 == 81) { // queen
                    num = 12;
                } else if (ascii_1 == 75) { // king
                    num = 13;
                }
            }
            if (ascii_2 == 67) { // clubs
                suit = 2;
            } else if (ascii_2 == 68) { // diamonds
                suit = 1;
            } else if (ascii_2 == 72) { // hearts
                suit = 3;
            } else { // spades
                suit = 4;
            }
            row.add(num);
            row.add(suit);
            drawPile.add(row);
        }
        // (FOR DEBUG) player 1 arraylist values printed
        /*
         * for(i = 0; i < 7; i++){
         * System.out.println(p1.get(i).get(0) + " " + p1.get(i).get(1));
         * }
         * System.out.println();
         */
        // (FOR DEBUG) player 2 arraylist values printed
        /*
         * for(i = 0; i < 7; i++){
         * //System.out.println(p2Ary[i]);
         * System.out.println(p2.get(i).get(0) + " " + p2.get(i).get(1));
         * }
         */

        // Step 2: Make 8 piles
        int[][] piles = new int[8][2];
        for (i = 0; i < 8; i += 2) {
            int num = drawPile.get(0).get(0);
            int suit = drawPile.get(0).get(1);
            piles[i][0] = num;
            piles[i][1] = suit;
            drawPile.remove(0);
        }
        // (FOR DEBUG) piles values get printed
        /*
         * for(i = 0; i < 8; i++){
         * System.out.println(piles[i][0] + " " + piles[i][1]);
         * }
         */
        // (FOR DEBUG) draw pile arraylist values printed
        /*
         * System.out.println();
         * for(i = 0; i < drawPile.size(); i++){
         * System.out.println(drawPile.get(i).get(0) + " " + drawPile.get(i).get(1));
         * }
         */
        // Step 3:
        int value = 0;
        while (true) {
            boolean moveMadeThisRound = false;

            // Player 1's turn
            if(value % 2 == 0){
                for (int x = 0; x < p1.size(); x++) { // for p1's hand
                    int p1CardRank = p1.get(x).get(0);
                    int p1CardSuit = p1.get(x).get(1);

                    boolean p1PlayedCard = false;
                    if (p1CardRank == 13) {
                        for (int y = 1; y < 8; y += 2) {
                            if (piles[y][0] == 0) {
                                piles[y][0] = p1CardRank;
                                piles[y][1] = p1CardSuit;
                                p1.remove(x);
                                p1PlayedCard = true;
                                break;
                            }
                        }
                    } else {
                        for (int y = 0; y < 8; y++) {
                            if (piles[y][0] != 0 && piles[y][0] == p1CardRank + 1 && piles[y][1] % 2 != p1CardSuit % 2) {
                                piles[y][0] = p1CardRank;
                                piles[y][1] = p1CardSuit;
                                p1.remove(x);
                                p1PlayedCard = true;
                                break;
                            }
                        }
                    }
                    if (p1PlayedCard) {
                        moveMadeThisRound = true;
                        x = -1;
                    }
                }
                // ending turn: drawing a card
                // p1.add(new ArrayList<Integer>());
                if (drawPile.size() > 0) {
                    p1.add(drawPile.get(0));
                    drawPile.remove(0);
                }
            }
            // Player 2's turn
            else {
                for(int x = 0; x < p2.size(); x++){
                    int p2CardRank = p2.get(x).get(0);
                    int p2CardSuit = p2.get(x).get(1);

                    boolean p2PlayedCard = false;
                    if(p2CardRank == 13) {
                        for(int y = 1; y < 8; y += 2) {
                            if(piles[y][0] == 0){
                                piles[y][0] = p2CardRank; piles[y][1] = p2CardSuit; p2.remove(x);
                                p2PlayedCard = true; break;
                            }
                        }
                    } else {
                        for(int y = 0; y < 8; y++){
                            if(piles[y][0] != 0 && piles[y][0] == p2CardRank + 1 && piles[y][1] % 2 != p2CardSuit % 2){
                                piles[y][0] = p2CardRank; piles[y][1] = p2CardSuit; p2.remove(x);
                                p2PlayedCard = true; break;
                            }
                        }
                    }
                    if(p2PlayedCard) {
                        moveMadeThisRound = true; 
                        x = -1;
                    }
                }
                // ending turn: drawing a card
                // p2.add(new ArrayList<Integer>());
                if (drawPile.size() > 0) {
                    p2.add(drawPile.get(0));
                    drawPile.remove(0);
                }
            }
            value++;
            if(!moveMadeThisRound && drawPile.isEmpty()){
                break;
            }
        }
        String result = "";
        for (i = 0; i < 8; i++) {
            int num = piles[i][0];
            int suit = piles[i][1];
            String numString = "";
            String suitString = "";
            if (num == 0 && suit == 0)
                numString = "E";
            suitString = "";
            if (num < 10 && num > 1) {
                numString = String.valueOf(num);
            } else {
                if (num == 1) { // ace
                    numString = "A";
                } else if (num == 10) { // ten
                    numString = "T";
                } else if (num == 11) { // jack
                    numString = "J";
                } else if (num == 12) { // queen
                    numString = "Q";
                } else if (num == 13) { // king
                    numString = "K";
                }
            }
            if (suit == 2) { // clubs
                suitString = "C";
            } else if (suit == 1) { // diamonds
                suitString = "D";
            } else if (suit == 3) { // hearts
                suitString = "H";
            } else if (suit == 4) { // spades
                suitString = "S";
            }
            result = result + numString + suitString + " ";
        }
        System.out.println(result.trim());
    }
}
