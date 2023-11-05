package com.flyers.tms.dp.single;

import com.flyers.tms.dp.single.Singleton;

public class MainApp {

  public static void main(String[] args) {

    System.out.println(Singleton.getInstance().hashCode());
    System.out.println(Singleton.getInstance().hashCode());
    System.out.println(Singleton.getInstance().hashCode());


  }
}

