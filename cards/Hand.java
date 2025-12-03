package cards;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;
    private int size;

    public Hand(int max){
        ArrayList<Card> this.hand = new ArrayList<>(max);
        size = 0;
    }

    public void add(Card c){
        if(size < hand.size()){
            hand.add(c);
            size++;
        }
    }

    public int length() {
        return size;
    }

    public Card get(int index){
        if(index < 0 || index >= size){
            return null;
        }
        return hand.get(index));
    }

    public Card remove(int index){
        if(index < 0 || index >= size){
            return null;
        }

        Card removed = hand.get(index);

        for(int i = index; i < size; i++){
            hand.set(i, hand.get(i + 1);
        }

        hand.set(size - 1, null);
        size--;

        return removed;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < hand.size(); i++){
            result = hand.get(i) + " " + result;
        }
        return result;
    }
}