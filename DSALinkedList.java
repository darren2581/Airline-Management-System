import java.util.*;

public class DSALinkedList 
{
    private DSAListNode head; // reference to the first node in the list
    private DSAListNode tail; // reference to the last node in the list
    private int count;

    public DSALinkedList() // default constructor
    {
        head = null;
        tail = null;
        count = 0;
    }

    public void insertFirst(Object newValue) // insert a new node at the start of the list
    {
        DSAListNode newNode = new DSAListNode(newValue); // create a new node
        newNode.setNext(head); // set the next reference of the new node to the current head
        newNode.setPrev(null); // set the previous reference of the new node to null
        if (head == null) // if the list is empty
        {
            tail = newNode; // set the tail to the new node
        }
        else
        {
            head.setPrev(newNode); // set the previous reference of the current head to the new node
        }
        head = newNode; // set the head to the new node
        count++; // increment the count
    }

    public void insertLast(Object newValue) // insert a new node at the end of the list
    {
        DSAListNode newNode = new DSAListNode(newValue); // create a new node
        newNode.setNext(null); // set the next reference of the new node to null
        newNode.setPrev(tail); // set the previous reference of the new node to the current tail
        if (tail == null) // if the list is empty
        {
            head = newNode; // set the head to the new node
        }
        else
        {
            tail.setNext(newNode); // set the next reference of the current tail to the new node
        }
        tail = newNode; // set the tail to the new node
        count++; // increment the count
    }

    public Object removeFirst() // remove the first node from the list
    {
        Object value = null; // initialise the value to null
        if (isEmpty()) // if the list is empty
        {
            throw new IllegalArgumentException("List is empty"); // throw an exception
        }
        else
        {
            value = head.getValue(); // get the value of the head
            if (head.getNext() == null) // if the head is the only node in the list
            {
                head = null; // set the head to null
                tail = null; // set the tail to null
            }
            else
            {
                head = head.getNext(); // set the head to the next node
                head.setPrev(null); // set the previous reference of the new head to null
            }
        }
        count--; // decrement the count
        return value;
    }

    public Object removeLast() // remove the last node from the list
    {
        Object value; // initialise the value
        if (isEmpty()) // if the list is empty
        {
            throw new IllegalArgumentException("List is empty"); // throw an exception
        }
        else
        {
            value = tail.getValue(); // get the value of the tail
            if (tail.getPrev() == null) // if the tail is the only node in the list
            {
                head = null; // set the head to null
                tail = null; // set the tail to null
            }
            else
            {
                tail = tail.getPrev(); // set the tail to the previous node
                tail.setNext(null); // set the next reference of the new tail to null
            }
        }
        count--; // decrement the count
        return value;
    }

    public void remove(Object value) // remove a node with a specific value from the list
    {
        DSAListNode currNode = head; // initialise the current node to the head
        while (currNode != null) // while the current node is not null
        {
            if (currNode.getValue().equals(value)) // if the value of the current node is equal to the value to be removed
            {
                if (currNode == head) // if the current node is the head
                {
                    head = currNode.getNext(); // set the head to the next node
                    if (head != null) // if the head is not null
                    {
                        head.setPrev(null); // set the previous reference of the new head to null
                    }
                    if (currNode == tail) // if the current node is the tail
                    {
                        tail = null; // set the tail to null
                    }
                }
                else if (currNode == tail) // if the current node is the tail
                {
                    tail = currNode.getPrev(); // set the tail to the previous node
                    if (tail != null) // if the tail is not null
                    {
                        tail.setNext(null); // set the next reference of the new tail to null
                    }
                }
                else
                {
                    currNode.getPrev().setNext(currNode.getNext()); // set the next reference of the previous node to the next node
                    currNode.getNext().setPrev(currNode.getPrev()); // set the previous reference of the next node to the previous node
                }
                count--; // decrement the count
                break;
            }
            currNode = currNode.getNext(); // set the current node to the next node
        }
    }
    
    public String displayLinkedList() // display the linked list
    {
        String stringList = ""; // initialise the string list
        DSAListNode tempNode = head; // create a temporary node and set it to the head
        for (int i = 0; i < getCount(); i++) // for each node in the list
        {
            stringList += String.valueOf(head.getValue() + " "); // add the value of the node to the string list
            head = head.getNext();
        }
        head = tempNode;
        return stringList;
    }

    public boolean isEmpty() // check if the list is empty
    {
        return (head == null); // return true if the head is null
    }

    public int getCount() // get the number of nodes in the list
    {
        return count;
    }

    public Object peekFirst() // get the value of the first node in the list
    {
        Object nodeValue; // initialise the node value
        if(isEmpty()) // if the list is empty
        {
            throw new IllegalArgumentException("Empty Linked List");
        }
        else
        {
            nodeValue = head.getValue(); // get the value of the head
        }
        return nodeValue;
    }

    public Object peek(int index) // get the value of a node at a specific index
    {
        if (isEmpty()) // if the list is empty
        {
            throw new NoSuchElementException("List is empty");
        }
        if (index < 0 || index >= getCount()) // if the index is out of bounds
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        DSAListNode current = head; // initialise the current node to the head
        for (int i = 0; i < index; i++) // for each node in the list
        {
            current = current.getNext(); // set the current node to the next node
        }
        return current.getValue(); // return the value of the current node
    }

    public boolean contains(Object value) // check if the list contains a specific value
    {
        boolean found = false; // initialise the found variable to false
        DSAListNode current = head; // initialise the current node to the head
        while (current != null && !found) // while the current node is not null and the value has not been found
        {
            if (current.getValue().equals(value)) // if the value of the current node is equal to the value to be found
            {
                found = true; // set the found variable to true
            }
            current = current.getNext();
        }
        return found;
    }
}
