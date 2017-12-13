package testing;

class LinkedList<E> {
	public Node<E> Head;

	LinkedList() {
		Head = null;
	}

	public boolean isEmpty() {
		return (Head == null);
	}

	void add(Node<E> node) {

		Node<E> current = Head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
	}

	// Remove FirstLink
	public Node<E> removeFirst() {
		Node<E> newFirst = Head.next;
		if (!isEmpty()) {
			Head = Head.next;
		} else {
			System.out.println("Emptiness");
		}
		return newFirst;
	}

	// iterating

	public void display() {
		Node<E> currentLink = Head;
		while (currentLink != null) {
			currentLink.toString();

			System.out.println("Next Link: " + currentLink.next);

			currentLink = currentLink.next;
		}
	}

	public void reverse() {
		Node<E> prev = null;
		Node<E> current = Head;
		Node<E> next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		Head = prev;
	}
}
