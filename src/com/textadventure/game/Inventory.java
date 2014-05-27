package com.textadventure.game;

import com.textadventure.Item.ImpHide;
import com.textadventure.Item.Item;
import com.textadventure.Item.ItemType;
import com.textadventure.Item.emptyItem;
import java.util.ArrayList;


public class Inventory
{
  public Item[] itemSlot;
  public int money;
  
  public Inventory()
  {
    itemSlot = new Item[9];
    money = 0;
    
    for(int i = 0; i < itemSlot.length; i++)
    {
      itemSlot[i] = new Item (new emptyItem (), 0);
    }
    
    itemSlot[0] = new Item (new ImpHide (), 9);
  }
  
  public void addToInventory(ItemType item, int count)
  {
    for(int i = 0; i < itemSlot.length; i++)
    {
      int temp = count;
      for (int n = 0; n < temp; n++)
      {
        if (itemSlot[i].ItemType == item.ItemType && itemSlot[i].count < itemSlot[i].maxStack)
         {
          count -= 1;
          itemSlot[i].count += 1;
        }
      }
    }
    
    if (count > 0)
    {
      for(int i = 0; i < itemSlot.length; i++)
      {
        if (itemSlot[i].ItemType == null)
        {
          itemSlot[i] = new Item(item, 0);
          
          int temp = count;
          for (int n = 0; n < temp; n++)
          {
            if (itemSlot[i].ItemType.equalsIgnoreCase(item.ItemType) && itemSlot[i].count < itemSlot[i].maxStack)
             {
              count -= 1;
              itemSlot[i].count += 1;
            }
          }
        }
      }
    }
  }
}
