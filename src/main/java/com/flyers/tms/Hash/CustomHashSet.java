package com.flyers.tms.Hash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomHashSet<T> implements Iterable<T>{

  private int initialCapacity;
  private int size;
  private List<T> elements;

  public CustomHashSet(){
    this.initialCapacity = 10;
    this.size = 0;
    this.elements = new ArrayList<>(initialCapacity);
  }

  public String add(T element){
    if (contains(element)){
      throw new RuntimeException("Element already exist {}" +element+ "");
    }
    elements.add(element);
    size++;
    return "value added successfully";
  }

  public int getIndex(T element){
    int i = element.hashCode();
    return i % initialCapacity;
  }

  public T getElement(T index){
    int i = getIndex(index);

    if (i > elements.size() || i < 0){
      throw new RuntimeException("Search Index Not Found ");
    }
    return  elements.get(i);
  }

  public boolean contains(T element){
   return elements.contains(element);
  }

  @Override
  public Iterator<T> iterator() {
    return new CustomIterator<T>();
  }


  public class CustomIterator<T> implements Iterator<T> {

    private int currentIndex;

    public CustomIterator() {
      this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
      return currentIndex < elements.size();
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return (T) elements.get(currentIndex++);
    }
  }

  public static void main(String[] args) {
    CustomHashSet<Integer> list = new CustomHashSet<>();
    list.add(88);
    list.add(33);
    list.add(2);
    list.add(55);
    list.add(43);
//  System.out.println(list.getElement(2));
    var iterator = list.iterator();
    while (iterator.hasNext()){
      System.out.println(" value: "+iterator.next());
    }
  }
}
