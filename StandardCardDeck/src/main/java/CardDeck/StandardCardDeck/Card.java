package CardDeck.StandardCardDeck;

public interface Card {
	public CardRank getCardRank();
	public void setCardRank(CardRank rank);
	public CardSuit getCardSuit();
	public void setCardSuit(CardSuit suit);
}
