
package controllers;

//~--- non-JDK imports --------------------------------------------------------

import view.MainWindow;

//~--- JDK imports ------------------------------------------------------------

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for all buttons. Implements a ActionListener instance
 *
 */
public class ButtonController implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        String source = e.getActionCommand();

        // Action for the next round button
        if (source.equals("next_round")) {

            MainWindow.getInstance().newRound();

        }

    }
}



