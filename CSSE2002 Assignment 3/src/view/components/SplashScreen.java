
package view.components;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates the splash screen for the program and displays a message
 */
public class SplashScreen extends JPanel {

    /**
     * Constructor, generates the label.
     */
    public SplashScreen() {

        setSize(800, 456);

        add(new JLabel("Welcome to The Student Life Game!"));

    }
}



