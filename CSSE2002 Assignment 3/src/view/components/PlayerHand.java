/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.main;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.Card;
import models.impl.Game;

/**
 *
 * @author Tim
 */
public class PlayerHand extends JScrollPane{
    
    JPanel handPanel = new JPanel();
    
    /**
     * The constructor for PlayerHand
     */
    public PlayerHand(){
        
        handPanel.setLayout(new BoxLayout(handPanel, BoxLayout.X_AXIS));
        
        getViewport().add(handPanel);
        
        setPreferredSize(new Dimension(800,80));
        
        setMinimumSize(new Dimension(800,80));
        
        rebuildHand();
        
    }
    
    /**
     * Reloads the hand in the gui
     */
    public void rebuildHand(){
        
        Iterator<Card> handIterator = main.app.getGame().getGUIPlayer().getCardsInHandIterator();
        
        handPanel.removeAll();
        
        while(handIterator.hasNext()){
            
            handPanel.add(new HandCard(handIterator.next()));
            
        }
        
        handPanel.validate();
        
        handPanel.repaint();
        
    }
    
}
