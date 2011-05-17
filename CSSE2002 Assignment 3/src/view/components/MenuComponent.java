package view.components;

import controllers.menuController;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *The GUI component which extends JMenuBar and initializes the JMenuItem().
 * 
 */
public class MenuComponent extends JMenuBar{
    
    /**
     * The constructor for MenuComponent
     */
    public MenuComponent(){
        
        super();
        
        JMenuItem menuItem = new JMenuItem();
        
        menuItem.setText("New Game");
        
        menuItem.addActionListener(new menuController());
        
        menuItem.setActionCommand("new_game");
        
        this.add(menuItem);
        
    }
    
}
