package view.components;

//~--- non-JDK imports --------------------------------------------------------

import controllers.TableCardController;

import models.Card;
import models.SubjectCard;

/**
 * The GUI Component class TableCard which extends the CardComponent and controls.
 *
 */
public class TableCard extends CardComponent {

    /**
     * Stores the instance of the table
     */
    private CardTable table;

    /**
     * The constructor for TableCard
     * @param card the card to be stored
     * @param table the table to be stored
     */
    public TableCard(Card card, CardTable table) {

        super(card);

        this.table = table;

        addActionListener(new TableCardController());

    }

    /**
     * Returns the table for this instance of the game
     * @return the CardTable instance that represents this instance of the game
     */
    public CardTable getTable() {

        return table;

    }

    /**
     * Set's the label on the Card instance
     */
    private void setDetails() {

        String name = "<html><center><b>" + card.getName() + "</b>";

        SubjectCard subCard = (SubjectCard) card;

        if (subCard.isGraded()) {

            name = name.concat("<br />(GRADED)");

        } else if (subCard.isFrozen()) {

            name = name.concat("<br />(FROZEN)");

        }

        name = name.concat("</center></html>");

        setText(name);

    }

    /**
     * Updates the TableCard instance
     */
    public void update() {

        setDetails();

        revalidate();

        repaint();

    }
}



