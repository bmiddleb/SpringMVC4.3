package CardDeck.StandardCardDeck;

public enum CardSuit {
	CLUB (4, "Clubs"),
	DIAMOND (3, "Diamonds"),
	HEART (2, "Hearts"),
	SPADE (1, "Spades");
	
	int order = 0;
	String name = null;
	
	private CardSuit (int order, String name) {
		this.order = order;
	}
	
	public boolean isRankedHigher (CardSuit suit) {
		if (this.order  > suit.order) return true;
		return false;
	}
	
	public String toString() { return this.name(); }

}
