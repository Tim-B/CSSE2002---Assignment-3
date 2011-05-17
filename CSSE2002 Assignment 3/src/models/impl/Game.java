/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.BadFormatException;
import models.Deck;
import models.Player;
import models.UserException;
import view.components.ErrorAlert;

import models.Card;
import view.components.PlayerHand;

import view.components.ShufflePopup;

/**
 *
 * @author Tim
 */
public class Game{
    
    private GUIPlayer player;
    
    private ArrayList<Player> allPlayers = new ArrayList();
    
    private ArrayList<VirtualPlayer> vPlayers = new ArrayList();
    
    private Deck deck;
    
    private PlayerHand hand;
    
    /**
     * Main function of the game
     */
    public Game(){
        
        File deckFile = new File("C:/cssetxt/test4.txt");
        
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
     
}
