package CardDeck.StandardCardDeck;

import java.util.Comparator;

public enum CardSuit {
	CLUB (4, "Clubs"),
	DIAMOND (3, "Diamonds"),
	HEART (2, "Hearts"),
	SPADE (1, "Spades");

	private int order = 0;
	private String name = null;
	
	public int getOrder() { return order; }
	public void setOrder(int order) { this.order = order; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	private CardSuit (int order, String name) { this.order = order; }
	
	public boolean isRankedHigher (CardSuit suit) {
		if (this.order  > suit.order) return true;
		return false;
	}
	
	public String toString() { return this.name(); }
	
	public static Comparator<Card> byCardSuit = (card1, card2) -> 
			CardSuit.compare ( card1.getCardSuit(), card2.getCardSuit() );

	public static int compare (CardSuit cardSuit, CardSuit cardSuit2) {
		if (cardSuit.order < cardSuit2.order) return 1;
		return -1;
	}
}
