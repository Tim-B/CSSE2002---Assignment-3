/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.main;
import java.awt.GridLayout;
import java.util.Iterator;
import javax.swing.JPanel;
import models.Card;
import models.impl.Game;

/**
 *
 * @author Tim
 */
public class PlayerHand extends JPanel{
    
    private Game game;
    
    public PlayerHand(Game game){
        
        this.game = game;
        
        setLayout(new GridLayout(1,game.getGUIPlayer().getHandSize()));
        
        rebuildHand();
        
    }
    
    public void rebuildHand(){
        
        Iterator<Card> handIterator = game.getGUIPlayer().getCardsInHandIterator();
        
        removeAll();
        
        while(handIterator.hasNext()){
            
            add(new HandCard(handIterator.next()));
            
        }
        
        //main.app.updateUI();
        
        validate();
        
        repaint();
        
    }
    
}
