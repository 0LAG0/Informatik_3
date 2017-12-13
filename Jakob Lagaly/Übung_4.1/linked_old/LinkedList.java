/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ue4FurkimLagaly;
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
