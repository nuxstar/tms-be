package com.flyers.tms.dp.factory;

public class FactoryDesignPattern {

  public static Object getInstanceOfVehicle(String type, int wheel, String colour)
  {
      if (type.equalsIgnoreCase("car")){
        return new Car(wheel,colour);
      } else if (type.equalsIgnoreCase("bike")) {
        return new Bike(wheel,colour);
      }
      throw new IllegalArgumentException("No Such Type Present");
  }
}
