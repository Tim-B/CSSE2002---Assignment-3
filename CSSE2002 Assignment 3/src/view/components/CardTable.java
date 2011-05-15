/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.main;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.BadCardException;
import models.Card;
import models.Player;
import models.SubjectCard;
import models.impl.SubjectCardImpl;

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
        
        panel.add(new JLabel(player.getPlayerName()));
        
        getViewport().add(panel);
        
    }
    
    public void putCardOnTable(SubjectCard card){
        
        TableCard tableCard = new TableCard(card, this);
        
        card.setGUICard(tableCard);
        
        panel.add(tableCard);
        
        main.app.updateUI();
        
    }
    
    public Player getPlayer(){
        
        return player;
        
    }
    
}
