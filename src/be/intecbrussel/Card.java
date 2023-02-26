package be.intecbrussel;

import java.util.Arrays;
import java.util.Random;

public class Card {
    private int cardValue;
    private String cardSuit;

    public Card(int cardValue, String cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getCardSuit() {
        return cardSuit;
    }

    @Override
    public String toString() {
        String stringValue;
        switch (cardValue) {
            case 1:
                stringValue = "Ace";
                break;
            case 11:
                stringValue = "Jack";
                break;
            case 12:
                stringValue = "Queen";
            case 13:
                stringValue = "King";
                break;
            default: stringValue = Integer.toString(cardValue);
        }
        return stringValue + " of " + cardSuit;
    }
}
