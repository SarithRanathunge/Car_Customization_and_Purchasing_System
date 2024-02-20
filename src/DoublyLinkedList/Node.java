/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoublyLinkedList;

/**
 *
 * @author Sarith
 */
public class Node {
    public String item;
    public double price;
    public Node prev;
    public Node next;
    
    public Node(String item, double price){
        this.item = item;
        this.price = price;
        prev = null;
        next = null;
    }
}
