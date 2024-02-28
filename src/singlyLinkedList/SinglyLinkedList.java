/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singlyLinkedList;
import singlyLinkedList.LinkedListNode;
import java.lang.String;
import nodeArray.ArrayNode;
/**
 *
 * @author Sarith
 */
public class SinglyLinkedList {
    public LinkedListNode head;

    public SinglyLinkedList(){
        head = null;
    }
    
    public void insertAtBack(String fullName, String NIC, String telephone, String email, String address, String data, ArrayNode[] array){
        LinkedListNode newNode = new LinkedListNode( fullName, NIC, telephone, email, address, data, array);
        if(isEmpty()){
            head = newNode;
        }else{
            LinkedListNode tempNode = head;
            while(tempNode.link != null){
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
        }
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("LinkedList is empty.");
        }else{
            LinkedListNode tempNode = head;
            System.out.println(tempNode.fullName);
        }
    }
    
    public boolean isEmpty(){
        return (head == null);
    }

}
