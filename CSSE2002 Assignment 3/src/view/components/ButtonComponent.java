package view.components;

import controllers.buttonController;
import javax.swing.JButton;

/**
 *The GUI Component class extending from Jbutton for buttons from the GUI
 * which call the buttonController().
 */
public class ButtonComponent extends JButton{
    
    ButtonComponent(String title, String action){
        
        setText(title);
        
        addActionListener(new buttonController());
        
        setActionCommand(action);
         
    }
    
}
