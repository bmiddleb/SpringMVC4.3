package CardDeck.StandardCardDeck;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class StandardCardHand implements CardHand {

	int maxCardsInHand = 0;
	private Collection<Card> cardHand = new LinkedList<Card>();


	public Collection<Card> getCardHand() { return cardHand; }
	public void setCardHand(List<Card> newCardHand) {
		this.cardHand = newCardHand;
	}
	

	public int getMaxCardsInHand() { return maxCardsInHand; }
	public void setMaxCardsInHand(int maxCardsInHand) {
		this.maxCardsInHand = maxCardsInHand;
	}
	

	public void addCard(Card card) { cardHand.add(card); }
	

	public void removeCard(Card card) { cardHand.remove(card); }
	

	public void sortHandBySuit() { // Ascending order
		System.out.println("\nSorting by suit... ");

		List<Card> cardHand = 
    			this.getCardHand()
    			.stream()
    			.sorted(CardSuit.byCardSuit)
			.collect(Collectors.toList());

		this.setCardHand(cardHand);
	}

	public void sortHandByValue() { // Ascending order
		System.out.println("\nSorting by rank... ");

		List<Card> cardHand = 
    			this.getCardHand()
    			.stream()
    			.sorted(CardRank.byCardRank)
			.collect(Collectors.toList());

		this.setCardHand(cardHand);
	}
	
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		
		for (Card card : this.cardHand) {
			strBuilder.append(card.toString() + "\n");
		}
		
		return strBuilder.toString();
	}
	
}
