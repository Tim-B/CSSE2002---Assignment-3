/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Tim
 */
public class buttonController implements ActionListener{


    public void actionPerformed(ActionEvent e) {
        
        String source = e.getActionCommand();
        
        if(source.equals("hello_world")){
            
            main.app.getGame().newRound();
            
        }
        
    }
    
}
