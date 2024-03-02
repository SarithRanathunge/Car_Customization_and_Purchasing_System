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
    
    //constructor
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
    
    // Merge sort for each node price minimum to maximum
    public void mergeSortMinToMax() {
        head = mergeSortMinToMaxRec(head);
        // Reset tail pointer
        tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
    }

    private Node mergeSortMinToMaxRec(Node listHead) {
        if (listHead == null || listHead.next == null) {
            return listHead; // Already sorted or only one element
        }
        
        // Split the list into two halves
        Node middle = getMiddle(listHead);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        // Recursively sort the two halves
        Node left = mergeSortMinToMaxRec(listHead);
        Node right = mergeSortMinToMaxRec(nextOfMiddle);

        // Merge the sorted halves
        return mergeMinToMax(left, right);
    }

    // Merge two sorted linked lists for minimum to maximum order
    private Node mergeMinToMax(Node left, Node right) {
        Node result = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // Compare prices and merge
        if (left.price <= right.price) {
            result = left;
            result.next = mergeMinToMax(left.next, right);
            result.next.prev = result;
            result.prev = null; // Necessary for proper DLL formation
        } else {
            result = right;
            result.next = mergeMinToMax(left, right.next);
            result.next.prev = result;
            result.prev = null; // Necessary for proper DLL formation
        }

        return result;
    }

    // Merge sort for each node price maximum to minimum
    public void mergeSortMaxToMin() {
        head = mergeSortMaxToMinRec(head);
        // Reset tail pointer
        tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
    }

    private Node mergeSortMaxToMinRec(Node listHead) {
        if (listHead == null || listHead.next == null) {
            return listHead; // Already sorted or only one element
        }
        
        // Split the list into two halves
        Node middle = getMiddle(listHead);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        // Recursively sort the two halves
        Node left = mergeSortMaxToMinRec(listHead);
        Node right = mergeSortMaxToMinRec(nextOfMiddle);

        // Merge the sorted halves
        return mergeMaxToMin(left, right);
    }

    // Merge two sorted linked lists for maximum to minimum order
    private Node mergeMaxToMin(Node left, Node right) {
        Node result = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // Compare prices and merge
        if (left.price >= right.price) {
            result = left;
            result.next = mergeMaxToMin(left.next, right);
            result.next.prev = result;
            result.prev = null; // Necessary for proper DLL formation
        } else {
            result = right;
            result.next = mergeMaxToMin(left, right.next);
            result.next.prev = result;
            result.prev = null; // Necessary for proper DLL formation
        }

        return result;
    }

    // Helper method to find the middle of the linked list
    private Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // Merge sort for each node string A to Z
    public void mergeSortAToZ() {
        head = mergeSortAToZRec(head);
        // Reset tail pointer
        tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
    }

    private Node mergeSortAToZRec(Node listHead) {
        if (listHead == null || listHead.next == null) {
            return listHead; // Already sorted or only one element
        }
        
        // Split the list into two halves
        Node middle = getMiddle(listHead);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        // Recursively sort the two halves
        Node left = mergeSortAToZRec(listHead);
        Node right = mergeSortAToZRec(nextOfMiddle);

        // Merge the sorted halves
        return mergeAToZ(left, right);
    }

    // Merge two sorted linked lists for A to Z order
    private Node mergeAToZ(Node left, Node right) {
        Node result = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // Compare strings and merge
        if (left.item.compareTo(right.item) <= 0) {
            result = left;
            result.next = mergeAToZ(left.next, right);
            result.next.prev = result;
            result.prev = null; // Necessary for proper DLL formation
        } else {
            result = right;
            result.next = mergeAToZ(left, right.next);
            result.next.prev = result;
            result.prev = null; // Necessary for proper DLL formation
        }

        return result;
    }

    // Merge sort for each node string Z to A
    public void mergeSortZToA() {
        head = mergeSortZToARec(head);
        // Reset tail pointer
        tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
    }

    private Node mergeSortZToARec(Node listHead) {
        if (listHead == null || listHead.next == null) {
            return listHead; // Already sorted or only one element
        }
        
        // Split the list into two halves
        Node middle = getMiddle(listHead);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        // Recursively sort the two halves
        Node left = mergeSortZToARec(listHead);
        Node right = mergeSortZToARec(nextOfMiddle);

        // Merge the sorted halves
        return mergeZToA(left, right);
    }

    // Merge two sorted linked lists for Z to A order
    private Node mergeZToA(Node left, Node right) {
        Node result = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // Compare strings and merge
        if (left.item.compareTo(right.item) >= 0) {
            result = left;
            result.next = mergeZToA(left.next, right);
            result.next.prev = result;
            result.prev = null; // Necessary for proper DLL formation
        } else {
            result = right;
            result.next = mergeZToA(left, right.next);
            result.next.prev = result;
            result.prev = null; // Necessary for proper DLL formation
        }

        return result;
    }

    // Helper method to find the middle of the linked list
    private Node getMiddleValue(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
