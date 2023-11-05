package com.flyers.tms.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Excersise {

  public static void main(String[] args) {

    // Write a Java program to calculate the average of a list of integers using streams.
    List<Integer> list = new ArrayList<>(Arrays.asList(0,5,3,7,8,8));
    var m = list.stream().reduce(1,(a,b) -> a+b);
    System.out.println(m);

    var ans = list.stream().filter(x -> x%2 == 0);
    ans.forEach(System.out::println);
    System.out.println("--------------------------------");
    System.out.println(ans.sorted().collect(Collectors.toList()));

    list.add(0,1);
    System.out.println(list);
    System.out.println(list.stream().map(x -> (x +x) ).collect(Collectors.toList()));

    //Write a Java program to convert a list of strings to uppercase or lowercase using streams
    List<String> stringList = new ArrayList<>(Arrays.asList("map","flatmap","peek","findAny","findAll","findNone"));
    System.out.println("To UpperCase :"+stringList.stream().map(String::toUpperCase).collect(Collectors.toList()));
    System.out.println("To lower case :"+stringList.stream().map(String::toLowerCase).collect(Collectors.toList()));

    //Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
    System.out.println(list.stream().filter( x -> x % 2 != 0).collect(Collectors.toList()));
    System.out.println(list.stream().filter( x -> x % 2 == 0).collect(Collectors.toList()));

    //Write a Java program to remove all duplicate elements from a list using streams.
    System.out.println( list.stream().distinct().collect(Collectors.toList()));

    //Write a Java program to count the number of strings in a list that start with a specific letter using streams.
    System.out.println(stringList.stream().filter( x -> x.startsWith("f")).collect(Collectors.toList()));

    //Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
    System.out.println("Accending :"+stringList.stream().sorted().collect(Collectors.toList()));
    System.out.println("Desscemding :"+stringList.stream().sorted( (o1,o2) -> o2.compareTo(o1) ).collect(Collectors.toList()));

    //Write a Java program to find the maximum and minimum values in a list of integers using streams.
    list.stream().min((o1,o2) -> o1.compareTo(o2)).stream().forEach( x -> System.out.println(x));
    list.stream().max( (o1,o2) -> o2.compareTo(o1)).stream().forEach( y -> System.out.println(y));

    System.out.println(list.stream().min(Integer::compareTo).stream().collect(Collectors.toList()));
    System.out.println(list.stream().max(Integer::compareTo).stream().collect(Collectors.toList()));


    // Write a Java program to find the second smallest and largest elements in a list of integers using streams

  }
}