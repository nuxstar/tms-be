package com.flyers.tms.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMap {

  public static void main(String[] args) {

    //Flatmap() method is used to flattrn stream of collection to stream of object
    //it will create new object after streaming
    //we can do merging multiple collections/arrays into one

    List<Integer> list1 = Arrays.asList(1,4,3);
    List<Integer> list2 = Arrays.asList(2,5,34);
    List<Integer> list3 = Arrays.asList(7,8,10);

    //Converting Nested Lists into a Single List
    var all =Arrays.asList(list1,list2,list3);

    var x =all.stream().flatMap(y -> y.stream()).collect(Collectors.toList());
    System.out.println(x);
    var k = all.stream().flatMap(c -> c.stream().sorted()).collect(Collectors.toList());
    var o =all.stream().flatMap(c -> c.stream().map(String::valueOf)).collect(Collectors.toList());
    System.out.println(o);

    //Collecting Nested Arrays into a Sinle List
    String[][] dataArray = new String[][]{{"a", "b"},
        {"c", "d"}, {"e", "f"}, {"g", "h"}};

    var b = Arrays.stream(dataArray).flatMap( r -> Arrays.stream(r)).collect(Collectors.toList());
    System.out.println(b);


    ///Stream interface has three more similar methods which produce IntStream
    // , LongStream and DoubleStream respectively after the flatMap() operation.
    // If the streams created after flatMap() operation


    String name = "hello";

    List<String> employee = new ArrayList<>(Arrays.asList("employee1","raam","suryA"));

    employee.stream().flatMapToInt( t -> IntStream.of( t.length())).forEach(s -> System.out.println(s));

  }

}
