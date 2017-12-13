package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void testRemove() {
		LinkedList l = new LinkedList();
		l.add(new Node<>("A"));
		l.deleteNode("A");
		equals(l.equals(null));
	}

}
