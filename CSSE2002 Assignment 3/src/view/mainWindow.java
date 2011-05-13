/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.buttonController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
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
public abstract class mainWindow extends JFrame{
    
    protected buttonController uiController = new buttonController();
    
    protected Game game;
    
    
    public mainWindow(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        makeGUI();
  
        this.setSize(800,600);
        
        this.setVisible(true);
        
    }
    
    public Game getGame(){
        
        return game;
        
    }
    
    
    private void makeGUI(){
        
        Panel panel = new Panel();
        
        panel.setLayout(new GridLayout(2,1));
        
        
        JButton button = new JButton();
        
        button.setText("Hello world");
        
        button.addActionListener(uiController);
        
        button.setSize(200, 60);
        
        button.setActionCommand("hello_world");
        
        try{
            /**Setting up top and bottom panel */
            
            
            Panel topPanel = new Panel();
            topPanel.setLayout(new GridLayout(1,4));
            
            panel.add(topPanel);
            
            
            Panel bottomPanel = new Panel();
            topPanel.setLayout(new GridLayout(1,1));
            panel.add(bottomPanel);
            
            /**Adding the scrolling panels to the top panel */
            
            
            Card subjectCard1 = new SubjectCardImpl("Foobar");
            cardComponent card1 = new cardComponent(subjectCard1);
            card1.setText("PLayer 1- Card 2");
            
            Card subjectCard2 = new SubjectCardImpl("Foobar");
            cardComponent card2 = new cardComponent(subjectCard2);
            card2.setText("PLayer 1- Card 3");
            
            Card subjectCard3 = new SubjectCardImpl("Foobar");
            cardComponent card3 = new cardComponent(subjectCard3);
            card3.setText("PLayer 1- Card 3");
            
            JPanel player1table = new JPanel();
            
            player1table.setLayout(new BoxLayout(player1table, BoxLayout.Y_AXIS));
                        
            for(int i = 0; i < 50; i++){
                
                Card subjectCard = new SubjectCardImpl("Foobar");
                cardComponent card = new cardComponent(subjectCard);
                card.setText("Card : "+i);
                
                player1table.add(card);
                
            }
            
            //JScrollPane topPanel_1 = new JScrollPane(list);
            
           
            JScrollPane topPanel_1 = new JScrollPane(player1table);
           
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
        
        this.add(panel);
        
        
    }
    
    
}
