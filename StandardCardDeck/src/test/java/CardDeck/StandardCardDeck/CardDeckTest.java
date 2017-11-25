package CardDeck.StandardCardDeck;

import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * CardDeck tester
 */

public class CardDeckTest extends TestCase
{
	public static String KING_OF_SPADES = "KING of SPADE";
	
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CardDeckTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CardDeckTest.class );
    }


    /**
     * Card Tests
     */

    public void testRankEnumHierarchy()
    {
    		CardRank rank3 = CardRank.THREE;
    		CardRank rank4 = CardRank.FOUR;
        assertTrue( rank4.isRankedHigher(rank3) );
    }

    public void testCardSuitEnumHierarchy()
    {
    		CardSuit club = CardSuit.CLUB;
    		CardSuit spade = CardSuit.SPADE;
        assertTrue( club.isRankedHigher(spade) );
    }

    public void testCardCreate()
    {
    		Card card = new StandardCard (CardSuit.DIAMOND, CardRank.ACE);
        assertTrue( card != null );
    }

    public void testCardToString()
    {
    		Card card = new StandardCard (CardSuit.SPADE, CardRank.KING);
        System.out.println(card.getCardRank().toString() +" of " +card.getCardSuit().toString());
        assertTrue( card.toString().equals(CardDeckTest.KING_OF_SPADES) );
    }

    public void testCardDeckInit()
    {
    		CardDeck deck = new StandardCardDeck();
        System.out.println(deck.remaining()+" cards in deck");
        assertTrue( deck.remaining() == StandardCardDeck.MAX_CARDS_IN_DECK);
    }

    public void testCardDeckShuffle() throws DeckIsEmptyException
    {
    		CardDeck deck1 = new StandardCardDeck();
    		CardDeck deck2 = new StandardCardDeck();
    		Card card1 = deck2.deal();
    		deck1.shuffle();
        System.out.println(deck1);
    		Card card2 = deck1.deal();
        assertTrue( ! card1.equals(card2) );
    }
    
    public void testCardHandDealt() throws DeckIsEmptyException
    {
    		CardDeck deck = new StandardCardDeck();
    		CardHand hand = new StandardCardHand();
    		Card newCard = null;

    		for (int i = 0; i < 5; i++) {
    			newCard = deck.deal();
    			System.out.println("new card is "+newCard.toString());
    			hand.addCard(newCard);
    		}
        System.out.println(deck.remaining()+" cards in deck");
        System.out.println("Hand: \n"+hand.toString());
        assertTrue( 5 == (StandardCardDeck.MAX_CARDS_IN_DECK - deck.remaining()) );
    } 
    
    public void testCardHandSort() throws DeckIsEmptyException
    {
    		CardDeck deck = new StandardCardDeck();
    		CardHand hand = new StandardCardHand();
    		Card newCard = null;

    		for (int i = 0; i < 7; i++) {
    			newCard = deck.deal();
    			System.out.println("new card is "+newCard.toString());
    			hand.addCard(newCard);
    		}
    		hand.sortHandByValue();
    		System.out.println(hand.toString());
    		
    		Iterator<Card> handIter = ((StandardCardHand) hand).getCardHand().iterator();
    		Card previousCard = handIter.next();
   		System.out.println("prev card is "+previousCard.toString());
    		Card card = null;
    		boolean rankedCorrectly = false;
    		boolean rankedEqual = false;
    		
    		while (handIter.hasNext()) {
    			card = handIter.next();
    			System.out.println("next card is "+card.toString());
    			rankedCorrectly = previousCard.getCardRank().isRankedHigher(card.getCardRank());
    			rankedEqual = previousCard.getCardRank() == card.getCardRank();
    			assertTrue(rankedCorrectly || rankedEqual);
    			previousCard = card;
    		}
    }  
    
    public void testCardHandSuitSort() throws DeckIsEmptyException
    {
    		CardDeck deck = new StandardCardDeck();
    		CardHand hand = new StandardCardHand();
    		Card newCard = null;

    		for (int i = 0; i < 7; i++) {
    			newCard = deck.deal();
    			System.out.println("new card is "+newCard.toString());
    			hand.addCard(newCard);
    		}
    		hand.sortHandBySuit();

    		System.out.println(hand.toString());
    		
    		Iterator<Card> handIter = ((StandardCardHand) hand).getCardHand().iterator();
    		Card card = null;
    		boolean rankedCorrectly = false;
    		boolean rankedEqual = false;

    		// Init first card
    		Card previousCard = handIter.next();
   		System.out.println("prev card is "+previousCard.toString());
    		
    		while (handIter.hasNext()) {
    			card = handIter.next();
    			System.out.println("next card is "+card.toString());
    			rankedCorrectly = previousCard.getCardSuit().isRankedHigher(card.getCardSuit());
    			rankedEqual = previousCard.getCardSuit() == card.getCardSuit();
    			assertTrue(rankedCorrectly || rankedEqual);
    			previousCard = card;
    		}
    }  

}
