/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import view.mainWindow;

/**
 *
 * @author Tim
 */
public class main {
    
     public static void main(String[] a){
         
         mainWindow window = mainWindow.getInstance();
         
         window.drawView();
         
     }
    
}
