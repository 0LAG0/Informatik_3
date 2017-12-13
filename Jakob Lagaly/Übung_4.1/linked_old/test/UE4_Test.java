package Ue4FurkimLagaly.test;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Ue4FurkimLagaly.LinkedList;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author RonNegi
 */
public class UE4_Test {

    public LinkedList list;

    public UE4_Test() {
    }

    @Before
    public void setUp() {
        list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void testAdd() {

        assertTrue(list.size() == 3);
    }

    @Test
    public void testAddIndex() {
        int data = (int) list.iterateForward(1, null).data;
        assertTrue(data == 1);
        list.add(1, 5);
        int data1 = (int) list.iterateForward(1, null).data;
        assertTrue(data1 == 5);
    }

    @Test
    public void testContains() {
        int contains = (int) list.contains(2);
        assertTrue(contains == 2);
    }

    @Test
    public void testIndexOf() {
        assertTrue(list.indexOf(2) == 2);
    }

    @Test
    public void testRemove() {
        list.remove(2);
        assertTrue(list.iterateForward(1, 2) == null);
    }

    @Test
    public void testRemoveIndex() {
        list.printValues();
        int val = (int) list.iterateForward(1, null).data;
        assertTrue(val == 1);

        System.out.println(list.removeIndex(1));
        list.printValues();
        int val1 = (int) list.iterateForward(1, null).data;

        assertFalse(val1 == 1);
    }
}
