
package controllers;

//~--- JDK imports ------------------------------------------------------------

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainWindow;

/**
 * Controller for all buttons. Implements a ActionListener instance
 *
 */
public class ButtonController implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        String source = e.getActionCommand();

        if (source.equals("next_round")) {

            MainWindow.getInstance().newRound();

        }

    }
}



