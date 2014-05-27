package com.textadventure.rooms;

import com.textadventure.Enemies.Enemy;
import com.textadventure.game.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Room
{
    public String description;
    public String[] buttonText;
    public boolean[] activeButton;
    public int state;
    public String destenation;
    
    public Room()
    {     
      state = 0;
      buttonText = new String[14];
      activeButton = new boolean[14];
      
      clearInput ();
    }
    
    public String roomDescription()
    {
      return description;
    }
    
    public void writeDescription(int state, Player player)
    {
      
    }
    
    public void writeButtonText(int state, Player player)
    {
      clearInput ();
    }
    
    public void update(int bNum, Location location, Player player, Room notification, HashMap<String, Room> rooms)
    {
      
    }
    
    public void enterRoom()
    {
      state = 0;
    }
    
    public void changeState(int newState)
    {
      state = newState;
    }
    
    public void clearInput()
    {
      for(int i = 0; i < buttonText.length; i++)
      {
        buttonText[i] = "";
      }
      
      for(int i = 0; i < activeButton.length; i++)
      {
        activeButton[i] = false;
      }
    }
    
    public void goToRoom(String newLocation, Location location)
    {
      state = 0;
      location.goTo (newLocation);
    }
    
    public void BattleRoomSetup(Enemy enemy, HashMap<String, Room> rooms)
    {
      rooms.get ("NotificationCustom").destenation = "BattleRoom";
      rooms.remove ("BattleRoom");
      rooms.put ("BattleRoom", new BattleRoom (enemy));
    }
}
