/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.buttonController;
import controllers.main;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import models.BadCardException;

import models.impl.Game;
import models.impl.SubjectCardImpl;
import view.components.ErrorAlert;
import view.components.GameEnvironmentComponent;
import view.components.MenuComponent;
import view.components.PlayerHand;

import view.components.TableComponent;

/**
 *
 * @author Tim
 */
public abstract class mainWindow extends JFrame{
    
    protected buttonController uiController = new buttonController();
    
    protected Game game;
    
    JPanel mainPanel;
      
    public mainWindow(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setResizable(false); 
  
        setSize(800,600);
        
        setJMenuBar(new MenuComponent());
        
        setVisible(true);
        
    }
    
    public Game getGame(){
        
        if(game == null){
            
            new ErrorAlert("Game not started");
            
        }
        
        return game;
        
    }

    
    public void newGame(){
         
        game = new Game();
        
        add(new GameEnvironmentComponent(game));

        updateUI();
        
     }
    
    public void updateUI(){
        
        validate();

        repaint();
        
    }  
    
}
