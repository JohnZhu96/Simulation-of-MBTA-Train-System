/**
 * This class will implement generic circular first-in-first-out queue 
 * Known Bugs: None
 *
 * @author Linfeng Zhu
 * linfengzhu@brandeis.edu
 * Oct 5, 2022
 * COSI 21A PA1
 */

package main;

import java.util.NoSuchElementException;

public class Queue<T> {
	
	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	
	/**
	 * Constructs an empty queue that can hold a specified number of elements
	 * @param capacity Size of the queue
	 */
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
		head=0;
		tail=0;
		numEntries=0;
	}
	
	/**
	 * Adds an element at the tail of the queue
	 * @param element
	 */
	public void enqueue(T element) {
		q[tail]=element;
		if(tail==q.length-1) {
			if(head==0) {
				throw new NoSuchElementException("The queue is full");
			}else {
				tail=0;
			}
		}else {
			tail++;
		}
		numEntries++;
	}
	
	/**
	 * Removes the element at the head of the queue
	 */
	public void dequeue() {
		if(q==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		
		if(head==q.length-1) {
			head=0;
		}else {
			head++;
		}
		numEntries--;
		
	}
	
	/**
	 * Returns the element at the head of the queue
	 * @return
	 */
	public T front() {
		return q[head];
	}
	
	/**
	 * Returns the number of elements in the queue
	 * @return
	 */
	public int size() {
		return numEntries;
	}
	
	/**
	 * Return a String representation of the queue's elements
	 */
	@Override
	public String toString() {
		String s="";
		int count=head;
		for(int i=0;i<numEntries-1;i++) {
			if(count==q.length-1) {
				count=0;
			}
			s+=q[count]+",";
			count++;
		}
		s+=q[count];
		return s;
	}
}