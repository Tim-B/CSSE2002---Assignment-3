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
import javax.swing.BoxLayout;

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
        
        mainPanel = new JPanel();
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        
        mainPanel.setSize(800,600);
        
        add(mainPanel);
        
    }
    
    public Game getGame(){
        
        return game;
        
    }

    
    public void newGame(){
         
        game = new Game();
        
        mainPanel.removeAll();
        
        mainPanel.add(new GameEnvironmentComponent(game));
        
        mainPanel.revalidate();
        
        mainPanel.repaint();

        updateUI();
        
     }
    
    public void endGame(){
        
        game = null;
        
        mainPanel.removeAll();
        
        mainPanel.revalidate();
        
        mainPanel.repaint();
        
        updateUI();
        
    }
    
    public void updateUI(){

        validate();
        
        repaint();
        
        
    }  
    
}
