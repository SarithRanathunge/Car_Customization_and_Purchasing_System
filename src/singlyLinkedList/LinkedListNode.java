/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singlyLinkedList;
import nodeArray.ArrayNode;
/**
 *
 * @author Sarith
 */
public class LinkedListNode {

    public String fullName;
    public String NIC;
    public String telephone;
    public String email;
    public String address;
    public String data;
    public ArrayNode[] array;
    public int arraySize;
    public LinkedListNode link;

    public LinkedListNode(String fullName, String NIC, String telephone, String email, String address, String data, ArrayNode[] array) {
        this.fullName = fullName;
        this.NIC = NIC;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.data = data;
        this.array = array;
        link = null;
    }
}
