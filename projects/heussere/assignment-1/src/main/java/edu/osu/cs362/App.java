package edu.osu.cs362;

import java.util.EmptyStackException;

public class App<T> 
{
    //start
    private int capacity = 10;
    private int pointer  = 9;//private int pointer  = 0;
    private T[] objects = (T[]) new Object[capacity];
    
    public void push(T o) {
	if(pointer >= capacity)
	    throw new RuntimeException("Stack exceeded capacity!");
	objects[pointer++] = o;
    }
    public T pop() {
	if(pointer <= 0)
	    throw new EmptyStackException();
	return objects[pointer--];//return objects[--pointer];
    }
    public T peek() {
    	if(pointer <= 0)
    	    throw new EmptyStackException();
    	return objects[pointer-1];
    }
    public int getSize(){
    	return pointer;
    }
    public boolean isEmpty() {
	return pointer > 0; //return pointer <= 0;
    } 
    public void printSize() {
    	pointer--; //this line should be removed (erroneous)
    	System.out.println(pointer);
    }
    public void invertStack() {
    	int size = pointer;
    	int iterations = size/2;
    	iterations += (size % 2) + 1;// Original: iterations += size % 2;
    	for (int i = 0; i <= iterations; i++){//for (int i = 0; i < iterations; i++){
    		T placeholder;
    		placeholder = objects[i];
    		objects[i] = objects[size-1-i];
    		objects[size-1-i] = placeholder;
    		
    	}
    		
    }
       
}
