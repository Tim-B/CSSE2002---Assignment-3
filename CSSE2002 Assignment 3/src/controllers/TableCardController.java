
package controllers;

//~--- non-JDK imports --------------------------------------------------------

import models.SubjectCard;
import models.UserException;

import models.impl.GUIPlayer;

import view.MainWindow;

import view.components.ErrorAlert;
import view.components.TableCard;

//~--- JDK imports ------------------------------------------------------------

import java.awt.event.ActionEvent;

/**
 * Controller for the TableCard object. Extends from cardController
 *
 */
public class TableCardController extends CardController {

    public void actionPerformed(ActionEvent event) {

        TableCard cardComponent = (TableCard) event.getSource();

        SubjectCard card = (SubjectCard) cardComponent.getCard();

        GUIPlayer player = MainWindow.getInstance().getGame().getGUIPlayer();

        try {

            // See if the card selected is in the players cards
            if (cardComponent.getTable().getPlayer().equals(player)) {

                player.setCardInPlay(card);

            } else {

                // If not, the player must want to freeze a card
                player.setCardToFreeze(card);

            }

            // Make the card appear selected.
            MainWindow.getInstance().getGame().setSelected(cardComponent);

        } catch (UserException ex) {

            new ErrorAlert(ex.toString());

        }

    }
}



