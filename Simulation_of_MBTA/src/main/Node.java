/**
 * This class will implement a doubly linked list node
 * Known Bugs: None
 *
 * @author Linfeng Zhu
 * linfengzhu@brandeis.edu
 * Oct 5, 2022
 * COSI 21A PA1
 */

package main;

public class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> prev;
	
	/**
	 * Constructs a doubly linked list node that holds a data field but does not point to any other nodes
	 * @param element
	 */
	public Node(T element) {
		this.data=element;
		this.next=null;
		this.prev=null;
	}
	
	/**
	 * Sets the data field of this Node
	 * @param element
	 */
	public void setData(T data) {
		this.data=data;
	}
	
	/**
	 * Sets the next pointer of this Node
	 * @param next
	 */
	public void setNext(Node<T> next) {
		this.next=next;
	}
	
	/**
	 * Sets the previous pointer of this Node
	 * @param prev
	 */
	public void setPrev(Node<T> prev) {
		this.prev=prev;
	}
	
	/**
	 * Returns the Pointer to the next Node or null if one does not exist
	 * @return
	 */
	public Node<T> getNext() {
		return this.next;
	}
	
	/**
	 * Returns the Pointer to the previous node or null if one does not exist
	 * @return
	 */
	public Node<T> getPrev() {
		return this.prev;
	}
	
	/**
	 * Returns the String representation of this node's element
	 */
	@Override
	public String toString() {
		return ""+data;
	}
}
