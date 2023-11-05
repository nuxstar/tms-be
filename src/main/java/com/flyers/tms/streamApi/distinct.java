package com.flyers.tms.streamApi;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class distinct {

  public static void main(String[] args) {

    //Find Distinct in Stream of Strings or Primitives
    Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
    System.out.println(list.stream().distinct().collect(Collectors.toList()));

//    //Find Distinct Objects By Field
//    Person lokeshOne = new Person(1, "Lokesh", "Gupta");
//    Person lokeshTwo = new Person(2, "Lokesh", "Gupta");
//    Person lokeshThree = new Person(3, "Lokesh", "Gupta");
//    Person brianOne = new Person(4, "Brian", "Clooney");
//    Person brianTwo = new Person(5, "Brian", "Clooney");
//    Person alex = new Person(6, "Alex", "Kolen");
//
//    Collection<Person> list = Arrays.asList(alex,
//        brianOne,
//        brianTwo,
//        lokeshOne,
//        lokeshTwo,
//        lokeshThree);
//
//// Get distinct objects by key
//    List<Person> distinctElements = list.stream()
//        .filter( distinctByKey(p -> p.getFname() + " " + p.getLname()) )
//        .collect( Collectors.toList() );
//
//    System.out.println( distinctElements );
  }
}
