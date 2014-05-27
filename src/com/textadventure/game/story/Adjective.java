

package com.textadventure.game.story;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jon Ausherman
 */
public class Adjective {
    private ArrayList<String>badAdj = new ArrayList <String>();
    private ArrayList<String>creepyAdj = new ArrayList<String>();
    private ArrayList<String>goodAdj = new ArrayList<String>();
    
    public Adjective() throws FileNotFoundException{
        //bad adjectives
        Scanner sfBad = new Scanner(new File("badAdj.txt"));
        while(sfBad.hasNext()){
            badAdj.add(sfBad.nextLine());
            
        }
        //creepy adjectives
        Scanner sfCreepy = new Scanner(new File("creepyAdj.txt"));
        while(sfCreepy.hasNext()){
            creepyAdj.add(sfCreepy.nextLine());
            
        }
        //good adjectives
        Scanner sfGood = new Scanner(new File("goodAdj.txt"));
        while(sfGood.hasNext()){
            goodAdj.add(sfGood.nextLine());
        }
        
    }
    Random ranInd = new Random();
    
    public String getRandomBadAdj(){
        return badAdj.get(ranInd.nextInt(0+badAdj.size()));
    }
    
     public String getRandomCreepyAdj(){
        return creepyAdj.get(ranInd.nextInt(0+creepyAdj.size()));
    }
    
     public String getRandomGoodAdj(){
        return goodAdj.get(ranInd.nextInt(0+goodAdj.size()));
    }
}
