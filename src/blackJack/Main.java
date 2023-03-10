package blackJack;

import java.util.HashMap; 
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static String answer;
	static int valueOfUserHand = 0; 
									
	static int valueOfDealerHand = 0; 
	//in blackjack, dealers usually follow a standard of not "hitting" unless the value of their hand is under 17
	static final int DEALER_HIT_LIMIT = 17;
	static final int MAXIMUM_DECK_VALUE = 21;

	public static Map<String, Integer> playingCards = new HashMap<String, Integer>();

	//A method that selects a random key from the HashMap and prints it, representing the drawing of a playing card from a deck.
	//this method stores also the value of the card into the valueOfUserHand variable.
	//test commit
	public static void drawUserCard() {

		Object[] cardKeys = playingCards.keySet().toArray(); 
		
		Object key = cardKeys[new Random().nextInt(cardKeys.length)]; 
		
		valueOfUserHand = valueOfUserHand + playingCards.get(key); 
		
		System.out.println(key); 
		playingCards.remove(key); 

	}

	public static void drawDealerCard() {
		
		while (valueOfDealerHand < DEALER_HIT_LIMIT) {
			Object[] cardKeys = playingCards.keySet().toArray();
			Object key = cardKeys[new Random().nextInt(cardKeys.length)];
			valueOfDealerHand = valueOfDealerHand + playingCards.get(key);
			playingCards.remove(key);
		}

	}

//Method that welcomes the user to the blackjack table  
	public static void welcomeUser() {
		System.out.println("Hello! Welcome to the black jack table.");
		System.out.println("Please enter 1 to play blackjack or 2 to exit the table:");

		Scanner scan = new Scanner(System.in); // We are using the Scanner class to read the user's input
		answer = scan.next();

		String one = Integer.toString(1); 
		String two = Integer.toString(2); 
		
		if (answer.equals(one)) { 
			System.out.println("Dealer: Let's play!");
			Main.playBlackJack();
		} else if (answer.equals(two)) {
			System.out.println("Exiting table.");
		} else {
			Main.welcomeUser();
		}

	}

