package cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cardAry = new ArrayList<>();
    private int index = -1;

    public Deck(){
        
        int x = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                cardAry.add(x, new Card(i, j));
                //System.out.println(cardAry[x]);
                x++;
            }
        }
    }

    public void shuffle(){
/*      ArrayList<Integer> indexAry = new ArrayList<>(); 
        for(int i = 0; i < 52; i++){
            indexAry.add(i);
            //System.out.println(indexAry.get(i));
        }*/
        Collections.shuffle(cardAry);
/*      for(int i = 0; i < 52; i++){
            //System.out.println(indexAry.get(i));
            cardAry[i] = cardAry[indexAry.get(i)];
            //System.out.println(cardAry[i]);
        }*/
    }

    public void cut(int value){
        Card movedCard;
        for(int i = 0; i < value; i++){
            movedCard = cardAry.getFirst(); //♦A, ♦2
            cardAry.remove(0); //♦3, ♦4, ...
            cardAry.add(movedCard); //♦3, ♦4, ... ♦A, ♦2
        }
        for(int i = 0; i < 52; i++){
            System.out.println(cardAry.get(i));
        }
    }

    public Card draw(){
        if(cardAry.isEmpty()){
            return null;
        }
        index++;
        System.out.println(index);
        System.out.println(cardAry.get(index));
        return cardAry.get(index);
    }

    public void print(int times){
        String result = "";
        for(int i = 0; i < times; i++){
            result = result + String.valueOf(cardAry.get(i))  + " "; // ♦A ♦2 
        }
        System.out.println(result);
    }
}
