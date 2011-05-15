/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

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
        
        gbContraints.ipadx = 440;
        
        gbContraints.ipady = 260;
        
        //gbContraints.fill = GridBagConstraints.HORIZONTAL;

        add(new TableComponent(game), gbContraints);

        PlayerHand hand = new PlayerHand();

        game.setHand(hand);
        
        gbContraints.gridy = 1;
        
        gbContraints.ipady = 120;

        add(hand, gbContraints);
        
        ButtonComponent nextRound = new ButtonComponent("Next Round", "next_round");
        
        gbContraints.ipady = 40;
        
        gbContraints.gridy = 3;
        
        add(nextRound, gbContraints);

        validate();

        repaint();
        
    }
    
}
