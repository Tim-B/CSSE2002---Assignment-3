
package view.components;

//~--- non-JDK imports --------------------------------------------------------

import models.Card;

import view.MainWindow;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Color;
import java.awt.Dimension;

import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * The class PlayerHand which extends JscrollPane() and creates a new instance
 * of JPanel().
 */
public class PlayerHand extends JScrollPane {

    JPanel handPanel = new JPanel();

    /**
     * The currently selected card
     */
    CardComponent selected;

    /**
     * The constructor for PlayerHand
     */
    public PlayerHand() {

        handPanel.setLayout(new BoxLayout(handPanel, BoxLayout.X_AXIS));

        getViewport().add(handPanel);

        setPreferredSize(new Dimension(800, 80));

        setMinimumSize(new Dimension(800, 80));

        rebuildHand();

    }

    /**
     * Highlights the selected card in the hand
     * @param selected the card which is selected
     */
    public void setSelected(CardComponent selected) {

        if (!(this.selected == null)) {

            this.selected.setBackground(null);

        }

        if (!(selected == null)) {

            selected.setBackground(Color.LIGHT_GRAY);

        }

        this.selected = selected;

    }

    /**
     * Reloads the hand in the gui
     */
    public void rebuildHand() {

        Iterator<Card> handIterator =
            MainWindow.getInstance().getGame().getGUIPlayer()
                .getCardsInHandIterator();

        handPanel.removeAll();

        while (handIterator.hasNext()) {

            handPanel.add(new HandCard(handIterator.next()));

        }

        handPanel.validate();

        handPanel.repaint();

    }

}



