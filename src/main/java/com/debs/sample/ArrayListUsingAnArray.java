package com.debs.sample;

import java.util.Arrays;

public class ArrayListUsingAnArray<E> {
	private int size = 0;
	private static final int default_capacity = 10;
	private Object elements[];
	
	public ArrayListUsingAnArray(){
		elements = new Object[default_capacity];
	}
	
	public void add(E e){
		if(size==elements.length)
			increaseCapacity();
		elements[size++]=e;
	}

	private void increaseCapacity() {
		int newSize=2*elements.length;
		elements=Arrays.copyOf(elements, newSize);
	}
	
	public E get(int i){
		if(i >= elements.length || i<0)
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
		return (E) elements[i];
	}
	
	

}
