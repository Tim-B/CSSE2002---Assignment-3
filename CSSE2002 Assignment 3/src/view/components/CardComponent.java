/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import javax.swing.JButton;
import models.Card;
import controllers.cardController;
import java.awt.Dimension;

/**
 *
 * @author Tim
 */
public class CardComponent extends JButton{
    
    Card card;
    
    Boolean frozen;
    
    Boolean graded;
    
    public CardComponent(Card card){
        
        super();
        
        this.card = card;
        
        this.setMaximumSize(new Dimension(180, 90));
        
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