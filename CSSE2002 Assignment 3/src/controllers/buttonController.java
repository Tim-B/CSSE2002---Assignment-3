/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Controller for all buttons. Implements a ActionListener instance
 * 
 */
public class buttonController implements ActionListener{


    public void actionPerformed(ActionEvent e) {
        
        String source = e.getActionCommand();
        
        if(source.equals("next_round")){
            
            main.app.newRound();
            
        }
        
    }
    
}
