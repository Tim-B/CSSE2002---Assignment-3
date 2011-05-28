
package controllers;

//~--- JDK imports ------------------------------------------------------------

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The abstract class which card component controllers extend from
 * Not really needed but added in case there was a need to have common
 * methods between the two modes of card.
 */
public abstract class CardController implements ActionListener {

    public void actionPerformed(ActionEvent event) {}
}



