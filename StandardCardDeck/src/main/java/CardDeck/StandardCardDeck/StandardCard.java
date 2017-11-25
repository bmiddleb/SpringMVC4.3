package CardDeck.StandardCardDeck;

import java.text.MessageFormat;

public class StandardCard implements Card {
	
	private CardSuit suit = null;
	private CardRank rank = null;
	public static String CARD_STRING_MSG_FORMAT = "{0} of {1}";

	public StandardCard (CardSuit suit, CardRank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public CardRank getCardRank() { return this.rank; }
	public void setCardRank(CardRank rank) { this.rank = rank; }

	public CardSuit getCardSuit() { return this.suit; }
	public void setCardSuit(CardSuit suit) { this.suit = suit; }
	
	public String toString() {
		return MessageFormat.format(CARD_STRING_MSG_FORMAT, this.rank.toString(), this.suit.toString());
	}


}
