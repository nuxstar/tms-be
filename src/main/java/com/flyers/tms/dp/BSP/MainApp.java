package com.flyers.tms.dp.BSP;

public class MainApp {

  public static void main(String[] args) {

    Burger burger = new Burger(new Burger.BurgerBuilder().cheese(true).item(5).build());

    System.out.println(burger.getItem());
    System.out.println(burger.getMayoonise());
  }
}
