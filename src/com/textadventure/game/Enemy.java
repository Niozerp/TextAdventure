

package com.textadventure.game;

/**
 *
 * @author Jon Ausherman
 */
public class Enemy extends Actor {
        
    private String name;
    
    public Enemy(int inLevel, String inName){
        setLevel(inLevel);
        setMaxHealth(inLevel*5);
        setMaxStrength(inLevel*7);
        setMaxDefense(inLevel*3);
        setMaxSpeed(inLevel*2);
        setMaxMagicAtk(inLevel*1);
        setMaxMagicDef(inLevel*1);
        setMaxExp (inLevel*35);
        
        setHealth(getMaxHealth());
        setStrength(getMaxStrength());
        setDefense(getMaxDefense());
        setSpeed(getMaxSpeed());
        setMagicAtk(getMaxMagicAtk());
        setMagicDef (getMaxMagicDef ());
        setExp (getMaxExp());
        name = inName;
        
    }

    @Override
    public void setExp(int exp) {
        super.setExp(exp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getExp() {
        return super.getExp(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setActorDescription(String actorDescription) {
        super.setActorDescription(actorDescription); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getActorDescription() {
        return super.getActorDescription(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMagicDef(double magicDef) {
        super.setMagicDef(magicDef); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMagicDef() {
        return super.getMagicDef(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMagicAtk(double magicAtk) {
        super.setMagicAtk(magicAtk); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMagicAtk() {
        return super.getMagicAtk(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSpeed(double speed) {
        super.setSpeed(speed); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getSpeed() {
        return super.getSpeed(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDefense(double defense) {
        super.setDefense(defense); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getDefense() {
        return super.getDefense(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStrength(double strength) {
        super.setStrength(strength); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getStrength() {
        return super.getStrength(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHealth(double health) {
        super.setHealth(health); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getHealth() {
        return super.getHealth(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLevel() {
        return super.getLevel(); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void setMaxExp(int maxExp) {
        super.setMaxExp(maxExp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMaxExp() {
        return super.getMaxExp(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMaxMagicDef(double maxMagicDef) {
        super.setMaxMagicDef(maxMagicDef); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMaxMagicDef() {
        return super.getMaxMagicDef(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMaxMagicAtk(double maxMagicAtk) {
        super.setMaxMagicAtk(maxMagicAtk); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMaxMagicAtk() {
        return super.getMaxMagicAtk(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMaxSpeed(double maxSpeed) {
        super.setMaxSpeed(maxSpeed); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMaxSpeed() {
        return super.getMaxSpeed(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMaxDefense(double maxDefense) {
        super.setMaxDefense(maxDefense); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMaxDefense() {
        return super.getMaxDefense(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMaxStrength(double maxStrength) {
        super.setMaxStrength(maxStrength); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMaxStrength() {
        return super.getMaxStrength(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMaxHealth(double maxHealth) {
        super.setMaxHealth(maxHealth); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMaxHealth() {
        return super.getMaxHealth(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }
    
}
