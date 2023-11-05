package com.flyers.tms.java16;

public class PatterMatching {

  public static void main(String[] args) {

    //upcasting
    Vehicle v1 = new Bus();
    v1.vehicleFunction();

    Vehicle v2 = new Car();
    v2.vehicleFunction();


    //down casting
    Car c = (Car) v2;
    System.out.println(c.s);
    c.vehicleFunction();

    System.out.println("--------------------------");

    PatterMatching.run(c);

  }

  public static void run(Car v){

    if (v instanceof Vehicle){
      System.out.println("Yes");
    }else
      System.out.println("No");
  }
}
