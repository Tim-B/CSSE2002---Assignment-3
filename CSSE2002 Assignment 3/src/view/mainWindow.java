/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.buttonController;
import controllers.main;
import java.awt.BorderLayout;





import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Player;


import models.impl.Game;

import view.components.ErrorAlert;
import view.components.GameEnvironmentComponent;
import view.components.MenuComponent;


/**
 * The main GUI window. Starts new rounds and games.
 * Extends a JFrame Swing element
 * 
 */
public abstract class mainWindow extends JFrame{
    
    /**
     * 
     */
    protected buttonController uiController = new buttonController();
    
    /**
     * 
     */
    protected Game game;
    
    JPanel mainPanel;
      
    /**
     * The main function of the GUI
     */
    public mainWindow(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setResizable(false); 
  
        //setSize(800,600);
        
        setJMenuBar(new MenuComponent());
        
        setVisible(true);
        
        mainPanel = new JPanel();
        
        mainPanel.setLayout(new BorderLayout());
        
        //mainPanel.setSize(800,600);
        
        add(mainPanel);
        
        pack();
        
    }
    
    /**
     * Gets the current game
     * @return the instance of Game that is the current game
     */
    public Game getGame(){
        
        return game;
        
    }

    
    /**
     * Initializes a new game
     */
    public void newGame(){
         
        game = new Game();
        
        mainPanel.removeAll();
        
        mainPanel.add(new GameEnvironmentComponent(game));
        
        mainPanel.revalidate();
        
        mainPanel.repaint();

        updateUI();
        
     }
    
    /**
     * Ends the current game
     */
    public void endGame(){
        
        game = null;
        
        mainPanel.removeAll();
        
        mainPanel.revalidate();
        
        mainPanel.repaint();
        
        updateUI();
        
    }
    
    /**
     * Starts a new round of the current game
     */
    public void newRound(){
        
        try {
                         
            for(Player currentPlayer : game.allPlayers()){
                
                currentPlayer.play();
                
                if(currentPlayer.wonGame()){
                    
                    new ErrorAlert("Game won by: " + currentPlayer.getPlayerName());
                    
                    main.app.endGame();
                    
                    break;
                    
                }
            
            }
            
        } catch (Exception ex) {
            
            new ErrorAlert(ex.toString());
            
        }
        
    }
    
    /**
     * Updates the entire GUI
     */
    public void updateUI(){

        validate();
        
        repaint();
        
        pack();
        
    }  
    
}
