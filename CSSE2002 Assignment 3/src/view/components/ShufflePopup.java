/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.main;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */
public class ShufflePopup {
    
    /**
     * The constructor for ShufflePopup
     * @return a boolean value for shuffling the deck
     */
    public static Boolean ShufflePopup(){
    
        int result = new JOptionPane().showConfirmDialog(main.app, 
                
            "Do you want to shuffle the deck?",
                
            "Shuffle deck",
                
            JOptionPane.YES_NO_OPTION);
        
        if(result == JOptionPane.YES_OPTION){
            
            return true;
            
        }else{
            
            return false;
            
        }
        
   }
    
}
