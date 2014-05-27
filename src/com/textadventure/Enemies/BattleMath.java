package com.textadventure.Enemies;

import com.textadventure.game.Actor;

/**
 *
 * @author Jon Ausherman
 */
public class BattleMath {
    
    public double AttackDamage(Actor atacker, Actor defender){
        defender.setHealth(defender.getHealth() - (atacker.getStrength()-defender.getDefense()));
        return atacker.getStrength()-defender.getDefense();
    }
    
    public double MagicDamage(Actor atacker, Actor defender){
        defender.setHealth(defender.getHealth() - (atacker.getMagicAtk()-defender.getMagicDef()));
        return atacker.getMagicAtk()-defender.getMagicDef();
    }
    
    

}
