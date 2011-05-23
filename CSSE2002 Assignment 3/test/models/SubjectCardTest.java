/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.components.TableCard;

/**
 *
 * @author Michael
 */
public class SubjectCardTest {
    
    public SubjectCardTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getCardFrozenBy method, of class SubjectCard.
     */
    @Test
    public void testGetCardFrozenBy() {
    }

    /**
     * Test of freezeWith method, of class SubjectCard.
     */
    @Test
    public void testFreezeWith() {
    }

    /**
     * Test of gradeWith method, of class SubjectCard.
     */
    @Test
    public void testGradeWith() {
    }

    /**
     * Test of unfreeze method, of class SubjectCard.
     */
    @Test
    public void testUnfreeze() {
    }

    /**
     * Test of isFrozen method, of class SubjectCard.
     */
    @Test
    public void testIsFrozen() {
    }

    /**
     * Test of isGraded method, of class SubjectCard.
     */
    @Test
    public void testIsGraded() {
    }

    /**
     * Test of setGUICard method, of class SubjectCard.
     */
    @Test
    public void testSetGUICard() {
    }

    /**
     * Test of getGUICard method, of class SubjectCard.
     */
    @Test
    public void testGetGUICard() {
    }

    public class SubjectCardImpl implements SubjectCard {

        public FreezeSubjectCard getCardFrozenBy() {
            return null;
        }

        public void freezeWith(FreezeSubjectCard card) throws InvalidActionException {
        }

        public void gradeWith(FreezeSubjectCard card) throws InvalidActionException {
        }

        public void unfreeze() throws InvalidActionException {
        }

        public boolean isFrozen() {
            return false;
        }

        public boolean isGraded() {
            return false;
        }

        public void setGUICard(TableCard card) {
        }

        public TableCard getGUICard() {
            return null;
        }
    }
}
