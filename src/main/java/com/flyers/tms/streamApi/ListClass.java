package com.flyers.tms.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListClass {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>(Arrays.asList(1,7,5,3,4,8,9,2,3,4,5));

    //sort natural order
    var sortList = list.stream().sorted().collect(Collectors.toList());
    System.out.println(sortList);

    //Reversed order
    var reList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    System.out.println(reList);

    //Print using method reference
    list.stream().filter( x -> x %2 == 0).forEach(System.out::println);

    //use of parseInt
    String  s = "189";
    System.out.println(Integer.parseInt(s));

    List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");

    //map is used when we want to convert one set values to different
     listOfStrings.stream().map(Integer::parseInt).forEach(x -> System.out.println(x));

     //To get distinct values
     listOfStrings.stream().map( x -> x).distinct().forEach(c -> System.out.println("Value :"+ c));


  }
}
