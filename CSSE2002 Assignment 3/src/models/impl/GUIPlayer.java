package models.impl;

//~--- non-JDK imports --------------------------------------------------------

import models.BonusCard;
import models.Card;
import models.Deck;
import models.FreezeSubjectCard;
import models.Player;
import models.SubjectCard;
import models.UserException;

import view.MainWindow;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;

/**
 * A player controlled via the GUI by a human user.
 * @author Graeme Smith
 */
public class GUIPlayer extends AbstractPlayer {

    /** The player's card in play to unfreeze or grade. */
    private SubjectCard cardInPlay;

    /** The opponent card to freeze. */
    private SubjectCard cardToFreeze;

    /** The next card to play. */
    private Card cardToPlay;

    /**
     * Create a new GUI player to play with a given deck
     *  of cards.
     *  @param deck - the deck
     */
    public GUIPlayer(Deck deck) {

        hand = new ArrayList<Card>();
        inPlay = new ArrayList<SubjectCard>();
        opponents = new ArrayList<Player>();
        this.deck = deck;

    }

    /**
     * Set the card from the player's hand to play in the next turn.
     * @param c - the next card to play
     */
    public void setCardToPlay(Card c) {

        cardToPlay = c;

    }

    /**
     * Set the opponent's card to freeze in the next turn.
     *  @param s - the opponent's card
     *  @throws UserException if the card to play from the player's
     *  hand has not been set, or the card to play is not a freeze
     *  subject card, or if s is already frozen or graded
     */
    public void setCardToFreeze(SubjectCard s) throws UserException {

        if (cardToPlay == null) {

            throw new UserException("Choose card from hand first.");

        }

        if ((cardToPlay instanceof FreezeSubjectCard)
                && ((FreezeSubjectCard) cardToPlay).getType().equals(
                    FreezeSubjectCard.FreezeSubjectCardType.NORMAL)) {

            if (s.isFrozen() || s.isGraded()) {

                throw new UserException("Selected card cannot be frozen.");

            } else {

                cardToFreeze = s;

            }

        } else {

            throw new UserException(
                "Card selected from hand cannot be applied "
                + "to opponent cards.");

        }

    }

    /**
     * Set the player's card to unfreeze or grade in the next turn.
     *  @param s - the palyer's card
     *  @throws UserException if the card to play from the player's
     *  hand has not been set, or the card to play is not a grade
     *  card or bonus card, or the card to play is a grade card but
     *  s is frozen or already graded, or the card to play is a bonus
     *  card but s is not frozen
     */
    public void setCardInPlay(SubjectCard s) throws UserException {

        if (cardToPlay == null) {

            throw new UserException("Choose card from hand first.");

        }

        if ((cardToPlay instanceof FreezeSubjectCard)
                && ((FreezeSubjectCard) cardToPlay).getType().equals(
                    FreezeSubjectCard.FreezeSubjectCardType.GRADE)) {

            if (s.isFrozen() || s.isGraded()) {

                throw new UserException("Selected card cannot be graded.");

            }

            cardInPlay = s;

        } else if (cardToPlay instanceof BonusCard) {

            if (!s.isFrozen() || s.isGraded()) {

                throw new UserException("Selected card is not frozen.");

            }

            cardInPlay = s;

        } else {

            throw new UserException("Selected card cannot be applied "
                                    + "to a card in play.");

        }

    }

    /**
     * The player takes their turn based on the previous user input.
     *  @throws UserException when the card to play from the hand is
     *  a freeze subject card but no opponent's card has been chosen to
     *  freeze, or the card to play from the hand is a bonus card but
     *  no card in play has been selected to unfreeze, or the card to
     *  play from the hand is a grade card but no card in play has been
     *  selected to grade
     */
    public void play() throws UserException {

        if ((cardToPlay instanceof FreezeSubjectCard)
                && ((FreezeSubjectCard) cardToPlay).getType().equals(
                    FreezeSubjectCard.FreezeSubjectCardType.NORMAL)) {

            if (cardToFreeze == null) {

                // reset card to play to allow a new selection
                cardToPlay = null;

                throw new UserException("Need to choose card to freeze.");
            }

            cardToFreeze.freezeWith((FreezeSubjectCard) cardToPlay);
            cardToFreeze.getGUICard().update();

        }

        if (cardToPlay instanceof BonusCard) {

            if (cardInPlay == null) {

                // reset card to play to allow a new selection
                cardToPlay = null;

                throw new UserException("Need to choose card to unfreeze.");
            }

            cardInPlay.unfreeze();
            cardInPlay.getGUICard().update();

        }

        if ((cardToPlay instanceof FreezeSubjectCard)
                && ((FreezeSubjectCard) cardToPlay).getType()
                   == FreezeSubjectCard.FreezeSubjectCardType.GRADE) {

            if (cardInPlay == null) {

                // reset card to play to allow a new selection
                cardToPlay = null;

                throw new UserException("Need to choose card to grade.");
            }

            cardInPlay.gradeWith((FreezeSubjectCard) cardToPlay);
            cardInPlay.getGUICard().update();

        }

        if (cardToPlay instanceof SubjectCard) {

            inPlay.add((SubjectCard) cardToPlay);
            getPlayerTable().putCardOnTable((SubjectCard) cardToPlay);

        }

        if (cardToPlay == null) {

            pickUp();

        }

        hand.remove(cardToPlay);

        // reset card variables for next turn
        cardToPlay = null;
        cardToFreeze = null;
        cardInPlay = null;

        MainWindow.getInstance().getGame().getHand().rebuildHand();

    }
}



