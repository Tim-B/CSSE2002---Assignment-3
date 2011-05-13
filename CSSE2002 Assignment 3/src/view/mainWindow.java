/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.buttonController;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import models.BadCardException;
import models.Card;
import models.SubjectCard;
import models.impl.SubjectCardImpl;
import view.components.cardComponent;

/**
 *
 * @author Tim
 */
public abstract class mainWindow {
    
    private JFrame frame = new JFrame();
   
    
    private buttonController uiController = new buttonController();
    
    
    public mainWindow(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        makeGUI();
  
        frame.setSize(500,500);
        
        frame.setVisible(true);
        
    }
    
    private void makeGUI(){
        
        Panel panel = new Panel();
        
        panel.setLayout(new BorderLayout());
        
        JButton button = new JButton();
        
        button.setText("Hello world");
        
        button.addActionListener(uiController);
        
        button.setSize(200, 60);
        
        button.setActionCommand("hello_world");
        
        try{
            Card subjectCard = new SubjectCardImpl("Foobar");

            cardComponent card = new cardComponent(subjectCard);
            
            card.setText("Press to dispense foo");
        
            panel.add(card, BorderLayout.SOUTH);
        }catch(Exception e){
            System.out.println("Oh Shit");
        }
        
        frame.add(panel);
        
        
    }
    
    
}
