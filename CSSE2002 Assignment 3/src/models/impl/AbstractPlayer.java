package models.impl;

import java.util.ArrayList;
import java.util.Iterator;

import models.Card;
import models.Deck;
import models.Player;
import models.SubjectCard;
import models.UserException;

/** An abstract implementation of the Player interface. The
 *  play method is not implemented.
 *  @author Graeme Smith
 */
public abstract class AbstractPlayer implements Player {

	/** The cards in the player's hand. */
	protected ArrayList<Card> hand; 
	
	/** The player's cards in play. */
	protected ArrayList<SubjectCard> inPlay;
	
	/** The player's opponents. */
	protected ArrayList<Player> opponents; 
	
	/** The deck of cards. */
	protected Deck deck; 
	
	public void addOpponent(Player p) {
		opponents.add(p);
	}
	
	public void receiveCard(Card card) {
		if (card != null) 
			hand.add(card);
	}
	
	public abstract void play() throws UserException;
	
	public int unfrozenSubjectCardsInPlay() {
		int result = 0; // the number of unfrozen cards in play
		for  (SubjectCard s : inPlay) 
			if (! s.isFrozen()) 
				result++;	
		return result;
	}
	
	public void pickUp() {
		Card c = deck.pickUp();  // the next card from the deck
		receiveCard(c);
	}
	
	public Iterator<Card> getCardsInHandIterator() {
		return hand.iterator();
	}
	
	public Iterator<SubjectCard> getCardsInPlayIterator() {
		return inPlay.iterator();
	}
}
