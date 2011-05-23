/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.buttonController;
import controllers.main;
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;





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
     * Sets the button controller to the buttonController class
     */
    protected buttonController uiController = new buttonController();
    
    /**
     * The instance of the current game
     */
    protected Game game;
    
    /**
     * The instance of the main content panel
     */
    private JPanel mainPanel;
    
    private final JFileChooser fileChooser = new JFileChooser();
      
    /**
     * The main function of the GUI
     */
    public mainWindow(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setResizable(false); 
        
        setJMenuBar(new MenuComponent());
        
        setVisible(true);
        
        mainPanel = new JPanel();
        
        mainPanel.setLayout(new BorderLayout());
        
       final JFileChooser fc = new JFileChooser();
        
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
         
        int returnVal = fileChooser.showOpenDialog(mainPanel);
        
        try{
        
            File file = fileChooser.getSelectedFile();

            game = new Game(file);

            mainPanel.removeAll();

            mainPanel.add(new GameEnvironmentComponent(game));

            mainPanel.revalidate();

            mainPanel.repaint();

            updateUI();
            
        }catch(Exception exep){
            
        }
        
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
                         
            game.setSelected(null);
            
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
            
            game.getHand().setSelected(null);
            
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
