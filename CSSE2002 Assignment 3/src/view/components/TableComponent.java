package view.components;

//~--- non-JDK imports --------------------------------------------------------

import models.Player;

import models.impl.Game;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * The GUI component TableComponent which extends Jpanel and sets the
 * dimensions for the game.
 *
 */
public class TableComponent extends JPanel {

    /**
     * The constructor for TableComponent
     * @param game the game to be stored in TableComponent
     */
    public TableComponent(Game game) {

        super();

        setPreferredSize(new Dimension(800, 350));

        setMinimumSize(new Dimension(800, 350));

        setMaximumSize(new Dimension(800, 350));

        setLayout(new GridLayout(1, game.getNumberPlayers()));

        for (Player player : game.allPlayers()) {

            CardTable table = new CardTable(player);

            player.setPlayerTable(table);

            this.add(table);

        }

    }
}



