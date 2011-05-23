package models.impl;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import models.BadFormatException;
import models.Deck;
import models.Player;
import view.components.CardComponent;
import view.components.ErrorAlert;
import view.components.PlayerHand;

import view.components.ShufflePopup;

/**
 * The model for the game. Loads the deck and adds players to the game.
 * @author Tim
 */
public class Game{
    
    private GUIPlayer player;
    
    private ArrayList<Player> allPlayers = new ArrayList();
    
    private ArrayList<VirtualPlayer> vPlayers = new ArrayList();
    
    private Deck deck;
    
    private PlayerHand hand;  
        
    /**
     * The currently selected card
     */
    private CardComponent selected;
    
    /**
     * Main function of the game
     */
    public Game(File deckFile){
        
        try {
            
            deck = DeckLoader.getInstance().load(deckFile);
            
            if(ShufflePopup.ShufflePopup()){
                
                deck.shuffle();
                
            }
            
            player = new GUIPlayer(deck);
            
            allPlayers.add(player);
            
            for(int i = 0; i < 3; i++){
                
                VirtualPlayer vPlayer = new VirtualPlayer(deck);
                
                vPlayer.setPlayerName("Computer Player "+i);
                
                vPlayers.add(vPlayer);
                
            }
            
            allPlayers.addAll(vPlayers);
            
            player.setPlayerName("Human player");
            
            for(Player playerItem : allPlayers){
                
                for(Player subPlayer : allPlayers){
                    
                    if(!subPlayer.equals(playerItem)){
                        
                        playerItem.addOpponent(subPlayer);
                        
                    }
                    
                }
                
            }
            
            deal();
            
        } catch (IOException ex) {
            
            new ErrorAlert("File could not be found");
            
        } catch (BadFormatException ex) {
            
            new ErrorAlert("File is poorly formatted");
            
        }
        
    }
    
    /**
     * Returns all players
     * @return a ArrayList of Player objects representing allPlayers
     */
    public ArrayList<Player> allPlayers(){
        
        return allPlayers;
        
    }
    
    /**
     * Returns all virtual players
     * @return a ArrayList of Player objects representing vPlayers
     */
    public ArrayList<VirtualPlayer> vPlayers(){
        
        return vPlayers;
        
    }
    
    private void deal(){
        
        for(int i = 0; i < 5; i++){
            
            for(Player iPlayer : allPlayers){
                
                iPlayer.pickUp();
                
            }
            
        }
        
    }
    
    /**
     * Returns the main player
     * @return returns the instance of GUIPlayer object for the game
     */
    public GUIPlayer getGUIPlayer(){
        
        return player;
        
    }
    
    /**
     * Returns the number of players in the game
     * @return the integer value of the size of allPlayers for the game
     */
    public int getNumberPlayers(){
        
        return allPlayers.size();
        
    }
    
    /**
     * Returns the players hand
     * @return the instance of PlayerHand that is the players hand
     */
    public PlayerHand getHand(){
        
        return hand;
        
    }
    
    /**
     * Sets the hand of the player
     * @param hand hand is the instance of PlayerHand that is being set to the
     * users hand
     */
    public void setHand(PlayerHand hand){
        
        this.hand = hand;
        
    }
    
        
        
     /**
     * Highlights the selected card in the hand
     * @param selected the card which is selected
     */
    public void setSelected(CardComponent selected){
        
        if(!(this.selected == null)){
            
                this.selected.setBackground(null);
                
        }
        
        if(!(selected == null)){
            
            selected.setBackground(Color.LIGHT_GRAY);
            
        }
        
        this.selected = selected;
        
    }
     
}
