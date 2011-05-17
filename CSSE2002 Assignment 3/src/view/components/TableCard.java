package view.components;

import controllers.TableCardController;
import models.Card;
import models.SubjectCard;

/**
 *The GUI Component class TableCard which extends the CardComponent and controls.
 *
 */
public class TableCard extends CardComponent{
    
    private CardTable table;
    
    /**
     * The private constructor for TableCard
     * @param card the card to be stored
     * @param table the table to be stored 
     */
    public TableCard(Card card, CardTable table){
        
        super(card);
        
        this.table = table;
        
        addActionListener(new TableCardController());
        
    }
    
    /**
     * Returns the table for this instance of the game
     * @return the CardTable instance that represents this instance of the game
     */
    public CardTable getTable(){
        
        return table;
        
    }
    
    private void setDetails(){
        
        String name = "<html><center><b>" + card.getName() + "</b>";
        
        SubjectCard subCard = (SubjectCard) card;
        
        if(subCard.isGraded()){
            
            name = name.concat("<br />(GRADED)");
            
        }else if(subCard.isFrozen()){
            
            name = name.concat("<br />(FROZEN)");
            
        }
        
        name = name.concat("</center></html>");
        
        setText(name);
        
    }
    
    /**
     * Updates the TableCard instance
     */
    public void update(){
        
        setDetails();
        
        revalidate();
        
        repaint();
        
    }
    
}
