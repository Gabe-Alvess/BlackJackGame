package be.intecbrussel;

public class BlackJackApp {
    public static void main(String[] args) {
        // welcome message
        System.out.println("Welcome to our Blackjack Game!");

        // create playing deck
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        System.out.println(playingDeck);
    }
}
