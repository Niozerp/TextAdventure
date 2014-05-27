

package com.textadventure.game;

/**
 *
 * @author Jon Ausherman
 * 
 */
public class Actor {
    private double health;
    private double strength;
    private double defense;
    private double speed;
    private double magicAtk;
    private double magicDef;
    private int exp;
    private int level;
    private String actorDescription;
    
    private double maxHealth;
    private double maxStrength;
    private double maxDefense;
    private double maxSpeed;
    private double maxMagicAtk;
    private double maxMagicDef;
    private int maxExp;
  

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getMagicAtk() {
        return magicAtk;
    }

    public void setMagicAtk(double magicAtk) {
        this.magicAtk = magicAtk;
    }

    public double getMagicDef() {
        return magicDef;
    }

    public void setMagicDef(double magicDef) {
        this.magicDef = magicDef;
    }

    public String getActorDescription() {
        return actorDescription;
    }

    public void setActorDescription(String actorDescription) {
        this.actorDescription = actorDescription;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getMaxStrength() {
        return maxStrength;
    }

    public void setMaxStrength(double maxStrength) {
        this.maxStrength = maxStrength;
    }

    public double getMaxDefense() {
        return maxDefense;
    }

    public void setMaxDefense(double maxDefense) {
        this.maxDefense = maxDefense;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMaxMagicAtk() {
        return maxMagicAtk;
    }

    public void setMaxMagicAtk(double maxMagicAtk) {
        this.maxMagicAtk = maxMagicAtk;
    }

    public double getMaxMagicDef() {
        return maxMagicDef;
    }

    public void setMaxMagicDef(double maxMagicDef) {
        this.maxMagicDef = maxMagicDef;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }
}
