package be.intecbrussel;

import java.util.ArrayList;

public class Deck {
//  propertys
    private final ArrayList<Card> cards;
//  constructors
    public Deck() {
        cards = new ArrayList<>();
    }
//  methods
    public void createFullDeck() {
        // Generate Cards
        for (Stack cardStack: Stack.values()) {
            for (Value cardValue : Value.values()) {
            // Add new card to the deck
               cards.add(new Card(cardStack, cardValue));
            }
        }
    }

    public String toString() {
        StringBuilder cardListOutput = new StringBuilder();
        int i = 0;
        for (Card oneCard : cards) {
            cardListOutput.append("\n").append(i).append(" -> ").append(oneCard.generatedCard());
            i++;
        }
        return cardListOutput.toString();
    }
}
