package structures;

import static org.junit.Assert.*;

import org.junit.Test;


public class UnboundedQueueInterfaceTest {
	@Test
	public void testCopyConstructorEmpty() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		r = new Queue<Integer>(q);
		assertTrue(r.isEmpty());
		assertTrue(q.isEmpty());	
	}
	
	@Test
	public void testEnqueue(){
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		assertEquals((Integer)1, q.dequeue());
		q.enqueue(2);
		assertEquals((Integer)2,q.dequeue());
	}
	
	@Test (expected = Exception.class)
	public void testNoSuchElementException(){
		Queue<Integer> q = new Queue<Integer>();
		q.dequeue();
	}
	
	@Test
	public void testDeque(){
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		assertEquals((Integer)1,q.dequeue());
	}
	
	@Test
	public void testIsEmpty(){
		Queue<Integer> q = new Queue<Integer>();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testSize(){
		Queue<Integer> q = new Queue<Integer>();
		assertEquals(0,q.size());
		q.enqueue(1);
		q.enqueue(2);
		assertEquals(2,q.size());
	}
	
	@Test
	public void testReversed(){
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.reversed();
		//System.out.println(q.dequeue());
		//System.out.println(q.dequeue());
		Queue<Integer> r = new Queue<Integer>();
		r.enqueue(2);
		r.enqueue(1);
		assertEquals(r.dequeue(),q.dequeue());
		
	}

	@Test
	public void testCopyConstructorEmptyNotAliased() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		r = new Queue<Integer>(q);
		assertTrue(r.isEmpty());
		assertTrue(q.isEmpty());		

		q.enqueue(1);
		q.enqueue(2);
		assertEquals(2, q.size());
		assertTrue(r.isEmpty());
				
		r.enqueue(3);
		r.enqueue(4);
		r.enqueue(5);
		assertEquals(2, q.size());
		assertEquals(3, r.size());
		
		r.dequeue();
		r.dequeue();
		r.dequeue();
		assertTrue(r.isEmpty());
		assertEquals(2, q.size());
		
		q.dequeue();
		q.dequeue();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testCopyConstructorOneElement() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		r = new Queue<Integer>(q);
		
		assertEquals(1, q.size());
		assertEquals(1, r.size());
	}

	@Test
	public void testCopyConstructorOneElementNotAliased() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		r = new Queue<Integer>(q);

		q.enqueue(2);
		assertEquals(1, (int)r.dequeue());
		assertTrue(r.isEmpty());
		assertEquals(2, q.size());
	}

	@Test
	public void testCopyConstructorTwoElements() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		q.enqueue(2);
		r = new Queue<Integer>(q);
		
		assertEquals(2, q.size());
		assertEquals(2, r.size());
	}

	@Test
	public void testCopyConstructorTwoElementsNotAliased() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		q.enqueue(2);
		r = new Queue<Integer>(q);

		q.enqueue(3);
		assertEquals(1, (int)r.dequeue());
		assertEquals(3, q.size());
		assertEquals(1, r.size());
	}
}
