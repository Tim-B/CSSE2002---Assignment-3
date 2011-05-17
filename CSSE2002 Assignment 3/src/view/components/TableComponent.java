/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.Dimension;
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
    
    /**
     * The constructor for TableComponent
     * @param game the game to be stored in TableComponent
     */
    public TableComponent(Game game){
        
        super();
        
        setPreferredSize(new Dimension(800,350));
        
        setMinimumSize(new Dimension(800,350));
        
        setMaximumSize(new Dimension(800,350));
        
        setLayout(new GridLayout(1,game.getNumberPlayers()));
        
        for(Player player : game.allPlayers()){
            
            CardTable table = new CardTable(player);
                   
            player.setPlayerTable(table);
            
            this.add(table);
            
        }
        
    }
    
}
