/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Card;
import models.SubjectCard;
import models.UserException;
import models.impl.GUIPlayer;
import view.components.ErrorAlert;
import view.components.HandCard;
import view.components.TableCard;

/**
 * Controller for the TableCard object. Extends from cardController
 * 
 */
public class TableCardController extends CardController{

    public void actionPerformed(ActionEvent event) {
        
        TableCard cardComponent = (TableCard) event.getSource();

        SubjectCard card = (SubjectCard) cardComponent.getCard();
        
        GUIPlayer player = main.app.getGame().getGUIPlayer();
        
        try{
        
            if(cardComponent.getTable().getPlayer().equals(player)){

                player.setCardInPlay(card);

            }else{

                player.setCardToFreeze(card);

            }
            
            main.app.getGame().setSelected(cardComponent);
        
        } catch (UserException ex) {
            
            new ErrorAlert(ex.toString());
            
        }
            
    }
    
}
