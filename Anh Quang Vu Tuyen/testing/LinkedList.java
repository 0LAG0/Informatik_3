package testing;

public class LinkedList<E> {
	public Node<E> head;

	public LinkedList() {
		head = null;
	}

	public void add(Node<E> node) {
		Node<E> current = head;
		if (head == null) {
			head = node;
			return;
		}
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
	}

	public void reverse() {
		Node<E> next;
		Node<E> current = head;
		Node<E> prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}
		head = prev;
	}

	public void delete(E key) {
		Node<E> temp = head;
		Node<E> prev = null;
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		if (temp == null) {
			return;
		}
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;

	}

	public String toString() {
		String result = "";
		Node<E> current = head;
		do {
		current = current.next;
		result += current.data + ",";
		}
		while (current.next != null);
		
		return result;
		//alles ausser Head wird ausgegeben
	}
}
