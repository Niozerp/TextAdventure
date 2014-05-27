package com.textadventure.Item;


public class ItemType
{
  public String ItemType;
  public int maxStack;
  public String description;
  
  public ItemType(String title, int StackLimit, String descript)
  {
    ItemType = title;
    maxStack = StackLimit;
    description = descript;
  }
}
