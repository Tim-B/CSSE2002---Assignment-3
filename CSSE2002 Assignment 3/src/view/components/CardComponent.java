/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import javax.swing.JButton;
import models.Card;
import java.awt.Dimension;
import models.SubjectCard;

/**
 *
 * @author Tim
 */
public abstract class CardComponent extends JButton{
    
    Card card;
    
    Boolean frozen;
    
    Boolean graded;
    
    /**
     * Constructor for the CardComponent
     * @param card the instance of Card that is stored as a GUI component
     */
    public CardComponent(Card card){
        
        super();
        
        setCard(card);
        
        this.setMaximumSize(new Dimension(180, 90));
        
        setActionCommand("card_" + Integer.toString(card.getId()));
        
    }
    
    /**
     * Sets the card as a GUI component
     * @param card the card to be set as a GUI component
     */
    public void setCard(Card card){
        
        this.card = card;
        
        setActionCommand("card_" + Integer.toString(card.getId()));
        
        setDetails();
        
    }
    
    private void setDetails(){
        
        setText("<html><center><b>" + card.getName() + "</b></center></html>");   
        
    }
    
    /**
     * Returns the card this instance of CardComponent is based on
     * @return returns the instance of Card that is being used as a GUI component
     */
    public Card getCard(){
        
        return card;
        
    }
    
    /**
     * Updates the details of a instance of CardComponent
     */
    public void update(){
        
        setDetails();
        
    }
    
}