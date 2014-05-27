package com.textadventure.Item;

public class Item
{
  public String ItemType;
  public int maxStack;
  public int count;
  public String description;
  
  public Item(ItemType itemType, int number)
  {
    ItemType = itemType.ItemType;
    maxStack = itemType.maxStack;
    description = itemType.description;
    
    count = number;
  }
}
