package CardDeck.StandardCardDeck;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class StandardCardDeck implements CardDeck {
	
	public static int MAX_CARDS_IN_DECK = 52;

	private Map<Integer, Card> deck = new HashMap<Integer, Card>();
	public Map<Integer, Card> getDeck() { return deck; }


	public StandardCardDeck() {
		initialize();
	}
	
	private void initialize() {
		loadDeck();
		shuffle();
	}


	public void shuffle() {
		LinkedList<Integer> positions = new LinkedList<Integer>();
		for (int i = 0; i < getDeck().size(); i++) positions.add(new Integer(i+1));

		Iterator<Integer> deckItr = getDeck().keySet().iterator();

		int existingPosition = 0;
		int newPositionIndex = 0;

		Random random = new Random();
		Map<Integer, Card> newDeck = new HashMap<Integer, Card>();

		while (deckItr.hasNext()) {
			System.out.println(positions.size()+" positions left");
			existingPosition = deckItr.next();
			newPositionIndex = random.nextInt(positions.size());
			System.out.println("position list size = " + positions.size());
			System.out.println("new position index " + newPositionIndex);
			System.out.println("putting position "+existingPosition+" into position " + positions.get(newPositionIndex));
			newDeck.put( positions.get(newPositionIndex), getDeck().get(existingPosition) );
			deckItr.remove();
			positions.remove(newPositionIndex);
		}
		
		deck = newDeck;
		
		System.out.println(this.getDeck().size()+" cards in shuffled deck");
	}

	public Card deal() throws DeckIsEmptyException {
		Iterator<Card> itr = getDeck().values().iterator();
		Card dealtCard = null;
		
		if ( itr.hasNext() ) {
			dealtCard = (Card) itr.next();
			itr.remove();
			return dealtCard;
		}
		else throw new DeckIsEmptyException();
		
	}

	public int remaining() {
		return getDeck().size();
	}

	public void loadDeck() {

		int cardCount = 0;
		Card newCard = null;
		CardRank newRank = null;
		CardSuit newSuit = null;

		for (CardSuit suit : CardSuit.values()) {
			newSuit = suit;	

			for (CardRank rank : CardRank.values()) {
				newRank = rank;
				newCard = new StandardCard(suit, rank);
				cardCount++;
				getDeck().put(cardCount, newCard);
			}
		}

		System.out.println(this.getDeck().size()+" cards in new deck");
	}
	
	
	public String toString() {
		Iterator<Card> deckItr = getDeck().values().iterator();
		StringBuilder strBuilder = new StringBuilder();
		System.out.println(getDeck().size() + " cards in deck");

		while (deckItr.hasNext()) {
			strBuilder.append( ((Card) deckItr.next()).toString() + "\n");
		}
		
		return strBuilder.toString();
	}

}
