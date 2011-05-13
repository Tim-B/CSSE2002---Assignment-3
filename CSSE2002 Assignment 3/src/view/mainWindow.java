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
import models.impl.Game;
import models.impl.SubjectCardImpl;
import view.components.cardComponent;

/**
 *
 * @author Tim
 */
public abstract class mainWindow {
    
    protected JFrame frame = new JFrame();
    
    protected buttonController uiController = new buttonController();
    
    protected Game game;
    
    
    public mainWindow(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        makeGUI();
  
        frame.setSize(500,500);
        
        frame.setVisible(true);
        
    }
    
    public JFrame getFrame(){
        
        return frame;
        
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
            
            cardComponent card2 = new cardComponent(subjectCard);
            
            card2.setText("Press to dispense foo 2 ");
            
            panel.add(card2, BorderLayout.NORTH);
            
            cardComponent card3 = new cardComponent(subjectCard);
            
            card3.setText("Press to dispense foo 3");
        
            panel.add(card3, BorderLayout.WEST);
            

        }catch(Exception e){
            System.out.println("Oh Shit");
        }
        
        frame.add(panel);
        
        
    }
    
    
}
