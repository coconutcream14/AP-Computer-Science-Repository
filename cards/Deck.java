package cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cardAry = new ArrayList<>();

    public Deck(){
        
        int x = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                cardAry[x] = new Card(i, j);
                //System.out.println(cardAry[x]);
                x++;
            }
        }
    }

    public void shuffle(){
        ArrayList<Integer> indexAry = new ArrayList<>(); 
        for(int i = 0; i < 52; i++){
            indexAry.add(i);
            //System.out.println(indexAry.get(i));
        }
        Collections.shuffle(indexAry);
        for(int i = 0; i < 52; i++){
            //System.out.println(indexAry.get(i));
            cardAry[i] = cardAry[indexAry.get(i)];
            //System.out.println(cardAry[i]);
        }
    }

    public void cut(int value){
        Arraylist<Card> 
        Card [] movedCards = new Card[value];
        int x = value;
        Card y;
        for(int i = 0; i < value; i++){
            movedCards[i] = cardAry[i]; //0th index of cardAry: ♦A
            y = cardAry[i] // y = ♦A
            cardAry[i] = cardAry[x]; //cardAry[0] = 
            x--;
        }
    }

}
