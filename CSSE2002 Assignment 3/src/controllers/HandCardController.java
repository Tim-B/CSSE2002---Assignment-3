
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package controllers;

//~--- non-JDK imports --------------------------------------------------------

import models.Card;
import models.FreezeSubjectCard;
import models.SubjectCard;
import models.UserException;

import models.impl.FreezeSubjectCardImpl;
import models.impl.GUIPlayer;

import view.components.ErrorAlert;
import view.components.HandCard;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for the HandCard object. Extended from cardController
 *
 */
public class HandCardController extends CardController {

    public void actionPerformed(ActionEvent event) {

        HandCard  cardComponent = (HandCard) event.getSource();

        Card      card          = cardComponent.getCard();

        GUIPlayer player        = main.app.getGame().getGUIPlayer();

        main.app.getGame().getHand().setSelected(cardComponent);

        player.setCardToPlay(card);

    }
}



