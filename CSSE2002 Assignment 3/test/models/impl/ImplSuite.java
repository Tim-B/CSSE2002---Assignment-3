/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Michael
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({models.impl.FreezePlayerCardImplTest.class, models.impl.BonusCardImplTest.class, models.impl.DeckImplTest.class, models.impl.AbstractPlayerTest.class, models.impl.CardImplTest.class, models.impl.GUIPlayerTest.class, models.impl.FreezeSubjectCardImplTest.class, models.impl.GameTest.class, models.impl.VirtualPlayerTest.class, models.impl.DeckLoaderSkeletonTest.class, models.impl.DeckLoaderTest.class, models.impl.SubjectCardImplTest.class})
public class ImplSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
