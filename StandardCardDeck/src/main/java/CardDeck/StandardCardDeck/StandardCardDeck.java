package CardDeck.StandardCardDeck;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class StandardCardDeck implements CardDeck {
	
	private static final int TOP_CARD = 0;

	public static int MAX_CARDS_IN_DECK = 52;

	//private Map<Integer, Card> deck = new HashMap<Integer, Card>();
	private List<Card> deck = new LinkedList<Card>();
	
	
	public List<Card> getDeck() { return deck; }
	public void setDeck(List<Card> newDeck) { this.deck = newDeck; }

	public Collection<Card> getCards() { return (Collection<Card>) deck; }


	public StandardCardDeck() {
		initialize();
	}
	

	private void initialize() {
		loadDeck();
		shuffle();
	}


	public void shuffle() {
		Collections.shuffle(this.deck);
		
		System.out.println(this.getDeck().size()+" cards in shuffled deck");
	}


	public Card deal() throws DeckIsEmptyException {
		
		if ( this.deck.isEmpty() ) throw new DeckIsEmptyException();
		
		Card dealtCard = deck.get(TOP_CARD);
		deck.remove(TOP_CARD);
		
		return dealtCard;
	}


	public int remaining() {
		return getDeck().size();
	}

	
	public void loadDeck() {

		int cardCount = 0;
		Card newCard = null;
		this.setDeck( new LinkedList<Card>() ); // discard old deck, create new

		for (CardSuit suit : CardSuit.values()) {
			for (CardRank rank : CardRank.values()) {
				newCard = new StandardCard(suit, rank);
				getDeck().add(newCard);
				cardCount++;
			}
		}

		System.out.println(this.getDeck().size()+" cards in new deck");
	}
	
	
	public String toString() {
		Iterator<Card> deckItr = getDeck().iterator();
		StringBuilder strBuilder = new StringBuilder();
		System.out.println(getDeck().size() + " cards in deck");

		while (deckItr.hasNext()) {
			strBuilder.append( ((Card) deckItr.next()).toString() + "\n");
		}
		
		return strBuilder.toString();
	}

}
