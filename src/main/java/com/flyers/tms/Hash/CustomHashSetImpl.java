package com.flyers.tms.Hash;

import java.util.*;

public class CustomHashSetImpl<T> implements Iterable<T>{

  private HashMap<T, T> map = null;

  public CustomHashSetImpl() {
    map = new HashMap<>();
  }

  @Override
  public Iterator<T> iterator() {
    return new CustomIterator<T>();
  }

  public T add(T element) {
    return map.put(element, element);
  }

  public class CustomIterator<G> implements Iterator<G> {

    private List<G> elementList = (List<G>) new ArrayList<>(map.keySet());

    private int current = 0;
    private final int size = elementList.size();

    @Override
    public boolean hasNext() {
      return current < size;
    }

    @Override
    public G next() {
      if(!hasNext()) {
        throw new NoSuchElementException();
      }
      G el = (G) elementList.get(current);
      current++;
      return el;
    }
  }


  public static void main(String[] args) {


    CustomHashSet<Integer> customHashSet = new CustomHashSet<>();
    customHashSet.add(1);
    customHashSet.add(1);
    customHashSet.add(1);
    customHashSet.add(2);
    customHashSet.add(3);
    customHashSet.add(4);
    customHashSet.add(5);

    Iterator<Integer> iterator = customHashSet.iterator();
    for (Integer i : customHashSet) {
      System.out.println(i);
    }

  }
}
