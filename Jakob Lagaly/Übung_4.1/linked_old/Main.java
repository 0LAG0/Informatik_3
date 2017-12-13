/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ue4FurkimLagaly;

/**
 *
 * @author RonNegi
 */
public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(4);
        list.add(2);
        list.add(3);
        list.printValues();
        list.add(1, 44);
        list.printValues();
        list.removeIndex(1);
        list.printValues();

    }
}
