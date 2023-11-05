package com.flyers.tms.dp.BSP;

public class Burger {

  private int item;

  private boolean cheese;

  private String mayoonise;

  public Burger(BurgerBuilder builder) {
  }

  public Burger(Burger build) {
  }

  public Burger Burger(BurgerBuilder builder){
    return builder.mayoonise("yes").cheese(true).build();
  }

  public int getItem() {
    return item;
  }

  public void setItem(int item) {
    this.item = item;
  }

  public boolean isCheese() {
    return cheese;
  }

  public void setCheese(boolean cheese) {
    this.cheese = cheese;
  }

  public String getMayoonise() {
    return mayoonise;
  }

  public void setMayoonise(String mayoonise) {
    this.mayoonise = mayoonise;
  }

  public static class BurgerBuilder{

    private int item;

    private boolean cheese;

    private String mayoonise;

    public int getItem() {
      return item;
    }

    public void setItem(int item) {
      this.item = item;
    }

    public boolean isCheese() {
      return cheese;
    }

    public void setCheese(boolean cheese) {
      this.cheese = cheese;
    }

    public String getMayoonise() {
      return mayoonise;
    }

    public void setMayoonise(String mayoonise) {
      this.mayoonise = mayoonise;
    }

    public BurgerBuilder() {
    }

    public BurgerBuilder item(int item){
      this.item = item;
      return this;
    }

    public BurgerBuilder cheese(boolean cheese){
      this.cheese = cheese;
      return this;
    }

    public BurgerBuilder mayoonise(String mayoonise){
      this.mayoonise = mayoonise;
      return this;
    }

    public Burger build(){
      return new Burger(this);
    }
  }
}
