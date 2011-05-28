package view.components;

//~--- non-JDK imports --------------------------------------------------------

import controllers.MenuController;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * The GUI component which extends JMenuBar and initializes the JMenuItem().
 *
 */
public class MenuComponent extends JMenuBar {

    /**
     * The constructor for MenuComponent
     */
    public MenuComponent() {

        super();

        JMenuItem menuItem = new JMenuItem();

        menuItem.setText("New Game");

        menuItem.addActionListener(new MenuController());

        menuItem.setActionCommand("new_game");

        this.add(menuItem);

    }
}



