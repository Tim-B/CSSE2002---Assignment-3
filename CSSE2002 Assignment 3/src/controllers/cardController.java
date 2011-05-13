/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Card;
import view.components.CardComponent;


/**
 *Michaels and mc
 * @author Tim
 */
public class cardController implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        
        CardComponent cardComp = (CardComponent) e.getSource();
        
        Card card = cardComp.getCard();
        
        System.out.println(card.getName());
        
    }
    
}
