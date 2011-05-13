/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.impl.Game;
import view.mainWindow;

/**
 * Hello fucking world
 * @author Tim
 */
public class main extends mainWindow{
    
    public static main app;
    
     public static void main(String[] a){
         
         app = new main();
         
         app.newGame();
         
     }
     
     public void newGame(){
         
         game = new Game();
         
     }
    
}
