package CardDeck.StandardCardDeck;

import java.util.Comparator;

public enum CardRank {
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NINE (9),
	TEN (10),
	JACK (11),
	QUEEN (12),
	KING (13),
	ACE (14);

	
	int order = 0;
	
	private CardRank (int order) {
		this.order = order;
	}
	
	public boolean isRankedHigher (CardRank rank) {
		if (this.order  < rank.order) return true;
		return false;
	}
	
	public static Comparator<Card> byCardRank = (card1, card2) -> 
		CardRank.compare ( card1.getCardRank(), card2.getCardRank() );
	
	public static int compare (CardRank rank1, CardRank rank2) {
		if (rank1.order < rank2.order) return 1;
		return -1;
	}

}
