package testing;

public class LinkedList<E> {
    public testing.Node<E> current;


    public LinkedList() {
        current = null;
    }

    public void add(testing.Node<E> node) {
        current =
        if (current == null) {
            current = node;
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public void reverse() {
    }

    public void delete(E key) {
        testing.Node<E> temp = head;
        testing.Node<E> prev = null;
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
}