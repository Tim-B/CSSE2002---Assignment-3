/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.buttonController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
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
            /**Setting up top and bottom panel */
            
            
            Panel topPanel = new Panel();
            topPanel.setLayout(new GridLayout(1,4));
            panel.add(topPanel, BorderLayout.NORTH);
            
            
            Panel bottomPanel = new Panel();
            topPanel.setLayout(new GridLayout(1,1));
            panel.add(bottomPanel, BorderLayout.SOUTH);
            
            /**Adding the scrolling panels to the top panel */
            
            Card subjectCard = new SubjectCardImpl("Foobar");
            cardComponent card = new cardComponent(subjectCard);
            card.setText("PLayer 1- Card 1");
            
            Card subjectCard1 = new SubjectCardImpl("Foobar");
            cardComponent card1 = new cardComponent(subjectCard);
            card1.setText("PLayer 1- Card 2");
            
            Card subjectCard2 = new SubjectCardImpl("Foobar");
            cardComponent card2 = new cardComponent(subjectCard);
            card2.setText("PLayer 1- Card 3");
            
            Card subjectCard3 = new SubjectCardImpl("Foobar");
            cardComponent card3 = new cardComponent(subjectCard);
            card3.setText("PLayer 1- Card 3");
            
           
            JScrollPane topPanel_1 = new JScrollPane(card);
            JScrollPane topPanel_2 = new JScrollPane(card1);
            JScrollPane topPanel_3 = new JScrollPane(card2);
            JScrollPane topPanel_4 = new JScrollPane(card3);
            topPanel.add(topPanel_1);
            topPanel.add(topPanel_2);
            topPanel.add(topPanel_3);
            topPanel.add(topPanel_4);
            
            
            
            
           
            
            
            
            
            
            
            
       
//            Card subjectCard = new SubjectCardImpl("Foobar");
//
//            cardComponent card = new cardComponent(subjectCard);
//           
//            card.setText("PLayer 1- Card 1");
//            
//            Card subjectCard4 = new SubjectCardImpl("Foobar");
//
//            cardComponent card4 = new cardComponent(subjectCard);
//           
//            card4.setText("Player 1 - Card 2");
//            Panel player1Panel = new Panel();
//            player1Panel.setLayout(new BorderLayout());
//            player1Panel.add(card, BorderLayout.CENTER);
//            player1Panel.add(card4, BorderLayout.EAST);
//            
//            panel.add(player1Panel, BorderLayout.WEST);
//            
//            Card subjectCard1 = new SubjectCardImpl("Foobar");
//
//            cardComponent card1 = new cardComponent(subjectCard);
//           
//            card1.setText("PLayer 2");
//            Panel player2Panel = new Panel();
//            player2Panel.setLayout(new BorderLayout());
//            player2Panel.add(card1, BorderLayout.CENTER);
//            panel.add(player2Panel, BorderLayout.CENTER); 
//            
//            
//            Card subjectCard2 = new SubjectCardImpl("Foobar");
//
//            cardComponent card2 = new cardComponent(subjectCard);
//           
//            card2.setText("PLayer 3");
//            Panel player3Panel = new Panel();
//            player3Panel.setLayout(new BorderLayout());
//            player3Panel.add(card2, BorderLayout.CENTER);
//            panel.add(player3Panel, BorderLayout.EAST);
            
            
           
            
            
            

        }catch(Exception e){
            System.out.println("Oh Shit");
        }
        
        frame.add(panel);
        
        
    }
    
    
}
