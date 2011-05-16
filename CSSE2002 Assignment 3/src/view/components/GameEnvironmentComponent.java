/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import models.impl.Game;

/**
 *
 * @author Tim
 */
public class GameEnvironmentComponent extends JPanel{
    
    public GameEnvironmentComponent(Game game){
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbContraints = new GridBagConstraints();
        
        gbContraints.gridx = 0;
        
        gbContraints.gridy = 0;
        
        gbContraints.fill = GridBagConstraints.BOTH;

        add(new TableComponent(game), gbContraints);

        PlayerHand hand = new PlayerHand();

        game.setHand(hand);
        
        gbContraints.gridy = 1;

        add(hand, gbContraints);
        
        ButtonComponent nextRound = new ButtonComponent("Next Round", "next_round");
        
        nextRound.setMinimumSize(new Dimension(800, 80));
        
        gbContraints.gridy = 3;
        
        add(nextRound, gbContraints);

        validate();

        repaint();
        
    }
    
}
