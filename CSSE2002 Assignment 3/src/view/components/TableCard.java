/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.TableCardController;
import models.Card;

/**
 *
 * @author Tim
 */
public class TableCard extends CardComponent{
    
    private CardTable table;
    
    public TableCard(Card card, CardTable table){
        
        super(card);
        
        this.table = table;
        
        addActionListener(new TableCardController());
        
    }
    
    public CardTable getTable(){
        
        return table;
        
    }
    
}
