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

import models.impl.Game;

import view.components.TableComponent;

/**
 *
 * @author Tim
 */
public abstract class mainWindow extends JFrame{
    
    protected buttonController uiController = new buttonController();
    
    protected Game game;
    
    
    public mainWindow(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        newGame();

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
            
           
            panel.add(new TableComponent(game));
            
            

        }catch(Exception e){
            System.out.println(e);
        }
        
        this.add(panel);
        
        
    }
    
    private void newGame(){
         
         System.out.println("Foo");
         
         game = new Game();
         
         System.out.println(game.getNumberPlayers());
         
     }
    
    
}