//Method to calculate winner

	public static void calculateWinner() {

		if (valueOfUserHand > valueOfDealerHand && valueOfUserHand < MAXIMUM_DECK_VALUE) {
			System.out.println("You won!" + " My hand only had a value of " + valueOfDealerHand + " and yours had "
					+ valueOfUserHand + ".");
		} else if (valueOfUserHand > valueOfDealerHand && valueOfUserHand <= MAXIMUM_DECK_VALUE) {
			System.out.println("You won! I only had " + valueOfDealerHand);
		} else if (valueOfUserHand > MAXIMUM_DECK_VALUE && valueOfDealerHand < MAXIMUM_DECK_VALUE) {
			System.out.println("It looks like you busted since your hand is over 21, so I won that round.");
		} else if (valueOfUserHand > MAXIMUM_DECK_VALUE && valueOfDealerHand > MAXIMUM_DECK_VALUE) {
			System.out.println("It looks like we both busted, since both our hands are over 21. Nobody wins!");
		} else if (valueOfUserHand < valueOfDealerHand && valueOfDealerHand <= MAXIMUM_DECK_VALUE) {
			System.out.println("My hand had a better value of " + valueOfDealerHand + ", so I won this one.");
		} else if (valueOfUserHand == valueOfDealerHand) {
			System.out.println("Looks like we tied that one. My hand had a value of " + valueOfDealerHand
					+ " and you also had " + valueOfUserHand + ".");
		} else if (valueOfUserHand < valueOfDealerHand && valueOfDealerHand > MAXIMUM_DECK_VALUE) {
			System.out.println("Ugh, I busted. Looks like you win.");
		} else if (valueOfUserHand == MAXIMUM_DECK_VALUE && valueOfUserHand != valueOfDealerHand) {
			System.out.println("BlackJack--nice! You win!");
		} else if (valueOfUserHand == MAXIMUM_DECK_VALUE && valueOfDealerHand == MAXIMUM_DECK_VALUE) {
			System.out.println("Whoa--we both got BlackJack. It's a  tie!");
		} else {
			System.out.println("Hmm not sure what happened here. You have to excuse us we just opened recently.");
		}
	}

	// Method that sets the HashMap to a fresh deck of 52 cards

	public static void setDeck() {

		playingCards.put("Ace of Diamonds", 11);
		playingCards.put("Ace of Hearts", 11);
		playingCards.put("Ace of Clubs", 11);
		playingCards.put("Ace of Spades", 11);
		playingCards.put("Two of Diamonds", 2);
		playingCards.put("Two of Hearts", 2);
		playingCards.put("Two of Clubs", 2);
		playingCards.put("Two of Spades", 2);
		playingCards.put("Three of Diamonds", 3);
		playingCards.put("Three of Hearts", 3);
		playingCards.put("Three of Clubs", 3);
		playingCards.put("Three of Spades", 3);
		playingCards.put("Four of Diamonds", 4);
		playingCards.put("Four of Hearts", 4);
		playingCards.put("Four of Clubs", 4);
		playingCards.put("Four of Spades", 4);
		playingCards.put("Five of Diamonds", 5);
		playingCards.put("Five of Hearts", 5);
		playingCards.put("Five of Clubs", 5);
		playingCards.put("Five of Spades", 5);
		playingCards.put("Six of Diamonds", 6);
		playingCards.put("Six of Hearts", 6);
		playingCards.put("Six of Clubs", 6);
		playingCards.put("Six of Spades", 6);
		playingCards.put("Seven of Diamonds", 7);
		playingCards.put("Seven of Hearts", 7);
		playingCards.put("Seven of Clubs", 7);
		playingCards.put("Seven of Spades", 7);
		playingCards.put("Eight of Diamonds", 8);
		playingCards.put("Eight of Hearts", 8);
		playingCards.put("Eight of Clubs", 8);
		playingCards.put("Eight of Spades", 8);
		playingCards.put("Nine of Diamonds", 9);
		playingCards.put("Nine of Hearts", 9);
		playingCards.put("Nine of Clubs", 9);
		playingCards.put("Nine of Spades", 9);
		playingCards.put("Ten of Diamonds", 10);
		playingCards.put("Ten of Hearts", 10);
		playingCards.put("Ten of Clubs", 10);
		playingCards.put("Ten of Spades", 10);
		playingCards.put("Jack of Diamonds", 10);
		playingCards.put("Jack of Hearts", 10);
		playingCards.put("Jack of Clubs", 10);
		playingCards.put("Jack of Spades", 10);
		playingCards.put("Queen of Diamonds", 10);
		playingCards.put("Queen of Hearts", 10);
		playingCards.put("Queen of Clubs", 10);
		playingCards.put("Queen of Spades", 10);
		playingCards.put("King of Diamonds", 10);
		playingCards.put("King of Hearts", 10);
		playingCards.put("King of Clubs", 10);
		playingCards.put("King of Spades", 10);

	}

	// Method that prints the Black Jack game menu
	public static void playBlackJack() {

		// To start the game, the user is dealt two cards at random
		// The dealer also draws his own cards. See the drawDealerCard method to
		// understand the logic there
		System.out.println("You have been dealt a hand of two cards: ");
		Main.drawUserCard();
		Main.drawUserCard();
		Main.drawDealerCard();

		// Once the game has been started by drawing the first cards, we want to give
		// the user the option to add to his hand,
		// Or if he feels confident with the hand he has at any moment, he can choose to
		// finish the round.
		System.out.println("Enter any key to add a card to your hand, or press 2 to finish the round.");
		Scanner scan = new Scanner(System.in);
		answer = scan.next();
		String two = Integer.toString(2);

		// Logic to determine whether or not the user wants to add to his hand
		while (!answer.equals(two)) {// As long as the player decides to add to his hand, we let him.
			Main.drawUserCard();
			System.out.println("Enter any key to add another card, or press 2 to finish the round.");
			scan = new Scanner(System.in);
			answer = scan.next();
			two = Integer.toString(2);

		}
		if (answer.equals(two)) { // Once the player decides he is done adding to his hand, we call the
									// Main.calculateWinner method and print the winner
			Main.calculateWinner();
			System.out.println("Thanks for playing!");
			System.out.println("Press any key to play again, or press 2 to exit."); 
																					
			answer = scan.next();
			String dos = Integer.toString(2);
			if (!answer.equals(dos)) { // Here, if the player does want to play again, we need to make sure the global
										// variables valueOfDealerHand and valueOfUserHand are both reset to zero.
				valueOfDealerHand = 0;
				valueOfUserHand = 0;
				Main.setDeck();
				Main.playBlackJack();
			} else {
				System.out.println("Exiting.");
				scan.close();

			}

		}

	}

	public static void main(String[] args) {
		// Our main method we will use to call our separate methods.
		// Load Hashmap with deck of Cards
		// Welcome the user (starting the program)
		Main.setDeck();
		Main.welcomeUser();

	}
}
