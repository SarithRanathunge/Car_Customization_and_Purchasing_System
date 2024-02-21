/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoublyLinkedList;

/**
 *
 * @author Sarith
 */
import DoublyLinkedList.Node;

public class DoublyLinkedList {
    public Node head;
    public Node tail;
    
    public DoublyLinkedList(){
        head = null;
        tail = null;
    }
    
    public void insertAtEnd(String item, double price){
        Node newNode = new Node(item, price);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }
}
