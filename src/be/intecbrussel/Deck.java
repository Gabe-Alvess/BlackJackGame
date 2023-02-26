package be.intecbrussel;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = { "Spades", "Heart", "Diamond", "Club" };

        for (String suit: suits) {
            for (int value = 1; value <= 13; value++) {
                Card card = new Card(value, suit);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card distributeCard() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public int getDeckSize() {
        return cards.size();
    }
}
