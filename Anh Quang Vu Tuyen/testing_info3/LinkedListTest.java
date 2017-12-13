package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import testing.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void testRemove() {
		testing.LinkedList l = new testing.LinkedList();
		l.add(new Node<>("A"));
		l.deleteNode("A");
		equals(l.equals(null));
	}

}
