/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Michael
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({controllers.mainTest.class, controllers.TableCardControllerTest.class, controllers.CardControllerTest.class, controllers.menuControllerTest.class, controllers.HandCardControllerTest.class, controllers.buttonControllerTest.class})
public class ControllersSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
