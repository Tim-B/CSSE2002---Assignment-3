/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controllers.TableCardController;
import models.Card;
import models.SubjectCard;

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
    
    private void setDetails(){
        
        String name = "<html><center><b>" + card.getName() + "</b>";
        
        SubjectCard subCard = (SubjectCard) card;
        
        if(subCard.isFrozen()){
            
            name = name.concat("<br />(FROZEN)");
            
        }else if(subCard.isGraded()){
            
            name = name.concat("<br />(GRADED)");
            
        }
        
        name = name.concat("</center></html>");
        
        setText(name);
        
    }
    
    public void update(){
        
        setDetails();
        
    }
    
}
