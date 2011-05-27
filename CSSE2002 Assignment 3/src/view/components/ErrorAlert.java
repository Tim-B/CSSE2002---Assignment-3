package view.components;

//~--- non-JDK imports --------------------------------------------------------

import controllers.main;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.JOptionPane;

/**
 * Represents the error message display to be displayed.
 */
public class ErrorAlert {

    /**
     * Displays an error message
     * @param message the string message to be displayed
     */
    public ErrorAlert(String message) {

        JOptionPane.showMessageDialog(main.app, message);

    }
}



