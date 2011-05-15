/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.buttonController;
import javax.swing.JButton;

/**
 *
 * @author Tim
 */
public class ButtonComponent extends JButton{
    
    ButtonComponent(String title, String action){
        
        setText(title);
        
        addActionListener(new buttonController());
        
        setActionCommand(action);
         
    }
    
}
