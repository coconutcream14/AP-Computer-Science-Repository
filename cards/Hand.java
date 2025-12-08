package cards;

// This class represents a hand of cards in a card game
public class Hand {

    // array to store the cards in the hand
    private Card[] cards;
    // current number of cards in the hand
    private int size;

    // constructor to initialize the hand with a max number of cards
    public Hand(int maxCards) {
        cards = new Card[maxCards];
        size = 0;
    }

    // adds a card to the hand if there's space
    public void add(Card c) {
        if (size < cards.length) {
            cards[size] = c;
            size++;
        }
    }

    // returns the number of cards in the hand
    public int length() {
        return size;
    }

    // returns the card at the specified index without removing it
    public Card get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return cards[index];
    }

    // removes and returns the card at the specified index
    public Card remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Card removed = cards[index];
        for (int i = index; i < size - 1; i++) {
            cards[i] = cards[i + 1];
        }
        cards[size - 1] = null;
        size--;
        return removed;
    }

    // returns a string representation of the hand
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(cards[i]);
            if (i < size - 1)
                sb.append(", ");
        }
        return sb.toString();
    }
}