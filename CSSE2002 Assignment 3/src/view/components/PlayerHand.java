/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.main;
import java.awt.GridLayout;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JPanel;
import models.Card;
import models.impl.Game;

/**
 *
 * @author Tim
 */
public class PlayerHand extends JPanel{
    
    
    public PlayerHand(){
        
        //main.app.getGame().getGUIPlayer().getHandSize())
        
        setLayout(new GridLayout(1,5));
        
        rebuildHand();
        
    }
    
    public void rebuildHand(){
        
        Iterator<Card> handIterator = main.app.getGame().getGUIPlayer().getCardsInHandIterator();
        
        removeAll();
        
        while(handIterator.hasNext()){
            
            add(new HandCard(handIterator.next()));
            
        }
        
        
        //add(new JButton("Foobar"));
        
        validate();
        
        repaint();
        
    }
    
}
