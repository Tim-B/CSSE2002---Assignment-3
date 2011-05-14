/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.buttonController;
import controllers.main;

import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import models.BadCardException;

import models.impl.Game;
import models.impl.SubjectCardImpl;
import view.components.PlayerHand;

import view.components.TableComponent;

/**
 *
 * @author Tim
 */
public abstract class mainWindow extends JFrame{
    
    protected buttonController uiController = new buttonController();
    
    protected Game game;
    
    
    public mainWindow(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        newGame();

        makeGUI();
  
        setSize(800,600);
        
        setVisible(true);
        
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
            
           
            panel.add(new TableComponent(game));
            
            panel.add(new PlayerHand(game));
            
            /*
            
            while(game.getGUIPlayer().getCardsInHandIterator().hasNext()){

                    try {
                        game.getGUIPlayer().getPlayerTable().putCardOnTable(game.getGUIPlayer().getCardsInHandIterator().next());
                    } catch (Exception ex) {

                        System.out.println(ex.toString());

                    }

            }
             * 
             */
            
            

        }catch(Exception e){
            System.out.println(e);
        }
        
        this.add(panel);
        
        
    }
    
    private void newGame(){
         
         game = new Game();
        
         
     }
    
    
}
