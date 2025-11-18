package cards;

public class Deck {

    public Deck(){
        Card [] cardAry = new Card[52];
        int x = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                cardAry[x] = new Card(i, j);
                //System.out.println(cardAry[x]);
                x++;
            }
        }
    }

}
