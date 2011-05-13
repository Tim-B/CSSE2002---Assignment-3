/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import models.BadFormatException;
import models.Deck;
import models.Player;
import view.components.ErrorAlert;

import models.Card;

import view.components.ShufflePopup;

/**
 *
 * @author Tim
 */
public class Game{
    
    private GUIPlayer player;
    
    private VirtualPlayer vplayer1;
    
    private VirtualPlayer vplayer2;
    
    private VirtualPlayer vplayer3;
    
    private ArrayList<Player> allPlayers = new ArrayList();
    
    private ArrayList<VirtualPlayer> vPlayers = new ArrayList();
    
    private Deck deck;
    
    public Game(){
        
        File deckFile = new File("C:/cssetxt/test4.txt");
        
        try {
            
            deck = DeckLoader.getInstance().load(deckFile);
            
            if(ShufflePopup.ShufflePopup()){
                
                deck.shuffle();
                
            }
            
            player = new GUIPlayer(deck);
            
            vplayer1 = new VirtualPlayer(deck);
            
            vplayer2 = new VirtualPlayer(deck);
            
            vplayer3 = new VirtualPlayer(deck);
            
            vPlayers.add(vplayer1);
            
            vPlayers.add(vplayer2);
            
            vPlayers.add(vplayer3);
            
            allPlayers.addAll(vPlayers);
            
            allPlayers.add(player);
            
            for(Player playerItem : allPlayers){
                
                for(Player subPlayer : allPlayers){
                    
                    if(!subPlayer.equals(playerItem)){
                        
                        playerItem.addOpponent(subPlayer);
                        
                    }
                    
                }
                
            }
            
            
            
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
            
            for(Player player : allPlayers){
                
                player.receiveCard(deck.pickUp());
                
            }
            
        }
        
    }
    
    public void newRound(){
        
        Card playCard;
        
        
    }
    
    public int getNumberPlayers(){
        
        return allPlayers.size();
        
    }
    
}
