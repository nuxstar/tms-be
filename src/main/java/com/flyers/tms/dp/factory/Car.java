package com.flyers.tms.dp.factory;

public class Car extends FactoryPattern{

  private int wheel;

  private String colour;

  public Car(int wheel, String colour){
    this.wheel = wheel;
    this.colour = colour;
  }

  @Override
  public void vehicle() {
    System.out.println("Car Type");
  }
}
