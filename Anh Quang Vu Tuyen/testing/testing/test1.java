package testing;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class test1 {

	@Test
	void test() {
		LinkedList<String> l = new LinkedList<>();
		l.add(new Node<>("A"));
		l.add(new Node<>("B"));
		l.add(new Node<>("C"));
		l.add(new Node<>("D"));
		l.delete("B");
		System.out.println(l.toString());
		assertTrue(l.toString().equals("D, C, A"));
	}
}
