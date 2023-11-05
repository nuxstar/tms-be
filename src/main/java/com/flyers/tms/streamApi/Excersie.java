package com.flyers.tms.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Excersie {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>(Arrays.asList("reduce","map","flatmap","peek"));

    Optional<String> concat = list.parallelStream().reduce((str1, str2 ) -> str1+str2);

    System.out.println(concat.get());

    //System.out.println(list.parallelStream().collect(Collectors.joining("")));
  }
}
