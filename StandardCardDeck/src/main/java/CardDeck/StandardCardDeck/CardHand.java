package CardDeck.StandardCardDeck;

public interface CardHand {
	public void addCard (Card card);
	public void removeCard (Card card);
	public void sortHandBySuit();
	public void sortHandByValue();
}
