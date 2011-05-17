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
    
    /**
     * Displays an error message
     * @param message the string message to be displayed
     */
    public ErrorAlert(String message){
            
        JOptionPane.showMessageDialog(main.app, message);
        
    }
    
}
