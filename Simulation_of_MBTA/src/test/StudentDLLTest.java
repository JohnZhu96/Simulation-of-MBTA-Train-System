/**
 * This class will test the DoubleLinkedList class
 * Known Bugs: None
 *
 * @author Linfeng Zhu
 * linfengzhu@brandeis.edu
 * Oct 5, 2022
 * COSI 21A PA1
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.DoubleLinkedList;

class StudentDLLTest {

	DoubleLinkedList list= new DoubleLinkedList();

	@Test
	void test1() {
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		assertEquals(list.toString(),"1,2,3,4");
		assertEquals(list.get(1),1);
		assertEquals(list.get(5),null);
		assertEquals(list.getFirst().toString(),"1" );
		assertEquals(list.size(),4);
	}
	
	@Test
	void test2() {
		list.insert(1);
		list.insert(2);
		list.insert(3);
		assertEquals(list.toString(),"1,2,3");
		assertEquals(list.delete(2),2);
		assertEquals(list.delete(3),3);
		assertEquals(list.delete(4),null);
		list.insert(4);
		assertEquals(list.toString(),"1,4");
	}

}
