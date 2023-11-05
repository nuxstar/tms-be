package com.flyers.tms.dp.single;

import java.io.Serializable;

//Single ton design pattern is a creation design pattern in java it allows that the class instantiation only one class object.
// it means how many times you create an object for a class you will get a single instance
public class Singleton implements Cloneable, Serializable {

  public static Singleton instance = null;


  //java reflection allows you to convert private constructor too public to create a new object for class
  //to avoid this you should provide code below
  private Singleton(){
    if (instance != null)
      throw new RuntimeException("Singleton Object Already Created");
  }

  //Make geInstance method as synchronized because only one thread should access at a time
  public synchronized static Singleton getInstance()
  {
    if (instance != null){
      return instance;
    }
    return instance = new Singleton();
  }

  //Using clone method you can create new object with copy of existing memory object
  @Override
  protected Object clone() throws CloneNotSupportedException {
    throw new RuntimeException("Clone Not Supported For Singleton Class");
  }

  //during deserialization java may create new object so that time you should return the same instance of singleton class
  protected  Object readResolve(){
    return instance;
  }

}
