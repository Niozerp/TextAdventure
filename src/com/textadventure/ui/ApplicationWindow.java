package com.textadventure.ui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.textadventure.game.GameBase;
import java.io.FileNotFoundException;
import javafx.scene.effect.Effect;

public class ApplicationWindow extends Application 
{

  public GameBase game; 
  
  
  public Stage primaryStage;
  public Button button[];
  public Text sceneText;
  ScrollPane textBox;
  
  public Text healthValue = new Text ("hp");
  public Text strengthValue = new Text ("str");
  public Text defenseValue = new Text ("def");
  public Text speedValue = new Text ("spd");
  public Text magicAtkValue = new Text ("mAtk");
  public Text magicDefValue = new Text ("mDef");
  public Text expValue = new Text ("exp");
  public Text lvlValue = new Text ("lvl");
  
  public double health = 100;
  public double strength = 10;
  public double defense = 10;
  public double speed = 5;
  public double magicAtk = 2;
  public double magicDef = 2;
  public int exp = 25;
  public int level = 1;
  
  public double maxHealth = 10110011;
  public double maxStrength = 10110011;
  public double maxDefense = 10110011;
  public double maxSpeed = 10110011;
  public double maxMagicAtk = 10110011;
  public double maxMagicDef = 10110011;
  public int maxExp = 100;
  
  public Rectangle hpBar;
  public Rectangle strBar;
  public Rectangle defBar;
  public Rectangle spdBar;
  public Rectangle mAtkBar;
  public Rectangle mDefBar;
  public Rectangle expBar;
  
  public static void main (String[] args)
  {
    launch(args);
  }
  
  @Override
  public void start (Stage pStage) throws FileNotFoundException
  {
    game= new GameBase();
    primaryStage = pStage;
    button = new Button[14];
    
    for (int i = 0; i < button.length; i++)
    {
      button[i] = new Button ();
      double ButtonWidth = 100;
      button[i].setMinWidth (ButtonWidth);
      button[i].setPrefWidth(ButtonWidth);
      button[i].setMaxWidth (ButtonWidth);
      button[i].setOpacity (.8);
    }
    
    button[10].setText ("Menu");
    button[11].setText ("Perks");
    button[12].setText ("Level Up");
    button[13].setText ("Appearence");
    
    buttonActionSetup();
    
    sceneText = new Text();
    sceneText.setFont (Font.font("Arial", 15));
    
    int width = 60;
    int height = 15;
    hpBar = RectangleBuilder.create().x (0).y(0).width(width * (health/maxHealth)).height(height).fill(Color.GREEN).build ();
    strBar = RectangleBuilder.create().x (0).y(0).width(width * (strength/maxStrength)).height(height).fill(Color.ORANGE).build ();
    defBar = RectangleBuilder.create().x (0).y(0).width(width * (defense/maxDefense)).height(height).fill(Color.ORANGE).build ();
    spdBar = RectangleBuilder.create().x (0).y(0).width(width * (speed/maxSpeed)).height(height).fill(Color.YELLOW).build ();
    mAtkBar = RectangleBuilder.create().x (0).y(0).width(width * (magicAtk/maxMagicAtk)).height(height).fill(Color.BLUE).build ();
    mDefBar = RectangleBuilder.create().x (0).y(0).width(width * (magicDef/maxMagicDef)).height(height).fill(Color.BLUE).build ();
    expBar = RectangleBuilder.create().x (0).y(0).width(width * (10)).height(height).fill(Color.AQUAMARINE).build ();
    
    
    constructUI ();
    
    gameUpdate (20);
  }
  
  public void constructUI()
  {
    StackPane root = new StackPane ();
    Scene scene = new Scene (root, 800, 550, Color.TAN);
    
    GridPane grid = new GridPane ();
    grid.setAlignment (Pos.CENTER);
    grid.setHgap (10);
    grid.setVgap (10);
    
    grid.add(OptionButtons (), 0, 0);
    
    root.getChildren ().add (TextBox ());
    root.getChildren ().add (CharacterStats ());
    root.getChildren ().add (OptionButtons ());
    
    primaryStage.setTitle ("Where's My Yard: The Game");
    primaryStage.setScene (scene);
    primaryStage.show ();
  }
  
