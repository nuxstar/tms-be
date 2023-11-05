package com.flyers.tms.singleton;

import java.io.Serializable;

//This is single ton class
public class Singleton implements Cloneable , Serializable {

  //declare instance as variable
  private static Singleton instance = null;

  //To prevent reflection utils make constructor inside thrown an exception
  public Singleton(){
    if (instance != null){
      throw new RuntimeException("Single-ton Instance Is Already Created");
    }
  }

  //Actual instance of single ton class
  public synchronized static Singleton getInstance(){
    if (instance == null){
      return instance = new Singleton();
    }
    return instance;
  }

  //To avoid clone you need to implement cloneable interface
  @Override
  protected Object clone() throws CloneNotSupportedException {
    throw new RuntimeException("Clone Not Supported For Single-ton class");
  }

  //To avoid serialize and deserialize using readResolve method
  public  Object readResolve(){
    return instance;
  }
}
