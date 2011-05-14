/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.GridLayout;
import javax.swing.JPanel;
import models.impl.Game;

/**
 *
 * @author Tim
 */
public class GameEnvironmentComponent extends JPanel{
    
    public GameEnvironmentComponent(Game game){
        
        setLayout(new GridLayout(2,1));

        add(new TableComponent(game));

        PlayerHand hand = new PlayerHand();

        game.setHand(hand);

        add(hand);

        validate();

        repaint();
        
    }
    
}
