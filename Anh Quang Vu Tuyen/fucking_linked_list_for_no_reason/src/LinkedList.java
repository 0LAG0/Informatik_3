import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList {



    public int number = 0;

    public Node head;

    public Node tail;

    public int counter_g;



    public LinkedList() {

        head = new Node("start");

        tail = new Node("ende");

        head.next = tail;

        tail.prev = head;

        tail.next = null;

    }

    public void add(Object value) {

        int counter = 0;

        Node newNode = new Node(value);

        Node current = head;

        // Insert the first Node;



        while (!(current.next == null) && number < counter) {

            current = current.next;

            counter++;

        }

        current.next = newNode;

        newNode.prev = current;

        newNode.next = tail;

        tail.prev = newNode;

        System.out.println("Node added. Value: " + value);

        number++;

    }

    public void add(int index, Object value) {

        Node newNode = new Node(value);

        if (index == 0) {

            Node nodeOnIndex = iterateForward(index, null);

            newNode.setPrev(head);

            newNode.setNext(nodeOnIndex);

            nodeOnIndex.getPrev().setNext(newNode);

            nodeOnIndex.setPrev(newNode);

            number++;

        } else {

            Node nodeOnIndex = iterateForward(index, null);

            newNode.setPrev(nodeOnIndex.prev);

            newNode.setNext(nodeOnIndex);

            nodeOnIndex.getPrev().setNext(newNode);

            nodeOnIndex.setPrev(newNode);

            number++;

        }

    }

    public Object contains(Object value) {

        if (iterateForward(1, value) != null) {

            Node node = iterateForward(1, value);

            return node.data;

        } else {

            return null;

        }

    }

    public int indexOf(Object value) {

        if (iterateForward(1, value) != null) {

            return counter_g;

        } else {

            return -1;

        }

    }

    @Override

    public Object remove(Object value) {

        Node nodeToDelete;

        nodeToDelete = iterateForward(0, value);

        return removeNode(nodeToDelete);

    }

    public Object removeIndex(int index) {

        Node nodeToDelete;

        if (number / 2 >= index) {

            nodeToDelete = iterateForward(index, null);

            return removeNode(nodeToDelete);

        }

        if (number / 2 <= index) {

            nodeToDelete = iterateBackward(index, null);

            return removeNode(nodeToDelete);

        }

        return null;

    }

    public Object get(int index) {

        if (number / 2 < index) {

            return iterateBackward(index, null);

        } else {

            return iterateForward(index, null);

        }

    }

    public int size() {

        return number;

    }

    public void printValues() {

        Node tmp = head;

        int counter = 0;

        while (counter <= number && (!(tmp == null))) {

            System.out.println(tmp.data);

            tmp = tmp.next;

            counter++;

        }

    }

    public Object removeNode(Node nodeToDelete) {

        nodeToDelete.next.prev = nodeToDelete.prev;

        nodeToDelete.prev.next = nodeToDelete.next;

        nodeToDelete.next = null;

        nodeToDelete.prev = null;

        number--;

        return nodeToDelete.data;

    }

    public Node iterateBackward(int index, Object value) {

        Node tmp = tail;

        counter_g = 0;

        int counter = number;

        if (value == null) {

            while (tmp != null && counter > 0) {

                if (index == counter) {

                    return tmp;

                }

                tmp = tmp.prev;

                counter--;

            }

        } else {

            while (tmp != null && counter > 0) {

                if (tmp.data == value) {

                    return tmp;

                }

                tmp = tmp.prev;

                counter--;

            }

        }
        return null;
    }

    public Node iterateForward(int index, Object value) {

        Node tmp = head;

        counter_g = 0;

        int counter = 0;

        if (value == null) {

            while (tmp != null && counter <= number) {

                if (index == counter) {

                    return tmp;

                }

                tmp = tmp.next;

                counter_g++;

                counter++;

            }

        } else {

            while (tmp != null && counter <= number) {

                if (tmp.data == value) {

                    return tmp;

                }

                tmp = tmp.next;

                counter_g++;

                counter++;

            }

        }



        return null;

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

    void deleteNode(E key) {
        // Store head node
        Node<E> temp = Head;
        Node<E>	prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            Head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }
}