/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Michael
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({view.components.MenuComponentTest.class, view.components.GameEnvironmentComponentTest.class, view.components.ButtonComponentTest.class, view.components.ShufflePopupTest.class, view.components.PlayerHandTest.class, view.components.CardTableTest.class, view.components.HandCardTest.class, view.components.TableComponentTest.class, view.components.CardComponentTest.class, view.components.TableCardTest.class, view.components.ErrorAlertTest.class})
public class ComponentsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
