
package controllers;

//~--- non-JDK imports --------------------------------------------------------

import models.SubjectCard;
import models.UserException;
import models.impl.GUIPlayer;
import view.components.ErrorAlert;
import view.components.TableCard;

//~--- JDK imports ------------------------------------------------------------

import java.awt.event.ActionEvent;
import view.MainWindow;

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

            if (cardComponent.getTable().getPlayer().equals(player)) {

                player.setCardInPlay(card);

            } else {

                player.setCardToFreeze(card);

            }

            MainWindow.getInstance().getGame().setSelected(cardComponent);

        } catch (UserException ex) {

            new ErrorAlert(ex.toString());

            // MainWindow.getInstance().getGame().setSelected(null);

        }

    }
}



