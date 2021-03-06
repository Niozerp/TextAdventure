package com.textadventure.rooms;

import com.textadventure.game.Player;
import java.util.HashMap;
import java.util.Hashtable;

public class NotificationCustom extends Room
{

  public NotificationCustom ()
  {
    
  }
  
  @Override
  public void update (int bNum, Location location, Player player, Room notification, HashMap<String, Room> rooms)
  {
    switch (bNum)
    {
      case 0:
      {
        location.goTo (destenation);
      }break;
    }
  }

  @Override
  public void writeButtonText (int state, Player player)
  {
    super.writeButtonText (state, player);
    
    buttonText[0] = "Next";
    activeButton[0] = true;
  }  
  
  public void setNotification(String notification)
  {
    description = notification;
  }
}
