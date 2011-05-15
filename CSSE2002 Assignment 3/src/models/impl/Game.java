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
    
    public Game(){
        
        File deckFile = new File("C:/cssetxt/test4.txt");
        
        try {
            
            deck = DeckLoader.getInstance().load(deckFile);
            
            if(ShufflePopup.ShufflePopup()){
                
                deck.shuffle();
                
            }
            
            player = new GUIPlayer(deck);
            
            for(int i = 0; i < 3; i++){
                
                VirtualPlayer vPlayer = new VirtualPlayer(deck);
                
                vPlayer.setPlayerName("Computer Player "+i);
                
                vPlayers.add(vPlayer);
                
            }
            
            allPlayers.addAll(vPlayers);
            
            player.setPlayerName("Human player");
            
            allPlayers.add(player);
            
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
    
    public ArrayList<Player> allPlayers(){
        
        return allPlayers;
        
    }
    
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
    
    public void newRound(){
        
        try {
            
            player.pickUp();
                         
            player.play();
            
            playVPlayers();
            
        } catch (UserException ex) {
            
            new ErrorAlert(ex.toString());
            
        }
        
    }
    
    public GUIPlayer getGUIPlayer(){
        
        return player;
        
    }
    
    public int getNumberPlayers(){
        
        return allPlayers.size();
        
    }
    
    public PlayerHand getHand(){
        
        return hand;
        
    }
    
    public void setHand(PlayerHand hand){
        
        this.hand = hand;
        
    }
    
    private void playVPlayers(){
        
        for(VirtualPlayer vplayer : vPlayers){
            
            vplayer.play();
            
        }
        
    }
    
}
