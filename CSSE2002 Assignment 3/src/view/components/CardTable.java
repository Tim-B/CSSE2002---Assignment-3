package view.components;

//~--- non-JDK imports --------------------------------------------------------

import controllers.main;

import models.Player;
import models.SubjectCard;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * The class CardTable is a GUI object which which extends JScrollPane and
 * represents the cards a player has.
 */
public class CardTable extends JScrollPane {

    private JPanel panel = new JPanel();
    private Player player;

    /**
     * The current selected
     */
    private CardComponent selected;

    /**
     * Constructor for the CardTable class
     * @param player the main player for this instance of the game
     */
    public CardTable(Player player) {

        super();

        this.player = player;

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel(player.getPlayerName()));

        getViewport().add(panel);

    }

    /**
     * Puts a card on the table
     * @param card the instance of Card that is being added to the table
     */
    public void putCardOnTable(SubjectCard card) {

        TableCard tableCard = new TableCard(card, this);

        card.setGUICard(tableCard);

        panel.add(tableCard);

        main.app.updateUI();

    }

    /**
     * Returns the player for this instance of the game
     * @return the main player for this instance of the game
     */
    public Player getPlayer() {

        return player;

    }

}



