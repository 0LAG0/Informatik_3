package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

class test1 {

	@Test
	void add() {
		LinkedList<String> l = new LinkedList<>();
		l.add(new Node<>("A"));
		System.out.println(l.head.data);
		assertTrue(l.head.data == "A" );
	}
	@Test
	void add2() {
		LinkedList<String> l = new LinkedList<>();
		l.add(new Node<>("A"));
		l.add(new Node<>("B"));
		System.out.println(l.head.data);

		assertTrue(l.head.next.data == "B" );
	}
	@Test
	void removeA() {
		LinkedList<String> l = new LinkedList<>();
		l.add(new Node<>("A"));
		System.out.println("_______________________________________");
		System.out.println(l.head.data);
		l.delete("A");
		System.out.println(l.head);
		assertTrue(l.head == null);
	}
	
	@Test
	void removeB() {
		LinkedList<String> l = new LinkedList<>();
		l.add(new Node<>("A"));
		l.add(new Node<>("B"));
		l.add(new Node<>("C"));
		System.out.println("__________________________________________");
		System.out.println(l.head.data);
		l.delete("B");
		System.out.println(l.head);
		assertTrue(l.head.next.data == "C");
	}
	
	@Test
	void reverse() {
		LinkedList<String> l = new LinkedList<>();
		l.add(new Node<>("A"));
		l.add(new Node<>("B"));
		l.add(new Node<>("C"));
		l.add(new Node<>("D"));
		l.add(new Node<>("E"));
		System.out.println("_________________________________________");
		System.out.println(l.head.data);
		l.reverse();
		
		System.out.println(l.head.data);
		System.out.println(l.head.next.data);
		System.out.println(l.toString());
		assertTrue(l.head.data == "E");
		
	}
	
	

}
