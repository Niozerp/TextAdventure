/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.textadventure.rooms;

public class Location
{
  public String location;

  public Location ()
  {
    location = "SafeHouse";
  }
  
  public void goTo(String loc)
  {
    location = loc;
  }
  
}
