/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Controller for all menu components. Implements ActionListener instance
 * 
 */
public class menuController implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        
        String source = e.getActionCommand();
        
        if(source.equals("new_game")){
            
            main.app.newGame();
            
        }
        
    }
    
}
