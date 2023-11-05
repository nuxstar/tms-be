package com.flyers.tms.dp.BSP;

public class MainPizza {

  public static void main(String[] args) {

    Pizza pizza = new Pizza.PizzaBuilder().PizzaBuilder(1).addPepperoni().mayoonise().cheese().build();

    System.out.println(pizza.getSize());
    System.out.println(pizza.isAddPepperoni());
    System.out.println(pizza.isCheese());
    System.out.println(pizza.isMayoonise());
    System.out.println("-------------------------------------------------------------------");
//    Pizza piza = new Pizza.PizzaBuilder().PizzaBuilder(5).addPepperoni().cheese().build();
//    System.out.println(piza.getSize());
//    System.out.println(piza.isAddPepperoni());
//    System.out.println(piza.isCheese());
//    System.out.println(piza.isMayoonise());
  }
}
