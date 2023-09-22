/**
 * This class will implement a generic non-circular doubly linked list
 * Known Bugs: None
 *
 * @author Linfeng Zhu
 * linfengzhu@brandeis.edu
 * Oct 5, 2022
 * COSI 21A PA1
 */

package main;

public class DoubleLinkedList<T> {
	
	public Node<T> head;
	public Node<T> tail;
	public int size;
	
	/**
	 * Initializes a doubly linked list to have 0 elements
	 */
	public DoubleLinkedList() {
		size=0;
		head=new Node<T>(null);
		tail=new Node<T>(null);
		head.next=tail;
		tail.prev=head;
	}
	
	/**
	 * Gets the first Node in the list or null if one does not exist
	 * @return
	 */
	public Node<T> getFirst() {
		return this.head;
	}
	
	/**
	 * Adds an element to the end of this list
	 * @param element
	 */
	public void insert(T element) {
		Node<T> newNode=new Node<T>(element);
		if(head.data==null) {
			head.data=element;
		}else {
			newNode.prev=tail.prev;
			newNode.next=tail;
			tail.prev.next=newNode;
			tail.prev=newNode;
		}
		size++;
	}
	
	/**
	 * Deletes the first element from this list that mathes the provided key
	 * @param key
	 * @return
	 */
	public T delete(T key) {
		Node<T>curr= this.head;
		while(curr.next!=null) {
			if(curr.data.equals(key)) {
				curr.prev.next=curr.next;
				curr.next.prev=curr.prev;
				size--;
				return curr.data;
			}
			curr=curr.next;
		}
		
		if(curr.data==key) {
			tail.prev=curr.prev;
			curr.prev.next=tail;
			size--;
			return curr.data;
		}
		return null;
	}
	
	/**
	 * Returns the first element in the list that matches the provided key
	 * @param key Given key
	 * @return
	 */
	public T get(T key) {
		Node<T>curr= this.head;
		while(curr!=null) {
			if(curr.data==key) {
				return curr.data;
			}
			curr=curr.next;
		}
		return null;
	}
	
	/**
	 * Returns the number of elements in the list 
	 * @return
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Returns a String representation of this list's elements
	 */
	@Override
	public String toString() {
		Node<T>curr=head;
		String result="";
		while(curr.next!=null) {
			result+=curr.toString()+",";
			curr=curr.next;
		}
		result=result.substring(0,result.length()-1);
		return result;
	}
}