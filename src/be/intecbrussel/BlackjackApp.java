package be.intecbrussel;

import java.util.Scanner;

public class BlackjackApp {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        Scanner scanner = new Scanner(System.in);
        boolean isBusted = false;
        int playerMoney = 100;
        int bet = 0;

        System.out.println("Welcome to my Blackjack game!");
        while (playerMoney > 0) {
            System.out.println("You currently have " + playerMoney + "$");
            System.out.println("How much would you like to bet?");
            bet = scanner.nextInt();

            while (bet > playerMoney || bet <= 0) {
                System.out.println("Invalid bet! Please make a bet between 1 and " + playerMoney);
                bet = scanner.nextInt();
            }
            System.out.println("Bet successfully placed!");
            playerMoney -= bet;

            System.out.println("\nLet's start the game!");
            deck.shuffle();

            // Deel twee kaarten uit aan de speler en een kaart aan de dealer.
            playerHand.addCard(deck.receiveCard());
            playerHand.addCard(deck.receiveCard());
            dealerHand.addCard(deck.receiveCard());

            // Toont de kaarten in de hand van de speler en de eerste kaart in de hand van de dealer.
            System.out.println("Your hand: " + playerHand);
            System.out.println("Your hand score: " + playerHand.getHandValue());

            System.out.println("\nDealer Hand: " + dealerHand);
            System.out.println("Dealer hand score: " + dealerHand.getHandValue());

            if (playerHand.getHandValue() == 21) {
                System.out.println("\nBlackjack! You won the round!");
                System.out.println("You won " + (2 * bet) + "$ :)");
                playerMoney += (2 * bet);
                playerHand.discardHand();
                dealerHand.discardHand();
            } else if (dealerHand.getHandValue() == 21) {
                System.out.println("\nThe dealer has a blackjack! Dealer won!");
                System.out.println("You lost " + bet + "$ :(");
                playerHand.discardHand();
                dealerHand.discardHand();
            }

            while (playerHand.getHandValue() < 21) {
                System.out.print("Do you want to hit or stand? (h/s): ");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("h")) {
                    playerHand.addCard(deck.receiveCard());
                    System.out.println("\nYour hand: " + playerHand);
                    System.out.println("Your hand score: " + playerHand.getHandValue());
                } else if (answer.equalsIgnoreCase("s")) {
                    break;
                } else {
                    System.out.println("Invalid answer! Please enter 'h' to hit or 's' to stand.");
                }
            }

            if (playerHand.getHandValue() > 21) {
                isBusted = true;
            }

            if (!isBusted) {
                while (dealerHand.getHandValue() < 17) {
                    dealerHand.addCard(deck.receiveCard());
                }
                System.out.println("\nDealer hand: " + dealerHand);
                System.out.println("Dealer hand score: " + dealerHand.getHandValue());
            }


            if (dealerHand.getHandValue() > 21) {
                System.out.println("\nDealer is busted! You won the round!");
                System.out.println("You won " + (2 * bet) + "$ :)");
                playerMoney += (2 * bet);
                playerHand.discardHand();
                dealerHand.discardHand();
            } else if (playerHand.getHandValue() > 21) {
                System.out.println("\nPlayer is busted! Dealer won the round!");
                System.out.println("You lost " + bet + "$ :(");
                playerHand.discardHand();
                dealerHand.discardHand();
            } else if (playerHand.getHandValue() > dealerHand.getHandValue()) {
                System.out.println("You won the round!");
                System.out.println("You won " + (2 * bet) + "$ :)");
                playerMoney += (2 * bet);
                playerHand.discardHand();
                dealerHand.discardHand();
            } else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
                System.out.println("\nDealer won the round!");
                System.out.println("You lost " + bet + "$ :(");
                playerHand.discardHand();
                dealerHand.discardHand();
            } else {
                System.out.println("\nIt's a tie!");
                System.out.println("You got your " + bet + "$ bet back!");
                playerMoney += bet;
                playerHand.discardHand();
                dealerHand.discardHand();
            }
        }
        System.out.println("You're out of money! Thanks for playing.");
    }
}
