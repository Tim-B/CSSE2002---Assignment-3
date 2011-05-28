
package controllers;

//~--- non-JDK imports --------------------------------------------------------

import view.MainWindow;

//~--- JDK imports ------------------------------------------------------------

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for all menu components. Implements ActionListener instance
 *
 */
public class MenuController implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        String source = e.getActionCommand();

        // Action for the new game button
        if (source.equals("new_game")) {

            MainWindow.getInstance().newGame();

        }

    }
}



