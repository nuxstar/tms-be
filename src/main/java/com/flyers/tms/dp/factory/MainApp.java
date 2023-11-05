package com.flyers.tms.dp.factory;

public class MainApp {

  public static void main(String[] args) {

   var carObject =  FactoryDesignPattern.getInstanceOfVehicle("car", 4, "blue");

    var bikeObject =  FactoryDesignPattern.getInstanceOfVehicle("bike", 2, "red");

  //  var Object =  FactoryDesignPattern.getInstanceOfVehicle("bik", 2, "red");

    System.out.println(carObject.getClass().getName());
    System.out.println(bikeObject.getClass().getName());
  }

}
