package com.textadventure.rooms;

import com.textadventure.game.Player;
import com.textadventure.Item.Item;
import com.textadventure.Item.ItemType;
import java.util.HashMap;
import java.util.Hashtable;

public class InventoryManagement extends Room
{
  public int selectedItem = 9;
  
  @Override
  public void update (int bNum, Location location, Player player, Room notification, HashMap<String, Room> rooms)
  {
    switch (state)
    {
      case 0:
      {
        if (bNum == 9)
        {
          goToRoom ("SafeHouse", location);
        }
        else
        {
          state = 1;
          selectedItem = bNum;
        }
      }break;
      
      case 1:
      {
        switch (bNum)
        {
          case 0: {player.inventory.itemSlot[selectedItem].count -= 1; state = 0; } break;
          case 9: {state = 0;} break;
        }
      }
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
        for (int i=0; i<9; i++)
        {
          if (player.inventory.itemSlot[i].count != 0)
          {
            buttonText[i] = player.inventory.itemSlot[i].ItemType +" * " + player.inventory.itemSlot[i].count;
            activeButton[i] = true;
          }
        }
        
        buttonText[9] = "Back";
        activeButton[9] = true;
        
      }break;
      
      case 1:
      {
        buttonText[0] = "Use " + player.inventory.itemSlot[selectedItem].ItemType;
        activeButton[0] = true;
        
        buttonText[9] = "Invenory";
        activeButton[9] = true;
      }
    }
  }

  @Override
  public void writeDescription (int state, Player player)
  {
    switch (state)
    {
      case 0:
      {
        description = "This is your inventory, where you store your glorious loot.\n";
        if (player.inventory.money != 0){description += "\n\n\nYou have " + player.inventory.money + " monetary units.";}
      }break;
      
      case 1:
      {
        description = "You are examining your " + player.inventory.itemSlot[selectedItem].ItemType + ".";
      }
    }
  }

}
