package com.flyers.tms.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {

  public static void toCount(){
    List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,598,88));
    //Get list count
    var c = list.stream().count();
    System.out.println(c);
  }

  public static void toFilter(){
    List<String> list = new ArrayList<>(Arrays.asList("ram","","hai","","rajaram","sri"));
    //Get list count
    var count  = list.stream().filter(c -> c.isEmpty()).count();
    //Remove all empty Strings from List
    var li = list.stream().filter(c -> !c.isEmpty()).collect(Collectors.toList());
    //Get a string more than 4 character
    var nameList = list.stream().filter(c -> c.length() > 3).collect(Collectors.toList());
    System.out.println(count);
    System.out.println(li);
    System.out.println(nameList);
  }

  public static void toMapStream(){
    List<String> list = new ArrayList<>(Arrays.asList("java","","dotnet","python","","node"));
    //To convert uppercase using map function in stream
    var result =list.stream().filter(c -> !c.isEmpty()).map(x -> x.toUpperCase()).collect(Collectors.joining("---"));
    System.out.println(result);
    List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
    List<Integer> distinct = numbers.stream() .map( i -> i*i) .distinct() .collect(Collectors.toList());
    System.out.println(distinct);
    Integer n  = 1 ;
  }

  public static void fun(Integer a,Integer b){
    System.out.println(a+b);
  }

  public static void main(String[] args) {
    StreamApi.toCount();
    StreamApi.toFilter();
    StreamApi.toMapStream();
    int a = 1;
    int b = 2;
    StreamApi.fun(a, b);
  }

}
