package view.components;

import controllers.HandCardController;
import models.Card;

/**
 *The GUI element class which extends CardComponent and calls 
 * HandCardController().
 * 
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
