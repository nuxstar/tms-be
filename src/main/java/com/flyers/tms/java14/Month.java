package com.flyers.tms.java14;

public class Month {
  static int  days = 0;

  public static void findDays(String month){

    switch (month){
      case "jan":
        days = 31;
        break;
      case "feb":
        days = 28;
        break;
    }

  }

  //Using switch case latest expression

  public static void findDay(String month){
    days = switch (month){

      case "jan" -> 31;
      case  "feb"  -> 28;
      case "mar" -> {
        System.out.println(month);
        yield 31;
      }
      default -> throw new IllegalStateException();
    };
  }
  public static void main(String[] args) {
      Month.findDays("feb");
    System.out.println(days);
    Month.findDay("mar");
    System.out.println(days);
  }
}
