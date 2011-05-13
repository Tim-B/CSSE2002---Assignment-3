/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.main;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */
public class ErrorAlert {
    
    public ErrorAlert(String message){
            
        JOptionPane.showMessageDialog(main.app.getFrame(), message);
        
    }
    
}
