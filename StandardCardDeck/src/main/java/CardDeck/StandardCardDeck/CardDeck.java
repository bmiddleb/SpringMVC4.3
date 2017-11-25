package CardDeck.StandardCardDeck;

public interface CardDeck {
	public void shuffle();
	public Card deal() throws DeckIsEmptyException;
	public int remaining();
}
