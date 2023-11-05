package com.flyers.tms.streamApi;

import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(2, 2, 1, 3, 7, 5, 2, 6, 8);

    System.out.println(list.stream().noneMatch( v -> v.equals(1)));

    //To sort natural order
    System.out.println(list.stream().sorted().collect(Collectors.toList()));
    //TO sort reverse order
    System.out.println(list.stream().sorted(Comparator.reverseOrder()));

    Comparator<Integer> reverseComparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        return i2.compareTo(i1);
      }
    };

    List<Integer> sortedList = list.stream()
        .sorted(reverseComparator)
        .collect(Collectors.toList());

    System.out.println(sortedList);


    // Sorting using Lambda Expressions
    System.out.println("Sorting using Lambda Expressions: "+list.stream().sorted((o1,o2) -> o2.compareTo(o1) ).collect(Collectors.toList()));


    @NotNull String valid  = null;


  }
}
