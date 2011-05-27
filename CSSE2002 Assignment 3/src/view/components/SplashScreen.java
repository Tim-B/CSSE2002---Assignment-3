
package view.components;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates the splash screen for the program and displayes a message
 *
 * @author Tim
 */
public class SplashScreen extends JPanel {

    /**
     *
     */
    public SplashScreen() {

        setSize(800, 456);

        add(new JLabel("Welcome to The Student Life Game!"));

    }
}



