

package com.textadventure.game;

import com.textadventure.Enemies.Enemy;
import com.textadventure.rooms.BattleRoom;
import com.textadventure.rooms.FrontLawn;
import com.textadventure.rooms.InventoryManagement;
import com.textadventure.rooms.Location;
import com.textadventure.rooms.Notification;
import com.textadventure.rooms.NotificationCustom;
import com.textadventure.rooms.Room;
import com.textadventure.rooms.SafeHouse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;



public class GameBase
{
  public Player player;
  public String[] buttonTexts;
  public boolean[] activeButtons;
  public Location location;
  public String prevLocation;
  
  public HashMap<String, Room> rooms;
  
  public GameBase() throws FileNotFoundException
  {
    player = new Player();
    sharedStart();
  }
  
  public GameBase(File file) throws FileNotFoundException
  {
    //player = new Player(file);
    sharedStart();
  }
  
  protected void sharedStart() throws FileNotFoundException
  {
    loadRooms ();
    buttonTexts = new String[14];
    activeButtons = new boolean[14];
    
    location = new Location ();
    
    update(20);
  }
  
  public void update(int bNum)
  {
    
    if (!rooms.containsKey(location.location))
    {
      location.location = "HomeBase";
    }
    if (!(prevLocation == location.location))
    {
      rooms.get(location.location).enterRoom ();
    }
    rooms.get (location.location).update (bNum, location, player, rooms.get("Notification"), rooms);
    
    rooms.get (location.location).writeButtonText (rooms.get (location.location).state, player);
    rooms.get (location.location).writeDescription (rooms.get (location.location).state, player);
    
    prevLocation = location.location;
    updateButtons();
  }
  
  public void updateButtons()
  {
    for(int i = 0; i < buttonTexts.length; i++)
    {
      activeButtons[i] = rooms.get(location.location).activeButton[i];
      buttonTexts[i] = rooms.get(location.location).buttonText[i];
    }
  }
  
  public String UpdateText()
  {
    return rooms.get(location.location).description;
  }
  
  protected void loadRooms() throws FileNotFoundException
  {
    rooms = new HashMap<String, Room>();
    
    rooms.put ("Notification", new Notification());
    rooms.put ("NotificationCustom", new NotificationCustom ());
    rooms.put ("SafeHouse", new SafeHouse());
    rooms.put ("InventoryManagement", new InventoryManagement ());
    rooms.put ("FrontLawn", new FrontLawn ());
    rooms.put ("BattleRoom", new BattleRoom (new Enemy (5, "aalloo")));
  }
}
