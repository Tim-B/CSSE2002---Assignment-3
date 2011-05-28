package view.components;

//~--- non-JDK imports --------------------------------------------------------

import models.impl.Game;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

/**
 * The class GameEnviromentComponent which extends JPanel controls the instance
 * of game to be used in the GUI element.
 *
 */
public class GameEnvironmentComponent extends JPanel {

    /**
     * The constructor for the GameEnvironmentComponent
     * @param game the instance of game to be used in this gui element
     */
    public GameEnvironmentComponent(Game game) {

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

        ButtonComponent nextRound = new ButtonComponent("Next Round",
                                        "next_round");

        nextRound.setMinimumSize(new Dimension(800, 80));

        gbContraints.gridy = 3;

        add(nextRound, gbContraints);

        validate();

        repaint();

    }
}



