package com.flyers.tms.dp.factory;

public class Bike extends FactoryPattern{

  private int wheel;

  private String colour;

  public Bike(int wheel, String colour){
    this.wheel = wheel;
    this.colour = colour;
  }

  @Override
  public void vehicle() {
    System.out.println("Bike Type");
  }
}
