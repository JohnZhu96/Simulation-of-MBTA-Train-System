/**
 * This class will test the Queue class
 * Known Bugs: None
 *
 * @author Linfeng Zhu
 * linfengzhu@brandeis.edu
 * Oct 5, 2022
 * COSI 21A PA1
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import main.Queue;
import org.junit.jupiter.api.Test;

class StudentQueueTest {

	Queue q = new Queue(5);
	@Test
	void test() {
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		assertEquals(q.size(),3);
		assertEquals(q.front(),1);
		assertEquals(q.toString(),"1,2,3");
		
		q.dequeue();
		assertEquals(q.front(),2);
		assertEquals(q.toString(),"2,3");
	}

}
