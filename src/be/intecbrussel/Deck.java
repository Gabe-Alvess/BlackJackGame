package be.intecbrussel;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
//  propertys
    private ArrayList<Card> cards;
//  constructors
    public Deck() {
        cards = new ArrayList<>();
    }

//  getters en setters
    public Card getCard(int i) {
        return this.cards.get(i);
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

    public void shuffle() {
        ArrayList<Card> tempDeck = new ArrayList<>();
        //Use Random
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
           // Generate Random Index
           randomCardIndex = random.nextInt((this.cards.size() - 1) + 1);
           tempDeck.add(this.cards.get(randomCardIndex));
           // Remove from original deck
            this.cards.remove(randomCardIndex);
        }
        this.cards = tempDeck;
    }

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }
    // Draws from the deck
    public void draw(Deck comingFrom) {
        this.cards.add(comingFrom.getCard(0));
    }

//  Override method
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
