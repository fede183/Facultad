package org.autotest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackAr {

	private final static int DEFAULT_CAPACITY = 10;

	private final List<Object[]> elems;

	private Object topElement;

	private int readIndex = -1;

	public StackAr() {
		this(DEFAULT_CAPACITY);
	}

	public StackAr(int capacity) throws IllegalArgumentException {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		this.elems = new ArrayList<>();
		this.elems.add(new Object[capacity]);

	}

	public int size() {
		return readIndex+1;
	}

	private int capacity(){
		int amountOfExpansion = 0;
		for (Object[] expansion: elems
			 ) {
			amountOfExpansion += expansion.length;
		}
		return amountOfExpansion;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == capacity();
	}

	private void assingToLastElement(Object o){ //O(k)
		int readIndexMatriz = this.readIndex;
		for (Object[] element: elems
		) {
			if(readIndexMatriz < element.length){
				element[readIndexMatriz] =  o;
			}
			readIndexMatriz -= element.length;
		}
	}

	public void push(Object o) throws IllegalStateException {//O(k)
		if (isFull()) {
			throw new IllegalStateException();
		}
		this.readIndex++;
		assingToLastElement(o);
		topElement = get(readIndex);
	}

	public Object pop() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		Object rv = this.top();
		assingToLastElement(null);
		readIndex--;
		if(!isEmpty()) {
			topElement = get(readIndex);
		}
		return rv;
	}

	public Object top() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException();
		}

		return topElement;
	}

	public Object get(int index) throws IllegalArgumentException {
		if (index<0) 
			throw new IllegalArgumentException();

		if (index> readIndex)
			throw new IllegalArgumentException();

		Object rv = new Object();
		int readIndexMatriz = index;
		for (Object[] element: elems //O(k)
		) {
			if(readIndexMatriz < element.length){
				rv = element[readIndexMatriz];
			}
			readIndexMatriz -= element.length;
		}

		return rv;
	}

	public void increaseCapacity(int addingCapacity){
		Object[] newElements = new Object[addingCapacity];
		elems.add(newElements); //Dado que es una lista, en el peor de los casos se debera recorrer en su totalidad para
		//alcanzar el nodo final, O(k)
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("[");
		int i = 0;
		Object[] toStringElems = getSimpleArray();
		while (i<=readIndex) {
			if (i > 0) {
				b.append(",");
			}
			Object o = toStringElems[i];
			String s = String.valueOf(o);
			b.append(s);
			i++;
		}
		b.append("]");
		return b.toString();
	}

	private Object[] getSimpleArray(){
		int i = 0;
		Object[] getSimpleArray = new Object[capacity()];
		for (Object[] elements: elems
			 ) {
			for (Object elem: elements
				 ) {
				getSimpleArray[i] = elem;
				i++;
			}
		}
		return getSimpleArray;
	}
}
