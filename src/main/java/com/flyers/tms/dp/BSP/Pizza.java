package com.flyers.tms.dp.BSP;

public class Pizza {

  private int size;

  private boolean cheese;

  private boolean mayoonise;

  private boolean addPepperoni;

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public boolean isCheese() {
    return cheese;
  }

  public void setCheese(boolean cheese) {
    this.cheese = cheese;
  }

  public boolean isMayoonise() {
    return mayoonise;
  }

  public void setMayoonise(boolean mayoonise) {
    this.mayoonise = mayoonise;
  }

  public boolean isAddPepperoni() {
    return addPepperoni;
  }

  public void setAddPepperoni(boolean addPepperoni) {
    this.addPepperoni = addPepperoni;
  }


  @Override
  public String toString() {
    return "Pizza{" +
        "size=" + size +
        ", cheese=" + cheese +
        ", mayoonise=" + mayoonise +
        ", addPepperoni=" + addPepperoni +
        '}';
  }


  public Pizza(PizzaBuilder builder){
    this.size = builder.size;
    this.cheese = builder.cheese;
    this.addPepperoni = builder.addPepperoni;
    this.mayoonise = builder.mayoonise;
  }

  public static class PizzaBuilder{

    private int size;

    private boolean cheese;

    private boolean mayoonise;

    private boolean addPepperoni;

    public PizzaBuilder PizzaBuilder(int size){
      this.size = size;
      return this;
    }

    public PizzaBuilder cheese(){
      this.cheese = true;
      return this;
    }

    public PizzaBuilder mayoonise(){
      this.mayoonise = true;
      return this;
    }

    public PizzaBuilder addPepperoni(){
      this.addPepperoni = true;
      return this;
    }

    public Pizza build(){
      return new Pizza(this);
    }
  }
}
