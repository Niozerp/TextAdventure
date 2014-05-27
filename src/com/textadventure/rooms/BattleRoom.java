package com.textadventure.rooms;

import com.textadventure.Enemies.BattleMath;
import com.textadventure.Enemies.Enemy;
import com.textadventure.Item.ImpHide;
import com.textadventure.Item.Item;
import com.textadventure.game.Player;
import java.util.HashMap;

/**
 *
 * @author Jon Ausherman & Zach Spratt
 */
public class BattleRoom extends Room {

    public Enemy enemy;
    private double playerDmg;
    private double enemyDmg;
    public BattleMath bttle = new BattleMath();
            
    public BattleRoom(Enemy inEnemy){
        enemy = inEnemy;
    }
    
    @Override
    public void enterRoom() {
        super.enterRoom(); 
    }

    @Override
    public void update(int bNum, Location location, Player player, Room notification, HashMap<String, Room> rooms) {
        System.out.println (state);
       switch (state)
        { 
            case 0:
            {
                switch (bNum)
                {
                  case 0: {attack(player); changeState(1);}break;
                  case 1: {magic(player); changeState(1);}break;
                  case 2: {changeState(2);}break;
                  case 3: {changeState(2);}break;
                  case 4: {changeState(3);}break;
                  case 9: {tryToRun (player, enemy, location, rooms); changeState (4); bttle.AttackDamage(enemy, player);}break;
                }
            } break;

            case 1:
              {
                switch (bNum)
                {
                    case 0: {changeState (0);} break;
                }
              }break;
              
            case 2:
            {
              switch(bNum)
              {
                case 0: {changeState (0);
                }
              }
            }
        }
       checkDeath (player, enemy, notification, location);
   }

    @Override
    public void writeButtonText(int state, Player player) {
        super.writeButtonText(state, player); 
        
        switch(state){
            case 0:
            {
                buttonText[0] = "Attack";
                activeButton[0] = true;
                
                buttonText[1] = "Magic";
                activeButton[1] = true;
                
                buttonText[2] = "Special";
                activeButton[2] = true;
                
                buttonText[9] = "Run";
                activeButton[9] = true;
                
                //buttonText[3] = "Inventory";
                //activeButton[3] = true; 
            }break;
            case 1:
            {
              buttonText[0] = "Next";
              activeButton[0] = true;
            }
            case 2:
            {
              buttonText[0] = "Next";
              activeButton[0] = true;
            }
      }
    }

    @Override
    public void writeDescription(int state, Player player) {
         switch(state)
          {
          case 0:
          {
            description = "You have encountered a Level " + enemy.getLevel()+ " " + enemy.getName() +".\n"
                    + "The " + enemy.getName ()+" has " + (int)enemy.getHealth () + " health"
                    + "\nHow do you proceed?";
          }break;

          case 1:
          {
            description = 
                    "You did " + playerDmg + ". " + "\n" + enemy.getName() 
                    + " did " + enemyDmg + ".";
          }break;
          case 2:
          {
            description = "Not Yet Implimented.";
          }break;
            
            case 4:
          {
            description = enemy.getName() 
                    + " did " + enemyDmg + " as you attempted and failed to run away.";
          }break;
        }
    }
    
    public void setEnemy(Enemy inEnemy){
        enemy = inEnemy;
    }
    
    public void attack(Player player){
              playerDmg=bttle.AttackDamage(player, enemy);
              enemyDmg=bttle.AttackDamage(enemy, player);
    }
    
    public void magic(Player player){
              playerDmg=bttle.MagicDamage(player, enemy);
              enemyDmg=bttle.MagicDamage(enemy, player);
    }
    
    public void checkDeath(Player player, Enemy enemy, Room notification, Location location)
    {
      if (player.getHealth () <= 0)
      {
        player.setHealth (player.getMaxHealth () * .1);
        notification.description = "You were defeated.  And you limped to your house";
        goToRoom ("Notification", location);
      }
      
      if (enemy.getHealth () <= 0)
      {
        notification.description = "You defeaed the " + enemy.getName () + ".\n"
                                  + "And you walk home proudly.\n\n\n"+
        
                                  
                                  "You now have three more imp hide.";
        player.inventory.addToInventory (new ImpHide(), 3);
        player.setExp (player.getExp () + enemy.getExp ());
        goToRoom ("Notification", location);
      }
    }
    
    public void tryToRun(Player player, Enemy enemy, Location location, HashMap<String, Room> rooms)
    {
      if(1.25*player.getSpeed () > .75*enemy.getSpeed ())
      {
        rooms.get ("Notification").description = "You managed to run away";
        goToRoom ("Notification", location);
      }
    }
}
