/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Card;
import models.SubjectCard;
import models.UserException;
import models.impl.GUIPlayer;
import view.components.ErrorAlert;
import view.components.HandCard;

/**
 *
 * @author Tim
 */
public class HandCardController extends CardController{
    
    public void actionPerformed(ActionEvent event){
            
            HandCard cardComponent = (HandCard) event.getSource();

            Card card = cardComponent.getCard();

            if(card instanceof SubjectCard){

                System.out.println("Fooch");

                GUIPlayer player = main.app.getGame().getGUIPlayer();

                player.setCardToPlay(card);
                
            }
                            
        }

    
}
