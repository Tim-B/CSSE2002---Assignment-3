/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Michael
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({models.FreezePlayerCardTest.class, models.BadDeckExceptionTest.class, models.BadDeckOperationExceptionTest.class, models.InvalidActionExceptionTest.class, models.StudentsLifeExceptionTest.class, models.PlayerTest.class, models.BonusCardTest.class, models.CardTest.class, models.BadFormatExceptionTest.class, models.DeckTest.class, models.FreezeSubjectCardTest.class, models.impl.ImplSuite.class, models.BadCardExceptionTest.class, models.SubjectCardTest.class, models.UserExceptionTest.class})
public class ModelsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
