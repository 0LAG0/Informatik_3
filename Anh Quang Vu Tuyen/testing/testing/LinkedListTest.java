package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


class LinkedListTest {

	@Test
	void testRemove() {
		LinkedList l = new LinkedList();
		l.add(new Node ("A"));
		l.delete("A");
		System.out.println("kmkalmdlag");
		assertEquals(null,l);
	}

}
