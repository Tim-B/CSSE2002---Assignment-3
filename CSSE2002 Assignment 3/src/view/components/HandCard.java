/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.HandCardController;
import models.Card;
import models.SubjectCard;

/**
 *
 * @author Tim
 */
public class HandCard extends CardComponent{
    
    /**
     * The constructor for the class Handcard
     * @param card the Card instance to be stored as a instance of HandCard
     */
    public HandCard(Card card){
        
        super(card);
        
        addActionListener(new HandCardController());
        
    }
    
}
