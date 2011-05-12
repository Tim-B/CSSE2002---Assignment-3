/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.uiController;
import java.awt.BorderLayout;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Tim
 */
public class mainWindow {
    
    private JFrame frame = new JFrame();
    
    private static mainWindow instance = new mainWindow();
    
    private uiController uiController = new uiController();
    
    public static mainWindow getInstance(){
        
        return instance;
        
    }
    
    private mainWindow(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        makeGUI();
        
        frame.setSize(500,500);
        
    }
    
    private void makeGUI(){
        
        Panel panel = new Panel();
        
        panel.setLayout(new BorderLayout());
        
        JButton button = new JButton();
        
        button.setText("Hello world");
        
        button.addActionListener(uiController);
        
        button.setSize(200, 60);
        
        button.setActionCommand("hello_world");
        
        panel.add(button, BorderLayout.SOUTH);
        
        frame.add(panel);
        
        
    }
    
    public void drawView(){
        
        frame.setVisible(true);
        
    }
    
}
