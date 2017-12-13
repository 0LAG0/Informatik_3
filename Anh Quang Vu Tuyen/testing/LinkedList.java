package testing;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList implements List<Object> {



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



    /* * appends the specified value to the end of this list

     * @param value the value to be appended

     */

    @Override

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



    /**

     * inserts the specified value at the specified position in this list

     *

     * @param index - index at which the specified value has to be inserted

     * @param value - value to be inserted

     * @throws IndexOutOfBoundsException if the index is out of range (<0 or

     * >size())

     */

    @Override

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



    /**

     * tests if the specified value is contained in this list

     *

     * @param value - value whose presence in this list is to be tested

     * @return the value, if value is contained in this list; null, otherwise

     */

    @Override

    public Object contains(Object value) {

        if (iterateForward(1, value) != null) {

            Node node = iterateForward(1, value);

            return node.data;

        } else {

            return null;

        }

    }



    /**

     * returns the index of the first occurrence of the specified value in this

     * list

     *

     * @param value - value to search for

     * @return the index of the first occurrence of the specified value in this

     * list, or -1, if this list does not contain the value

     */

    @Override

    public int indexOf(Object value) {

        if (iterateForward(1, value) != null) {

            return counter_g;

        } else {

            return -1;

        }

    }



    /**

     * removes the first occurrence of the specified value from this list

     *

     * @param value - the value to be removed from this list, if present

     * @return the removed value, it it is contained in the list; null,

     * otherwise

     */

    @Override

    public Object remove(Object value) {

        Node nodeToDelete;

        nodeToDelete = iterateForward(0, value);

        return removeNode(nodeToDelete);

    }



    /**

     * removes the value at the specified index in this list

     *

     * @param index - the index of the element to be removed

     * @return the element previously at the specified position

     * @throws IndexOutOfBoundsException if the index is out of range (<0 or

     * >=size())

     */

    @Override

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



    /**

     * returns the value at the specified position in this list

     *

     * @param index - the index of the value to be returned

     * @return the value at the specified position in this list

     * @throws IndexOutOfBoundsException if the index is out of range (<0 or

     * >=size())

     */

    @Override

    public Object get(int index) {

        if (number / 2 < index) {

            return iterateBackward(index, null);

        } else {

            return iterateForward(index, null);

        }

    }



    /**

     * gives the number of elements in this list

     *

     * @return the number of values in this list

     */

    @Override

    public int size() {

        return number;

    }

    /*

     Print values of all Nodes in Linked List

     */



    public void printValues() {

        Node tmp = head;

        int counter = 0;

        while (counter <= number && (!(tmp == null))) {

            System.out.println(tmp.data);

            tmp = tmp.next;

            counter++;

        }

    }



    /**

     * Remove Node from LinkedList

     *

     * @param nodeToDelete

     * @return value of deleted Node

     */

    public Object removeNode(Node nodeToDelete) {

        nodeToDelete.next.prev = nodeToDelete.prev;

        nodeToDelete.prev.next = nodeToDelete.next;

        nodeToDelete.next = null;

        nodeToDelete.prev = null;

        number--;

        return nodeToDelete.data;

    }



    /**

     * Iterate (from tail) through all nodes and find Node x on Index i OR

     * Iterate through all nodes and finde Node x with Value v

     *

     * @param index (index of Node-Element)

     * @param value (Value of Node-Element)

     * @return Found Node Element

     */

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



    /**

     * Iterate (from head) through all nodes and find Node x on Index i OR

     * Iterate through all nodes and finde Node x with Value v

     *

     * @param index (index of Node-Element)

     * @param value (Value of Node-Element)

     * @return Found Node Element

     */

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



	@Override
	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean addAll(Collection<? extends Object> arg0) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean addAll(int arg0, Collection<? extends Object> arg1) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public ListIterator<Object> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ListIterator<Object> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Object remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Object set(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Object> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
