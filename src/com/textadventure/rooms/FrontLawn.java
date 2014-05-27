package com.textadventure.rooms;

import com.textadventure.Enemies.Imp;
import com.textadventure.game.Player;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrontLawn extends Room
{

  @Override
  public void update (int bNum, Location location, Player player, Room notification, HashMap<String, Room> rooms)
  {
    switch (bNum)
    {
      case 0: {try {
          encounter(location, player, notification, rooms);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrontLawn.class.getName()).log(Level.SEVERE, null, ex);
        }
} break;
    }
  }

  @Override
  public void writeButtonText (int state, Player player)
  {
    super.writeButtonText (state, player);
    buttonText[0] = "Next";
    activeButton[0] = true;
  }

  @Override
  public void writeDescription (int state, Player player)
  {
    description = "You swing open the door and carefully explore your front lawn.  You are keeping as alert as you can.\n";
    
  }
   public void encounter(Location location, Player player, Room notification, HashMap<String, Room> rooms) throws FileNotFoundException
   {
     double chance = (Math.random ());
    if (chance <= 0.5)
    {
      BattleRoomSetup (new Imp (1), rooms);
      goToRoom ("BattleRoom", location);
    }
    if (0.5 < chance && chance <= .7)
    {
      BattleRoomSetup (new Imp (3), rooms);
      goToRoom ("BattleRoom", location);
    }
    if (0.7 < chance && chance <= .75)
    {
      BattleRoomSetup (new Imp (1024), rooms);
      goToRoom ("BattleRoom", location);
    }
    if (0.75< chance)
    {
      notification.description = "You find nothing, and you return home.";
      goToRoom ("Notification", location);
    }
   }
}