  public GridPane OptionButtons()
  {
    GridPane grid = new GridPane ();
    grid.setAlignment (Pos.CENTER);
    grid.setMinHeight (600);
    grid.setPrefHeight (600);
    grid.setMaxHeight (600);
    grid.setVgap (450);
    
    grid.add (ActionButtons (), 0, 1);
    grid.add (MenuButtons (), 0, 0);
    
    return grid;
  }
  
  public GridPane TextBox()
  {
    GridPane grid = new GridPane();
    grid.setAlignment (Pos.CENTER);
    
    Rectangle rectangle = RectangleBuilder.create ().x (0).y (0).width (601).height (401).fill (Color.BLACK).build ();
    Rectangle rectangle2 = RectangleBuilder.create ().x (0).y (0).width (600).height (400).fill (Color.WHITE).build ();
    
    sceneText.setText ("Alphabet soup is the soup of the soupiest souped souls of soupy soup, only for those who like soup anyway.  \naaccaa");
    
    textBox = new ScrollPane ();
    textBox.setContent (sceneText);
    sceneText.setWrappingWidth (580);
    
    textBox.setHbarPolicy (ScrollPane.ScrollBarPolicy.NEVER);
    textBox.setVbarPolicy (ScrollPane.ScrollBarPolicy.ALWAYS);
    
    grid.add(rectangle, 0, 0);
    grid.add (rectangle2, 0, 0);
    grid.add (textBox, 0, 0);
    return grid;
  }
  
  public GridPane CharacterStats()
  {
    GridPane grid = new GridPane();
    grid.setAlignment (Pos.CENTER_LEFT);
    grid.setHgap (5);
    grid.setVgap (10);
    
    Text hpText = new Text ("Health:");
    Text strText = new Text ("Strength:");
    Text defText = new Text ("Defense:");
    Text spdText = new Text ("Speed:");
    Text mAtkText = new Text ("Magic Atk:");
    Text mDefText = new Text ("Magic Def:");
    Text expText = new Text ("Exp:");
    Text lvlText = new Text ("Level: ");
    
    StatStringUpdate ();
    
    grid.add(hpBar, 0, 0)   ;grid.add(hpText, 0, 0);   grid.add(healthValue, 1, 0); 
    grid.add(strBar, 0, 1)   ;grid.add(strText, 0, 1);  grid.add(strengthValue, 1, 1);
    grid.add(defBar, 0, 2)   ;grid.add(defText, 0, 2);  grid.add(defenseValue, 1, 2);
    grid.add(spdBar, 0, 3)   ;grid.add(spdText, 0, 3);  grid.add(speedValue, 1, 3); 
    grid.add(mAtkBar, 0, 4)   ;grid.add(mAtkText, 0, 4); grid.add(magicAtkValue, 1, 4);
    grid.add(mDefBar, 0, 5)   ;grid.add(mDefText, 0, 5); grid.add(magicDefValue, 1, 5);
    grid.add(expBar, 0, 6)   ;grid.add(expText, 0, 6); grid.add(expValue, 1, 6);
                              grid.add(lvlText, 0, 7); grid.add(lvlValue, 1, 7);

    return grid;
  }
  
  public GridPane MenuButtons ()
  {
    GridPane grid = new GridPane();
    grid.setAlignment (Pos.TOP_CENTER);
    grid.setHgap (10);
    
    grid.add (button[10], 0, 0);
    grid.add (button[11], 14, 0);
    grid.add (button[12], 15, 0);
    grid.add (button[13], 16 ,0);
    
    return grid;
  }
  
