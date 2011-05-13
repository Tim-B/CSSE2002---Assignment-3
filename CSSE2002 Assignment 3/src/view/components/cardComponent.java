/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import javax.swing.JButton;
import models.Card;
import controllers.cardController;

/**
 *
 * @author Tim
 */
public class cardComponent extends JButton{
    
    Card card;
    
    Boolean frozen;
    
    Boolean graded;
    
    public cardComponent(Card card){
        
        super();
        
        this.card = card;
        
        setActionCommand("card_" + Integer.toString(card.getId()));
        
        addActionListener(new cardController());
        
    }
    
    public void setCard(Card card){
        
        this.card = card;
        
        setActionCommand("card_" + Integer.toString(card.getId()));
        
    }
    
    public Card getCard(){
        
        return card;
        
    }
    
}
