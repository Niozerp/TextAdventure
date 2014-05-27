package com.textadventure.rooms;

import com.textadventure.game.Player;
import java.util.HashMap;
import java.util.Hashtable;

public class SafeHouse extends Room
{
  public SafeHouse()
  {
    
  }

  @Override
  public void update (int bNum, Location location, Player player, Room notification, HashMap<String, Room> rooms)
  {
    switch (state)
    {
      case 0:
      {
        switch (bNum)
        {
          case 0: { changeState (1);}break;
          case 3: {goToRoom ("InventoryManagement", location);}break;
        }
      }break;
        
      case 1:
      {
        switch (bNum)
        {
          case 0: {explore(notification, player); goToRoom("Notification", location);} break;
          case 1: {rooms.get ("NotificationCustom").destenation = "FrontLawn"; rooms.get ("NotificationCustom").description = "You decide go to the front yard.";  goToRoom ("NotificationCustom", location);}break;
          case 9: {changeState (0);} break;
        }
      }break;
    }
  }
  
  @Override
  public void writeButtonText (int state, Player player)
  {  
    super.writeButtonText (state, player);
    
    switch (state)
    {
    case 0:
      {
        buttonText[0] = "Explore";
        activeButton[0] = true;

        buttonText[3] = "Inventory";
        activeButton[3] = true;

        buttonText[10] = "Menu";
        activeButton[10] = true;

        buttonText[12] = "Level Up";
        activeButton[12] = true;

        buttonText[13] = "Appearence";
        activeButton[13] = true;
      }break;
      
      case 1:
      {
        buttonText[0] = "Look arround";
        activeButton[0] = true;
        
        if(player.discoveredFrontYard)
        {
          buttonText[1] = "The Front Yard";
          activeButton[1] = true;
        }
        
        buttonText[9] = "Nevermind";
        activeButton[9] = true;
      }break;
    } 
  }

  @Override
  public void writeDescription (int state, Player player)
  {
    switch(state)
    {
      case 0:
      {
        description =
          "You are in your home.  It hasnt been the nicest since the demons arrived, and you havent found the time to clean it yet.\n"
        + "\n"
        + "The couch is probably the most comfortable place in the house currently, seeing as your bedroom got sucked into the portal when the event first happened.";
      }break;
        
      case 1:
      {
        description = 
                "You are prepared to explore the dangerous lands.  How far are you willing to go?";
      }break;
    }
  }
  
  public void explore(Room notification, Player player)
  {
    double chance = Math.random ();
    if (2 * chance >= 1.25)
    {
      notification.description = "You have managed to find the front yard.  Congrats";
      player.discoveredFrontYard = true;
    }
    else
    {
      notification.description = "You found nothing.";
    }
  }
}
