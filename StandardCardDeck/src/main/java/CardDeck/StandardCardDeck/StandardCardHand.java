package CardDeck.StandardCardDeck;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class StandardCardHand implements CardHand {

	int maxCardsInHand = 0;
	private LinkedList<Card> cardHand = new LinkedList<Card>();

	public LinkedList<Card> getCardHand() { return cardHand; }
	public void setCardHand(LinkedList<Card> cardHand) {
		this.cardHand = cardHand;
	}

	public int getMaxCardsInHand() { return maxCardsInHand; }
	public void setMaxCardsInHand(int maxCardsInHand) {
		this.maxCardsInHand = maxCardsInHand;
	}

	public void addCard(Card card) { cardHand.add(card); }

	public void removeCard(Card card) {
		cardHand.remove(card);
	}

	public void sortHandBySuit() {
		System.out.println("\nSorting by suit... ");
		Card[] cards = cardHand.toArray(new Card[cardHand.size()]);
		Card tempCard = null;
		boolean notDoneSorting = true;
		int whereToEnd = -1;
		int first = cardHand.size() - 1;
		int iterNum = 1;

		while (notDoneSorting) {
			notDoneSorting = false;
			System.out.println("\nIteration "+ iterNum);
			iterNum++;
			whereToEnd++;

			for (int i=first; i > whereToEnd; i--) {
				if (cards[i].getCardSuit().isRankedHigher(cards[i-1].getCardSuit())) {
					System.out.println("\n"+cards[i] +" is ranked higher than "+cards[i-1]);
					tempCard = cards[i-1];
					cards[i-1] = cards[i];
					cards[i] = tempCard;
					notDoneSorting = true;
				} else {
					System.out.println("\n"+cards[i] +" is NOT ranked higher than "+cards[i-1]);
				}
			}
			if (notDoneSorting) for (int j=0; j< cards.length; j++) System.out.println(cards[j]); 
		}
		
		cardHand = new LinkedList<Card>(Arrays.asList(cards));
	}

	public void sortHandByValue() { // Descending order
		System.out.println("\nSorting by rank... ");
		Card[] cards = cardHand.toArray(new Card[cardHand.size()]);
		Card tempCard = null;
		boolean notDoneSorting = true;
		int whereToEnd = -1;
		int first = cards.length - 1;
		int iterNum = 1;

		while (notDoneSorting) {
			notDoneSorting = false;
			System.out.println("\nIteration "+ iterNum);
			iterNum++;
			whereToEnd++;

			for (int i=first; i>whereToEnd; i--) {
				if (cards[i].getCardRank().isRankedHigher(cards[i-1].getCardRank())) {
					System.out.println("\n"+cards[i] +" is ranked higher than "+cards[i-1]);
					tempCard = cards[i-1];
					cards[i-1] = cards[i];
					cards[i] = tempCard;
					notDoneSorting = true;
				} else {
					System.out.println("\n"+cards[i] +" is NOT ranked higher than "+cards[i-1]);
				}
			}
			if (notDoneSorting) for (int j=0; j< cards.length; j++) System.out.println(cards[j]); 
		}
		
		cardHand = new LinkedList<Card>(Arrays.asList(cards));
	}
	
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		
		for (Card card : this.cardHand) {
			strBuilder.append(card.toString() + "\n");
		}
		
		return strBuilder.toString();
	}
	
}
