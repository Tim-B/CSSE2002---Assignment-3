/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.GridLayout;
import javax.swing.JPanel;
import models.BadCardException;
import models.Player;
import models.impl.Game;
import models.impl.SubjectCardImpl;

/**
 *
 * @author Tim
 */
public class TableComponent extends JPanel{
    
    public TableComponent(Game game){
        
        super();
        
        
        setLayout(new GridLayout(1,game.getNumberPlayers()));
        
        for(Player player : game.allPlayers()){
            
            CardTable table = new CardTable(player);
                   
            player.setPlayerTable(table);
            
            this.add(table);
            
        }
        
    }
    
}
