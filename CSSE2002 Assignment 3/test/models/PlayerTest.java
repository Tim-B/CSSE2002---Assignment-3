/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.components.CardTable;

/**
 *
 * @author Michael
 */
public class PlayerTest {
    
    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of addOpponent method, of class Player.
     */
    @Test
    public void testAddOpponent() {
    }

    /**
     * Test of receiveCard method, of class Player.
     */
    @Test
    public void testReceiveCard() {
    }

    /**
     * Test of play method, of class Player.
     */
    @Test
    public void testPlay() throws Exception {
    }

    /**
     * Test of unfrozenSubjectCardsInPlay method, of class Player.
     */
    @Test
    public void testUnfrozenSubjectCardsInPlay() {
    }

    /**
     * Test of pickUp method, of class Player.
     */
    @Test
    public void testPickUp() {
    }

    /**
     * Test of getCardsInHandIterator method, of class Player.
     */
    @Test
    public void testGetCardsInHandIterator() {
    }

    /**
     * Test of getCardsInPlayIterator method, of class Player.
     */
    @Test
    public void testGetCardsInPlayIterator() {
    }

    /**
     * Test of getPlayerName method, of class Player.
     */
    @Test
    public void testGetPlayerName() {
    }

    /**
     * Test of setPlayerName method, of class Player.
     */
    @Test
    public void testSetPlayerName() {
    }

    /**
     * Test of setPlayerTable method, of class Player.
     */
    @Test
    public void testSetPlayerTable() {
    }

    /**
     * Test of getPlayerTable method, of class Player.
     */
    @Test
    public void testGetPlayerTable() {
    }

    /**
     * Test of incGrade method, of class Player.
     */
    @Test
    public void testIncGrade() {
    }

    /**
     * Test of wonGame method, of class Player.
     */
    @Test
    public void testWonGame() {
    }

    public class PlayerImpl implements Player {

        public void addOpponent(Player p) {
        }

        public void receiveCard(Card card) {
        }

        public void play() throws UserException {
        }

        public int unfrozenSubjectCardsInPlay() {
            return 0;
        }

        public void pickUp() {
        }

        public Iterator<Card> getCardsInHandIterator() {
            return null;
        }

        public Iterator<SubjectCard> getCardsInPlayIterator() {
            return null;
        }

        public String getPlayerName() {
            return "";
        }

        public void setPlayerName(String name) {
        }

        public void setPlayerTable(CardTable table) {
        }

        public CardTable getPlayerTable() {
            return null;
        }

        public void incGrade() {
        }

        public boolean wonGame() {
            return false;
        }
    }
}