  public GridPane ActionButtons()
  {
    GridPane grid = new GridPane ();
    grid.setAlignment (Pos.BOTTOM_CENTER);
    
    grid.setHgap (10);
    grid.setVgap (10);
    
    int x = 0;
    int y = 0;

    for(y=0; y<2; y++)
    {
      for (x=0; x<5; x++)
      {
        int buttonNumber = x+5*y;
        
        button[buttonNumber].setText (""+ buttonNumber);
        
        grid.add (button[buttonNumber], x, y);
      }
    }
    
    return grid;
  }
  
  public void StatStringUpdate()
  {
    int width = 60;
    
    maxHealth = game.player.getMaxHealth ();
    health = game.player.getHealth ();
    
    maxStrength = game.player.getMaxStrength ();
    strength = game.player.getStrength ();
    
    maxDefense = game.player.getMaxDefense ();
    defense = game.player.getDefense ();
    
    maxSpeed = game.player.getMaxSpeed ();
    speed = game.player.getSpeed ();
    
    maxMagicAtk = game.player.getMaxMagicAtk ();
    magicAtk = game.player.getMagicAtk ();
    
    maxMagicDef = game.player.getMaxMagicDef ();
    magicDef = game.player.getMagicDef ();
    
    maxExp = game.player.getMaxExp ();
    exp = game.player.getExp ();
    
    level = game.player.getLevel ();
    
    
    hpBar.setWidth (width * (health/maxHealth));
    if (health > maxHealth) {hpBar.setWidth (width);}
    
    strBar.setWidth (width * (strength/maxStrength));
    if (strength > maxStrength) {strBar.setWidth (width);}
    
    defBar.setWidth (width * (defense/maxDefense));
    if (defense > maxDefense) {defBar.setWidth (width);}
    
    spdBar.setWidth (width * (speed/maxSpeed));
    if (speed > maxSpeed) {spdBar.setWidth (width);}
    
    mAtkBar.setWidth (width * (magicAtk/maxMagicAtk));
    if (magicAtk > maxMagicAtk) {mAtkBar.setWidth (width);}
    
    mDefBar.setWidth (width * (magicDef/maxMagicDef));
    if (magicDef > maxMagicDef) {mDefBar.setWidth (width);}
    
    System.out.println (exp + " / " + maxExp);
    expBar.setWidth (width * (double)(((double)exp)/((double) maxExp)));
    if (exp > maxExp) {expBar.setWidth (width);}
    
    healthValue.setText ("" + (int)health);
    strengthValue.setText ("" + (int)strength);
    defenseValue.setText ("" + (int)defense);
    speedValue.setText ("" + (int)speed);
    magicAtkValue.setText ("" + (int)magicAtk);
    magicDefValue.setText ("" + (int)magicDef);
    expValue.setText ("" + (int)exp);
    lvlValue.setText ("" + (int)level);
  }
  
  public void buttonActionSetup()
  {
    button[0].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (0);
      }
    });
    button[1].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (1);
      }
    });
    button[2].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (2);
      }
    });
    button[3].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (3);
      }
    });
    button[4].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (4);
      }
    });
    button[5].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (5);
      }
    });
    button[6].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (6);
      }
    });
    button[7].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (7);
      }
    });
    button[8].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (8);
      }
    });
    button[9].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (9);
      }
    });
    button[10].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (10);
      }
    });
    button[11].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (11);
      }
    });
    button[12].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (12);
      }
    });
    button[13].setOnAction (new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        gameUpdate (13);
      }
    });
  }
  
  public void gameUpdate(int i)
  {
    //System.out.println (i);
    game.update (i);
    updateButtons ();
    sceneText.setText (game.UpdateText ());
    StatStringUpdate ();
  }
  
  public void updateButtons()
  {
    for(int i = 0; i<button.length; i++)
    {
      if (game.activeButtons[i])
      {
        button[i].setDisable (false);
        button[i].setText (game.buttonTexts[i]);
      }
      else
      {
        button[i].setText ("");
        button[i].setDisable (true);
      }
    }
  }
}