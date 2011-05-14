/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.menuController;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Tim
 */
public class MenuComponent extends JMenuBar{
    
    public MenuComponent(){
        
        super();
        
        JMenuItem menuItem = new JMenuItem();
        
        menuItem.setText("New Game");
        
        menuItem.addActionListener(new menuController());
        
        menuItem.setActionCommand("new_game");
        
        this.add(menuItem);
        
    }
    
}
