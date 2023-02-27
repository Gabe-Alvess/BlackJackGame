package be.intecbrussel;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getHandValue() {
        int handValue = 0;
        boolean haveAce = false;

        for (Card card : cards) {
            int cardValue = card.getCardValue();
            if (cardValue == 1) {
                haveAce = true;
            }
            handValue += cardValue;
        }
        if (haveAce && handValue <= 11) {
            handValue += 10;
        }
        return handValue;
    }

    public void discardHand() {
        cards.clear();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Card card : cards) {
            str.append(card.toString()).append(" - ");
        }
        return str.toString();
    }
}
