package view.components;

import controllers.main;
import javax.swing.JOptionPane;

/**
 *The GUI component class ShufflePopup which calls the JOptionPane().
 * 
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
