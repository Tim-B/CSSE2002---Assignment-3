/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.GridLayout;
import javax.swing.JPanel;
import models.Player;
import models.impl.Game;

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
            
            this.add(table);
            
        }
        
    }
    
}
