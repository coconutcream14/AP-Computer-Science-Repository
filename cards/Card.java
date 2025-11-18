package cards;

public class Card {

    private int suit;
    private int value;

    public Card(int suit, int value) {
        if(suit < 0){
            suit = 0;
        } else if(suit > 3){
            suit = 3;
        }
        if(value < 0){
            value = 0;
        } else if(value > 12){
            value = 12;
        }
        this.suit = suit;
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public String toString(){
        String [] suits = {"♦", "♣", "♥", "♠"};
        String [] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String result = suits[suit] + values[value];
        return result;
    }

}
