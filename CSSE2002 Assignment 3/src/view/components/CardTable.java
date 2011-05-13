/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.Card;
import models.Player;

/**
 *
 * @author Tim
 */
public class CardTable extends JScrollPane{
    
    private JPanel panel = new JPanel();
    
    private Player player;
    
    public CardTable(Player player){
        
        super();
        
        this.player = player;
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        getViewport().add(panel);
        
    }
    
    public void putCardOnTable(Card card){
        
        CardComponent tableCard = new CardComponent(card);
        
        panel.add(tableCard);
        
    }
    
}
