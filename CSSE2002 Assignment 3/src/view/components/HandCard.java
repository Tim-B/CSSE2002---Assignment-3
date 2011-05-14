/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.HandCardController;
import models.Card;

/**
 *
 * @author Tim
 */
public class HandCard extends CardComponent{
    
    public HandCard(Card card){
        
        super(card);
        
        addActionListener(new HandCardController());
        
    }
    
}
