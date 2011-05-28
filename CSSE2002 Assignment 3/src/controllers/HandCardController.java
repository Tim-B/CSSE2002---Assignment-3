
package controllers;

//~--- non-JDK imports --------------------------------------------------------

import models.Card;

import models.impl.GUIPlayer;

import view.MainWindow;

import view.components.HandCard;

//~--- JDK imports ------------------------------------------------------------

import java.awt.event.ActionEvent;

/**
 * Controller for the HandCard object. Extended from cardController
 *
 */
public class HandCardController extends CardController {

    public void actionPerformed(ActionEvent event) {

        HandCard cardComponent = (HandCard) event.getSource();

        Card card = cardComponent.getCard();

        // Get the object of the GUI player
        GUIPlayer player = MainWindow.getInstance().getGame().getGUIPlayer();

        // Make the GUI component appear to be selected
        MainWindow.getInstance().getGame().getHand().setSelected(cardComponent);

        player.setCardToPlay(card);

    }
}



